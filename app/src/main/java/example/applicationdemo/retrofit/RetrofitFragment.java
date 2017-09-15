package example.applicationdemo.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.applicationdemo.R;
import example.applicationdemo.controller.RetrofitController;
import example.applicationdemo.view.RetrofitView;

/**
 * Created by cai.jia on 2017/9/15 0015
 */

public class RetrofitFragment extends Fragment {

    RetrofitView retrofitView;
    RetrofitController retrofitController;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_retrofit,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        retrofitView= (RetrofitView) getView().findViewById(R.id.RetrofitView);
        retrofitController = new RetrofitController(retrofitView);
        retrofitView.initView(retrofitController);
    }
}
