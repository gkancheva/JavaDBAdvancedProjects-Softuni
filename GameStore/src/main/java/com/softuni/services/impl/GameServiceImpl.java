package com.softuni.services.impl;

import com.softuni.entities.Game;
import com.softuni.modelParser.ModelParser;
import com.softuni.models.bindingModels.game.AddGame;
import com.softuni.models.bindingModels.game.BaseGame;
import com.softuni.models.bindingModels.game.DeleteGame;
import com.softuni.models.bindingModels.game.EditGame;
import com.softuni.models.viewModels.game.GameView;
import com.softuni.repositories.GameRepository;
import com.softuni.services.api.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 31.7.2017 г..
 */
@Service
public class GameServiceImpl implements GameService {
    private final GameRepository repository;

    @Autowired
    public GameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public void persist(BaseGame gameToSave) {
        Game game = ModelParser.getInstance().map(gameToSave, Game.class);
        this.repository.saveAndFlush(game);
    }

    @Override
    public void deleteGame(long id) {
        Game game = this.repository.findOne(id);
        this.repository.delete(game);
    }

    @Override
    public <T extends BaseGame> T findById(long id, Class<T> tClass) {
        Game game = this.repository.findOne(id);
        if(game != null) {
            return ModelParser.getInstance().map(game, tClass);
        }
        return null;
    }

    @Override
    public <T extends BaseGame> T findByTitle(String title, Class<T> tClass) {
        Game game = this.repository.findByTitle(title);
        if(game != null) {
            return ModelParser.getInstance().map(game, tClass);
        }
        return null;
    }

    @Override
    public List<GameView> getAll() {
        List<Game> games = this.repository.findAll();
        List<GameView> gameViews = new ArrayList<>();
        for (Game game : games) {
            GameView gameView = ModelParser.getInstance().map(game, GameView.class);
            gameViews.add(gameView);
        }
        return gameViews;
    }

    @Override
    public List<GameView> findAllGamesOwnedByUser(long userId) {
        List<Game> games = this.repository.findAllGamesByUserId(userId);
        List<GameView> gameViews = new ArrayList<>();
        for (Game game : games) {
            GameView gameView = ModelParser.getInstance().map(game, GameView.class);
            gameViews.add(gameView);
        }
        return gameViews;
    }
}
