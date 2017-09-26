package example.applicationdemo.http;

import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by cai.jia on 2017/9/21 0021
 */

public class GanHuoResponseParser implements ResponseParser {
    @Override
    public JsonElement parse(String json) throws Exception {
        Log.d("aaaa","response ---> " + json);
        JsonElement element = new JsonParser().parse(json);
        JsonObject object = element.getAsJsonObject();
        boolean error = object.get("error").getAsBoolean();
        if (!object.has("results") ) {
            throw new ApiServerException(0, 0, "数据错误");
        }
        return object.get("results");
    }
}
