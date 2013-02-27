package noticiaseafitadmin.webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Map;
import lib.json.JSONArray;
import lib.json.JSONException;
import lib.json.JSONObject;
import noticiaseafitadmin.enums.Service;
import noticiaseafitadmin.enums.ServiceType;
import noticiaseafitadmin.exceptions.NoConnectionException;
import noticiaseafitadmin.exceptions.WebserviceException;

/**
 *
 * @author Rodrigo
 */
public class WSAccess {

    private static final boolean print = true;
    private static final boolean printTime = true;
    private String url;

    public WSAccess() {
        this.url = "http://127.0.0.1/Noticias%20EAFIT/NoticiasEAFIT_WS/";
    }

    // <editor-fold defaultstate="collapsed" desc="WebService conection Methods">
    public JSONObject getJSONObject(Map params, ServiceType serviceType, Service service) throws Exception {
        String response = getResponse(serviceType, service, params);
        if (response.isEmpty()) {
            return null;
        }
        JSONObject obj = new JSONObject(response);
        if (obj.has("Error")) {
            throw getError(obj);
        }
        return obj;
    }

    public JSONArray getJSONArray(Map params, ServiceType serviceType, Service service) throws JSONException, WebserviceException, Exception {
        String response = getResponse(serviceType, service, params);
        if (response.isEmpty()) {
            return null;
        }
        try {
            JSONArray objs = new JSONArray(response);
            return objs;
        } catch (JSONException e) {
            JSONObject obj = new JSONObject(response);
            if (obj.has("Error")) {
                throw getError(obj);
            }
        }
        return null;
    }

    private String getResponse(ServiceType serviceType, Service service, Map variables) throws Exception {
        String address = url + "services/" + service.toString() + ".php";
        String parameters = "";
        if (serviceType == ServiceType.GET) {
            address += getGETParameters(variables);
        } else if (serviceType == ServiceType.POST) {
            parameters = getPOSTParameters(variables);
        }
        return callService(address, parameters);
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Method Helpers">
    private String getGETParameters(Map variables) throws UnsupportedEncodingException {
        String parameters = "?";
        for (Object key : variables.keySet()) {
            parameters += encode(key.toString(), variables.get(key).toString());
        }
        return parameters;
    }

    private String getPOSTParameters(Map variables) throws UnsupportedEncodingException {
        String parameters = "";
        for (Object key : variables.keySet()) {
            parameters += encode(key.toString(), variables.get(key).toString());
        }
        return parameters;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Static Methods">
    private static String encode(String variable, String value) throws UnsupportedEncodingException {
        String code = URLEncoder.encode(variable, "8859_1") + "=" + URLEncoder.encode(value, "8859_1") + "&";
        return code;
    }

    public static WebserviceException getError(JSONObject error) throws JSONException {
        if (error.has("Error")) {
            error = error.getJSONObject("Error");
        }
        return new WebserviceException(
                error.getString("type"),
                error.getString("category"),
                error.getString("code"),
                error.getString("message"));
    }

    private static String callService(String address, String parameters) throws Exception {
        try {
            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(parameters);
            writer.flush();
            long time = System.currentTimeMillis();
            // Get the response
            InputStreamReader input = new InputStreamReader(conn.getInputStream(), "8859_1");
            BufferedReader reader = new BufferedReader(input);
            String line = reader.readLine();
            String data = "";
            while (line != null) {
                data += line;
                line = reader.readLine();
            }
            writer.close();
            reader.close();
            time = System.currentTimeMillis() - time;
            if (print) {
                System.out.println(data);
            }
            if (printTime) {
                System.out.println("Time of call:" + time + " miliseconds");
            }
            return data;
        } catch (ConnectException e) {
            e.printStackTrace();
            throw new NoConnectionException("No hay conexion al servidor");
        } catch (UnknownHostException e) {
            throw new NoConnectionException("No hay conexion al servidor");
        } catch (Exception e) {
            throw e;
        }
    }
    // </editor-fold>
}
