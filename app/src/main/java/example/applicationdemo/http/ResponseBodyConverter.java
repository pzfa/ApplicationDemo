package example.applicationdemo.http;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by cai.jia on 2017/9/21 0021
 */

final class ResponseBodyConverter <T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;
    private final ResponseParser parser;

    ResponseBodyConverter(TypeAdapter<T> adapter, ResponseParser parser) {
        this.adapter = adapter;
        this.parser = parser;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        String json = value.string();
//        ApiLog.info(json);
        if (parser != null) {
            try {
                return adapter.fromJsonTree(parser.parse(json));
            } catch (Exception e) {
                e.printStackTrace();
                throw new ApiServerException(0, 0, e.getMessage());
            }
        } else {
            JsonReader jsonReader = new Gson().newJsonReader(value.charStream());
            try {
                return adapter.read(jsonReader);
            } finally {
                value.close();
            }
        }
    }
}
