package yorumlarsayfasi;

/**
 * Created by apple on 15/03/16.
 *
 * //********LISTVIEW************
 */
public class BeanclassReview {


    private String title;
    private String rateno;
    private String date;
    private String username;
    private String description;
    private String like;

    public BeanclassReview(String title, String rateno, String date, String username, String description, String like) {
        this.title = title;
        this.rateno = rateno;
        this.date = date;
        this.username = username;
        this.description = description;
        this.like = like;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRateno() {
        return rateno;
    }

    public void setRateno(String rateno) {
        this.rateno = rateno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}


