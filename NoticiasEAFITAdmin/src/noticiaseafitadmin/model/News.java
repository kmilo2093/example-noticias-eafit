package noticiaseafitadmin.model;

import java.util.HashMap;
import java.util.Map;
import lib.json.JSONTokener;

/**
 *
 * @author Rodrigo
 */
public class News {

    private int id;
    private String title;
    private String brief;
    private String content;
    private String date;

    public News(int id, String title, String brief, String content, String date) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.date = date;
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Sets">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String conent) {
        this.content = conent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    // </editor-fold>

    public HashMap<String, Object> getMap() {
        HashMap<String, Object> newsMap = new HashMap<>();
        newsMap.put("id", getId());
        newsMap.put("title", getTitle());
        newsMap.put("brief", getBrief());
        newsMap.put("content", getContent());
        newsMap.put("date", getDate());
        return newsMap;
    }

    @Override
    public String toString() {
        return "<html><b>" + title + "</b> - " + brief + "</html>";
    }
}
