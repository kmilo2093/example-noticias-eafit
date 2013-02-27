/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package noticiaseafitadmin.ctrl;

import java.util.HashMap;
import lib.json.JSONArray;
import lib.json.JSONObject;
import noticiaseafitadmin.enums.Service;
import noticiaseafitadmin.enums.ServiceType;
import noticiaseafitadmin.factory.Factory;
import noticiaseafitadmin.model.News;
import noticiaseafitadmin.webservice.WSAccess;

public class NewsCtrl {

    // <editor-fold defaultstate="collapsed" desc="Singleton Implementation">
    private static NewsCtrl ctrl;

    public static NewsCtrl getInstance() {
        if (ctrl == null) {
            ctrl = new NewsCtrl();
        }
        return ctrl;
    }
    // </editor-fold>
    private WSAccess ws;

    private NewsCtrl() {
        ws = new WSAccess();
    }

    public News[] getNews() throws Exception {
        JSONArray newsArray = ws.getJSONArray(new HashMap(), ServiceType.GET, Service.NewsService);
        News[] array = new News[newsArray.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = Factory.getNews(newsArray.getJSONObject(i));
        }
        return array;
    }

    public void create(News news) throws Exception {
        HashMap<String, String> parameters = new HashMap<>();
        String obj = new JSONObject(news.getMap()).toString();
        System.out.println(obj);
        parameters.put("News", new JSONObject(news.getMap()).toString());

        ws.getJSONObject(parameters, ServiceType.POST, Service.NewsService);
    }
}
