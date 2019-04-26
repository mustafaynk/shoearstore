package orderspage;

/**
 * Shoe Ar Store
 */
public class BeanclassOrderDetail {

    private String image;
    private String orderday;
    private String ordername;
    private String qt;
    private String date;
    private String idnumber;
    private int progress;

    public BeanclassOrderDetail(String image, String orderday, String ordername, String qt, String date, String idnumber, int progress) {
        this.image = image;
        this.orderday = orderday;
        this.ordername = ordername;
        this.qt = qt;
        this.date = date;
        this.idnumber = idnumber;
        this.progress=progress;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrderday() {
        return orderday;
    }

    public void setOrderday(String orderday) {
        this.orderday = orderday;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }



}

