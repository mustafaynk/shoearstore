package favoritespage;

/**
 * Slide And Drag
 */

public class FavBeanlist {
    private String image;
    private String title;
    private String stockcode;
    private String price;

    public FavBeanlist(String image, String title, String stockcode, String price) {
        this.image = image;
        this.title = title;
        this.stockcode = stockcode;
        this.price = price;
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
