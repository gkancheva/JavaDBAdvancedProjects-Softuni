package com.softuni.entities;

import com.softuni.models.bindingModels.user.BaseUser;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 31.7.2017 г..
 */
@Entity
@Table(name = "games")
public class Game extends BaseUser {
    private long id;
    private String title;
    private String trailer;
    private String thumbnailUrl;
    private double size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public Game() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "title", unique = true)
    public String getTitle() {
        return title;
    }

    @Column(name = "trailer")
    public String getTrailer() {
        return trailer;
    }

    @Column(name = "thumbnail_url")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Column(name = "size")
    public double getSize() {
        return size;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
