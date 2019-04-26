package com.shoeARstore;

/**
 * Created by apple on 15/03/16.
 */
public class CartListBeanlist {

    private String image;
    private String title;
    private String stockcode;
    private String price;
    private String piece;
    private String size;
    private String id;

    public CartListBeanlist(String image, String title, String price, String stockcode, String piece, String size, String id) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.stockcode=stockcode;
        this.piece=piece;
        this.size=size;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
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

    public String getStockcode() {
        return stockcode;
    }

    public void setStockcode(String stockcode) {
        this.stockcode = stockcode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
