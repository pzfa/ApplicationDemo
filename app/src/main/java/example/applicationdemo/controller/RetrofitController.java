package example.applicationdemo.controller;

import android.view.View;

import java.io.IOException;

import example.applicationdemo.R;
import example.applicationdemo.retrofit.RetrofitManager;
import example.applicationdemo.retrofit.RetrofitService;
import example.applicationdemo.view.RetrofitView;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by cai.jia on 2017/9/15 0015
 */

public class RetrofitController implements View.OnClickListener {
    RetrofitView retrofitView;
    Retrofit retrofit;

    public RetrofitController(RetrofitView retrofitView) {
        this.retrofitView = retrofitView;

        retrofit =
                RetrofitManager.getInstance("http://gank.io/");
//                new Retrofit.Builder()
//                .baseUrl("http://gank.io/")
//                .addConverterFactory(GsonConverterFactory.create())//添加GsonBuilder
//                .client(client)
//                .build();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_tv:
                getRetrofit();
                break;
        }

    }

    private void getRetrofit() {


        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<ResponseBody> call = retrofitService.getAndroidInfo();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                call.cancel();// 取消请求
                try {
                    retrofitView.setBodyData(response.body().string() + "<<code>>" + response.code());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public static Interceptor getRequestHeader() {
        Interceptor headerInterceptor = new Interceptor() {

            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder();
                builder.header("appid", "1");
                builder.header("timestamp", System.currentTimeMillis() + "");
                builder.header("appkey", "zRc9bBpQvZYmpqkwOo");
                builder.header("signature", "dsljdljflajsnxdsd");

                Request.Builder requestBuilder =builder.method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }

        };

        return headerInterceptor;
    }

    public static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
