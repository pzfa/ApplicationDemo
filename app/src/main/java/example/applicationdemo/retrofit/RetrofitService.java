package example.applicationdemo.retrofit;

import example.applicationdemo.model.MeizhiModel;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cai.jia on 2017/9/15 0015
 */

public interface RetrofitService{
    @GET("api/data/Android/10/1")
    Call<ResponseBody> getAndroidInfo();

    @GET("api/data/Android/10/1")
    Observable<BaseCallModel<MeizhiModel>> getAndroidDate();
}
