package com.shoeARstore;

/**
 * Created by apple on 15/03/16.
 */
public class Beanlist {

    private String image;
    private String title;
    private String price;
    private String cutprice;
    private String discount;
    private String ratingtext;
    private float rating;
    private String id;
    private String favorites;

    public Beanlist(String image, String title, String price, String cutprice, String discount, String ratingtext, float rating, String id,String favorites) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.cutprice = cutprice;
        this.discount = discount;
        this.ratingtext = ratingtext;
        this.rating=rating;
        this.id=id;
        this.favorites=favorites;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public String getCutprice() {
        return cutprice;
    }

    public void setCutprice(String cutprice) {
        this.cutprice = cutprice;
    }



    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }




    public String getRatingtext() {
        return ratingtext;
    }

    public void setRatingtext(String ratingtext) {
        this.ratingtext = ratingtext;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
