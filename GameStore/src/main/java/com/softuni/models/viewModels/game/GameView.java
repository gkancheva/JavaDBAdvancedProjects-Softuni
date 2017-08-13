package com.softuni.models.viewModels.game;

import com.softuni.models.bindingModels.game.BaseGame;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 1.8.2017 г..
 */
public class GameView extends BaseGame {
    private String title;
    private BigDecimal price;
    private double size;
    private String trailer;
    private String thumbnail;
    private String description;
    private Date releaseDate;

    public GameView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Title: %s%n", this.getTitle()))
                .append(String.format("Price: %.2f%n", this.getPrice()))
                .append(String.format("Size: %.2f%n", this.getSize()))
                .append(String.format("Trailer: %s%n", this.getTrailer()))
                .append(String.format("Thumbnail URL: %s%n", this.getThumbnail()))
                .append(String.format("Description: %s%n", this.getDescription()))
                .append(String.format("Release date: %s",
                        new SimpleDateFormat("dd-MM-yyyy")
                                .format(this.getReleaseDate())));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameView)) return false;

        GameView gameView = (GameView) o;

        return getTitle() != null ? getTitle().equals(gameView.getTitle()) : gameView.getTitle() == null;
    }

    @Override
    public int hashCode() {
        return getTitle() != null ? getTitle().hashCode() : 0;
    }
}
