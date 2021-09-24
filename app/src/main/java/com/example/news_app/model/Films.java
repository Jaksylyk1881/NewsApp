package com.example.news_app.model;

public class Films {

    int filmId;
    String filmRating;
    String filmTitle, filmDesc, filmDate, filmImage;

    public Films(int filmId, String filmTitle, String filmDesc, String filmDate, String filmImage, String filmRating) {
        this.filmId = filmId;
        this.filmTitle = filmTitle;
        this.filmDesc = filmDesc;
        this.filmDate = filmDate;
        this.filmImage = filmImage;
        this.filmRating = filmRating;
    }
    public Films(){

    }

    public String getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(String filmRating) {
        this.filmRating = filmRating;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmDesc() {
        return filmDesc;
    }

    public void setFilmDesc(String filmDesc) {
        this.filmDesc = filmDesc;
    }

    public String getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(String filmDate) {
        this.filmDate = filmDate;
    }

    public String getFilmImage() {
        return filmImage;
    }

    public void setFilmImage(String filmImage) {
        this.filmImage = filmImage;
    }
}
