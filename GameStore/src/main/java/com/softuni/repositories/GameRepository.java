package com.softuni.repositories;

import com.softuni.entities.Game;
import com.softuni.models.viewModels.game.GameView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 31.7.2017 г..
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByTitle(String title);

    @Query("SELECT u.boughtGames FROM User AS u WHERE u.id = :userId")
    List<Game> findAllGamesByUserId(@Param("userId") long userId);
}
