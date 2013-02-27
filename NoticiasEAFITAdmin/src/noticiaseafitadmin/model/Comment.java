package noticiaseafitadmin.model;

/**
 *
 * @author Rodrigo
 */
public class Comment {

    private int id;
    private News news;
    private User user;
    private String date;
    private String comment;

    public Comment(int id, News news, User user, String date, String comment) {
        this.id = id;
        this.news = news;
        this.user = user;
        this.date = date;
        this.comment = comment;
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Sets">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    // </editor-fold>
}
