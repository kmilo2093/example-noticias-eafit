package noticiaseafitadmin.factory;

import lib.json.JSONException;
import lib.json.JSONObject;
import noticiaseafitadmin.model.News;
import noticiaseafitadmin.model.User;

/**
 *
 * @author Rodrigo
 */
public class Factory {

    public static User getUser(JSONObject obj) throws JSONException {
        if (obj.has("User")) {
            obj = obj.getJSONObject("User");
        }
        return new User(
                obj.getInt("id"),
                obj.getString("username"),
                obj.getString("password"));
    }

    public static News getNews(JSONObject obj) throws JSONException {
        if (obj.has("News")) {
            obj = obj.getJSONObject("News");
        }
        return new News(
                obj.getInt("id"),
                obj.getString("title"),
                obj.getString("brief"),
                obj.getString("content"),
                obj.getString("date"));
    }
}
