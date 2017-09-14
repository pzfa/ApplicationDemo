package example.applicationdemo.controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import example.applicationdemo.adapter.ListFregmentAdapter;
import example.applicationdemo.commom.LoadMoreDelegationAdapter;
import example.applicationdemo.view.ListFragmentView;

/**
 * Created by cai.jia on 2017/9/14 0014
 */

public class ListFragmentController {
    ListFragmentView view;
    RecyclerView recyclerView;
    Context context;
    ArrayList<Fragment> arrayDataList;
    ArrayList<String> arrayStringList = new ArrayList<>();
    private LoadMoreDelegationAdapter mAdapter;
    View.OnClickListener onClickListener;


    public ListFragmentController(ListFragmentView view, Context context , View.OnClickListener onClickListener) {
        this.view = view;
        this.context = context;
        this.onClickListener =onClickListener;

    }

    public void initController() {
        mAdapter = new LoadMoreDelegationAdapter(false, null);
        mAdapter.delegateManager.addDelegate(new ListFregmentAdapter(onClickListener));
        recyclerView = view.getmRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAdapter);
    }

    public void setData(ArrayList<Fragment> arrayList) {
        this.arrayDataList = arrayList;
        arrayStringList.clear();

        for (Fragment fragment : arrayDataList) {
            arrayStringList.add(fragment.getClass().getSimpleName());
        }
        mAdapter.appendItems(arrayStringList);
    }

}
