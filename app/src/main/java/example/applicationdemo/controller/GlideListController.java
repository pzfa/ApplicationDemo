package example.applicationdemo.controller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.applicationdemo.adapter.GlideListAdapter;
import example.applicationdemo.commom.LoadMoreDelegationAdapter;
import example.applicationdemo.view.GlideListView;

/**
 * Created by cai.jia on 2017/9/13 0013
 */

public class GlideListController {
    Context mcontext ;
    GlideListView mGlideListView;
    private LoadMoreDelegationAdapter mAdapter;
    private ArrayList<String>ImageList;
    RecyclerView recyclerView;

    public GlideListController(Context mcontext, GlideListView mGlideListView) {
        this.mcontext = mcontext;
        this.mGlideListView = mGlideListView;

    }

    public void  initController (){
        mAdapter = new LoadMoreDelegationAdapter(false,null);
        recyclerView = mGlideListView.getmGlideRecyclerView();
        mAdapter.delegateManager.addDelegate(new GlideListAdapter(mcontext));
        recyclerView.setLayoutManager(new LinearLayoutManager(mcontext));
        recyclerView.setAdapter(mAdapter);
    }
    public void setImageList(ArrayList<String> imageList) {
        ImageList = imageList;
        mAdapter.appendItems(ImageList);


    }
}
