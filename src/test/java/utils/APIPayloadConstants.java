package utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    public static String CREATE_USER_PAYLOAD_JSON_DYNAMIC(String name, String email, String pass) {

        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("email", email);
        obj.put("password", pass);


        return obj.toString();
    }
}
