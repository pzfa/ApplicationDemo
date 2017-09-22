package example.applicationdemo.http;

import com.google.gson.JsonElement;

import org.json.JSONObject;

/**
 * Created by cai.jia on 2017/9/21 0021
 */

public class GanHuoResponseParser implements ResponseParser {
    @Override
    public JsonElement parse(String json) throws Exception {
        JSONObject jsonObject = new JSONObject(json);


        return null;
    }
}
