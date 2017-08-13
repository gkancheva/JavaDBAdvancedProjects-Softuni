package com.softuni.commands.gameCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.models.bindingModels.game.ShoppingGame;
import com.softuni.models.bindingModels.user.ShoppingUser;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.Session;

import java.text.ParseException;

/**
 * Created on 1.8.2017 г..
 */
public class AddToShoppingCartCommand extends BaseCommand {
    public AddToShoppingCartCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) throws ParseException {
        if(Session.getLoggedInUser() == null) {
            return "No logged in user.";
        }
        long userId = Session.getLoggedInUser().getId();
        String gameTitle = args[0];
        ShoppingGame gameToBuy = super.getGameService().findByTitle(gameTitle, ShoppingGame.class);
        if(gameToBuy == null) {
            return String.format("There is no game with title: %s", gameTitle);
        }
        ShoppingUser user = super.getUserService().findById(userId);
        if(user.hasGameInShoppingCart(gameToBuy)) {
            return String.format("Game %s already exists in the cart", gameTitle);
        }
        if(user.ownAlreadyGame(gameToBuy)) {
            return String.format("Game %s is already owned by you.", gameTitle);
        }
        user.addToCart(gameToBuy);
        super.getUserService().persist(user);
        return String.format("Game with title: %s was successfully added to cart.",
                gameTitle);
    }
}
