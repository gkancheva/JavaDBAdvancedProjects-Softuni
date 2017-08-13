package com.softuni.models.bindingModels.game;

/**
 * Created on 1.8.2017 г..
 */
public class DeleteGame extends BaseGame {
    private long id;
    private String title;

    public DeleteGame() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
