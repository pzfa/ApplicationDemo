package example.applicationdemo.controller;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;

import example.applicationdemo.R;
import example.applicationdemo.http.ApiUrl;
import example.applicationdemo.http.BaseCallModel;
import example.applicationdemo.http.GanHuoResponseParser;
import example.applicationdemo.http.ResultListener;
import example.applicationdemo.http.RetrofitManager;
import example.applicationdemo.model.MeizhiModel;
import example.applicationdemo.retrofit.RetrofitService;
import example.applicationdemo.view.RetrofitView;
import io.reactivex.Observable;

/**
 * Created by cai.jia on 2017/9/15 0015
 */

public class RetrofitController implements View.OnClickListener {
    RetrofitView retrofitView;
    Context context;


    public RetrofitController(RetrofitView retrofitView, Context context) {
        this.retrofitView = retrofitView;
        this.context = context;
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

        RetrofitService service = RetrofitManager.create(ApiUrl.Host_Gan_Huo, new GanHuoResponseParser(), RetrofitService.class);
        Observable<ArrayList<MeizhiModel>> androidDate = service.getAndroidDate();
        RetrofitManager.processObserve(context, androidDate, new ResultListener<ArrayList<MeizhiModel>>() {
            @Override
            public void onResultBack(BaseCallModel<ArrayList<MeizhiModel>> t) {

                if (!TextUtils.isEmpty(t.getErrno())) {
                    retrofitView.setBodyData(t.getErrno());
                } else {
                    ArrayList<MeizhiModel> data = t.getData();
                    retrofitView.setBodyData(data.size() + "");
                }


            }
        });

    }

}
