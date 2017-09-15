package example.applicationdemo.retrofit;

import android.util.Log;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import example.applicationdemo.BuildConfig;
import example.applicationdemo.DemoApplication;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cai.jia on 2017/9/15 0015
 */

public class RetrofitManager {
    private static final String CACHE_NAME  = "retrofitcache";
    private static Retrofit retrofit = null;
    private static String url = "";
    public static Retrofit getInstance(String baseUrl) {
        url = baseUrl;
        if (retrofit == null) {
            return create();
        } else {
            return retrofit;
        }
    }

    private static Retrofit create() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // log用拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        //打印retrofit日志
                        Logger.d("aaaa",message);
                    }
                }
        );
        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
        if (BuildConfig.DEBUG) {
            Log.d("aaaa","DEBUG = ");
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
//        Interceptor headerInterceptor = new Interceptor() {
//
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request originalRequest = chain.request();
//                Request.Builder builder = originalRequest.newBuilder();
//                builder.header("appid", "1");
//                builder.header("timestamp", System.currentTimeMillis() + "");
//                builder.header("appkey", "zRc9bBpQvZYmpqkwOo");
//                builder.header("signature", "dsljdljflajsnxdsd");
//
//                Request.Builder requestBuilder =builder.method(originalRequest.method(), originalRequest.body());
//                Request request = requestBuilder.build();
//                return chain.proceed(request);
//            }
//
//        };
//        builder.addInterceptor(headerInterceptor);//统一参数

        //设置缓存目录
        File cacheFile = new File(DemoApplication.getContext().getExternalCacheDir(), CACHE_NAME);
        //生成缓存，50M
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        //缓存拦截器
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //网络不可用
                if (!NetworkUtils.isAvailable(DemoApplication.getContext())) {
                    //在请求头中加入：强制使用缓存，不访问网络
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                //网络可用
                if (NetworkUtils.isAvailable(DemoApplication.getContext())) {
                    int maxAge = 0;
                    // 有网络时 在响应头中加入：设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("pragma")
                            .build();
                } else {
                    // 无网络时，在响应头中加入：设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("pragma")
                            .build();
                }
                return response;
            }
        };
        builder.addInterceptor(loggingInterceptor)
                .addInterceptor(cacheInterceptor)
                .cache(cache)
                .connectTimeout(15, TimeUnit.SECONDS)//设置超时
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);//错误重连
        OkHttpClient client = builder.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //设置 Json 转换器
                .addConverterFactory(GsonConverterFactory.create())
                //RxJava 适配器
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
