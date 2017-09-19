package example.applicationdemo.rxandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.applicationdemo.R;
import example.applicationdemo.controller.RxandroidController;
import example.applicationdemo.view.RxandroidView;

/**
 * Created by cai.jia on 2017/9/19 0019
 */

public class RxandroidFragment  extends Fragment{

    RxandroidController rxandroidController;
    RxandroidView rxandroidView;

    NestedScrollView nestedScrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return  inflater.inflate(R.layout.fragment_rxandroid,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nestedScrollView = (NestedScrollView) getView().findViewById(R.id.nestedScrollView);
        rxandroidView =new RxandroidView(nestedScrollView);
        rxandroidController =new RxandroidController(rxandroidView,getActivity());
        rxandroidView.initView(rxandroidController);
    }
}
