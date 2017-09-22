package example.applicationdemo.http;

import com.google.gson.JsonElement;

/**
 * Created by cai.jia on 2017/9/21 0021
 */

public interface ResponseParser{
    JsonElement parse(String json) throws Exception;
}
