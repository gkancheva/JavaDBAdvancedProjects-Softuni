package com.softuni.commands.gameCommands;

import com.softuni.commands.BaseCommand;
import com.softuni.entities.enums.Role;
import com.softuni.models.bindingModels.game.AddGame;
import com.softuni.models.bindingModels.game.EditGame;
import com.softuni.services.api.GameService;
import com.softuni.services.api.UserService;
import com.softuni.utils.DataValidator;
import com.softuni.utils.Session;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created on 1.8.2017 г..
 */
public class EditGameCommand extends BaseCommand {

    public EditGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... args) {
        if(Session.getLoggedInUser() == null) {
            return "No user logged in.";
        }
        if(Session.getLoggedInUser().getRole() != Role.ADMIN) {
            return "Only admins can add game.";
        }
        long id = Long.parseLong(args[0]);
        EditGame editGame = super.getGameService().findById(id, EditGame.class);
        if(null == editGame) {
            return "Invalid game id.";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            for (int i = 1; i < args.length; i++) {
                String fieldName = args[i].split("=")[0];
                String fieldValue = args[i].split("=")[1];
                switch (fieldName) {
                    case "title": editGame.setTitle(fieldValue); break;
                    case "price": editGame.setPrice(new BigDecimal(fieldValue)); break;
                    case "size": editGame.setSize(Double.parseDouble(fieldValue)); break;
                    case "trailer": editGame.setTrailer(fieldValue); break;
                    case "thumbnail": editGame.setThumbnailUrl(fieldValue); break;
                    case "description": editGame.setDescription(fieldValue); break;
                    case "releaseDate": editGame.setReleaseDate(sdf.parse(fieldValue)); break;
                    default: break;
                }
            }
            if(!DataValidator.checkIsValid(editGame)) {
                return DataValidator.getInvalidParameterMessage(editGame);
            }
            super.getGameService().persist(editGame);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.format("Successfully edited game with id#%s.", args[0]);
    }
}
