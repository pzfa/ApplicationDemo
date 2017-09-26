package example.applicationdemo.http;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by cai.jia on 2017/9/15 0015
 */

public class RetrofitManager {
    private static final String CACHE_NAME = "retrofitcache";


    public static <T> T create(String baseUrl,
                               ResponseParser parser,
                               Class<T> service) {
//        OkHttpClient okHttpClient = new OkHttpClient();
        // log用拦截器
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
//                new HttpLoggingInterceptor.Logger() {
//                    @Override
//                    public void log(String message) {
//                        //打印retrofit日志
//                        Log.d("aaaa", message);
//                    }
//                }
//        );
////         开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
//        if (BuildConfig.DEBUG) {
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        } else {
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        }
//
//
//        //设置缓存目录
//        File cacheFile = new File(DemoApplication.getContext().getExternalCacheDir(), CACHE_NAME);
//        //生成缓存，50M
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
//        //缓存拦截器
//        Interceptor cacheInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                //网络不可用
//                if (!NetworkUtils.isAvailable(DemoApplication.getContext())) {
//                    //在请求头中加入：强制使用缓存，不访问网络
//                    request = request.newBuilder()
//                            .cacheControl(CacheControl.FORCE_CACHE)
//                            .build();
//                }
//                Response response = chain.proceed(request);
//                //网络可用
//                if (NetworkUtils.isAvailable(DemoApplication.getContext())) {
//                    int maxAge = 0;
//                    // 有网络时 在响应头中加入：设置缓存超时时间0个小时
//                    response.newBuilder()
//                            .header("Cache-Control", "public, max-age=" + maxAge)
//                            .removeHeader("pragma")
//                            .build();
//                } else {
//                    // 无网络时，在响应头中加入：设置超时为4周
//                    int maxStale = 60 * 60 * 24 * 28;
//                    response.newBuilder()
//                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                            .removeHeader("pragma")
//                            .build();
//                }
//                return response;
//            }
//        };
/**
 * .addInterceptor(new CommonInterceptor())//统一参数
 .addInterceptor(loggingInterceptor)
 .addInterceptor(cacheInterceptor)
 .cache(cache)
 *
 */
//        builder
//                .connectTimeout(15, TimeUnit.SECONDS)//设置超时
//                .readTimeout(20, TimeUnit.SECONDS)
//                .writeTimeout(20, TimeUnit.SECONDS)
//                .retryOnConnectionFailure(true);//错误重连

        Retrofit build = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //设置 Json 转换器
                .addConverterFactory(ConverterFactory.create(parser))
                //RxJava 适配器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(okHttpClient)
                .build();
        return  build.create(service);

    }

    public static <T> void processObserve(Context context,
                                          Observable<T> observable,
                                          ResultListener<T> listener) {
        if (listener == null) return;
        ResponseObserver<T> observer = new ResponseObserver<>(listener, context);
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

}
