package example.applicationdemo.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by cai.jia on 2017/9/25 0025
 */

public class NoCodeParser implements ResponseParser {
    @Override
    public JsonElement parse(String json) throws Exception {
        return new JsonParser().parse(json);
    }
}
