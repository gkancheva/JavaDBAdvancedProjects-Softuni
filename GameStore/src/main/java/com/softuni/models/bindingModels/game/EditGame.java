package com.softuni.models.bindingModels.game;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created on 1.8.2017 г..
 */
public class EditGame extends BaseGame{
    private long id;

    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 symbols long")
    @Pattern(regexp = "[A-Z]+.+", message = "Title must start wit Uppercase letter")
    private String title;

    @DecimalMin(value = "0.00", message = "Price must be positive.")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    private BigDecimal price;
    private double size;

    @Size(min = 11, max = 11, message = "Trailer must be 11 symbols long.")
    private String trailer;

    @Pattern(regexp = "((http:\\/\\/)|(https:\\/\\/)).+", message = "Invalid thumbnail format.")
    private String thumbnailUrl;

    @Size(min = 20)
    private String description;
    private Date releaseDate;

    public EditGame() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
