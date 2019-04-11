package com.example.demo.bean;

import java.math.BigDecimal;

public class SearchFilmForm {
    private String title ;
    private String rating;
    private Integer releaseYear;
    private BigDecimal replacementCost;
    private Integer length;

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public Integer getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "SearchFilmForm{" +
                "title='" + title + '\'' +
                ", rating='" + rating + '\'' +
                ", releaseYear=" + releaseYear +
                ", replacementCost=" + replacementCost +
                ", length=" + length +
                '}';
    }
}
