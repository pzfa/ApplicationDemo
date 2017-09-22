package example.applicationdemo.http;

import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by cai.jia on 2017/9/21 0021
 */

final class ResponseBodyConverter <T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    ResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        try {
            return adapter.fromJson(value.charStream());
        } finally {
            value.close();
        }
    }
}
