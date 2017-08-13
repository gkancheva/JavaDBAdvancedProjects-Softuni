package com.softuni.services.api;

import com.softuni.models.bindingModels.game.BaseGame;
import com.softuni.models.viewModels.game.GameView;

import java.util.List;

/**
 * Created on 31.7.2017 г..
 */
public interface GameService {
    void persist(BaseGame game);
    void deleteGame(long id);

    <T extends BaseGame> T findById(long id, Class<T> tClass);

    <T extends BaseGame> T findByTitle(String title, Class<T> tClass);

    List<GameView> getAll();

    List<GameView> findAllGamesOwnedByUser(long userId);

}
