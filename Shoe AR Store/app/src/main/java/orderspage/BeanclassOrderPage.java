package orderspage;

/**
 * Shoe Ar Store
 */
public class BeanclassOrderPage {

    private int status;
    private String price;
    private String orderno;
    private  String orderdate;

    public BeanclassOrderPage(int status, String price, String orderno, String orderdate) {
        this.status=status;
        this.price = price;
        this.orderno=orderno;
        this.orderdate=orderdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
}

