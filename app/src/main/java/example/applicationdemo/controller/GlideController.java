package example.applicationdemo.controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import example.applicationdemo.commom.FragmentService;
import example.applicationdemo.glide.GlideListFragment;
import example.applicationdemo.view.GlideActivityView;

/**
 * Created by cai.jia on 2017/9/13 0013
 */

public class GlideController  {

    Context context;
    GlideActivityView glideActivityView;
    FragmentService fragmentService;

    public GlideController(AppCompatActivity context, GlideActivityView glideActivityView) {
        this.context = context;
        this.glideActivityView = glideActivityView;
        fragmentService = new FragmentService(context.getSupportFragmentManager());
    }
    public  void  initController(){
        GlideListFragment glideListFragment = new GlideListFragment();
        fragmentService.add(glideActivityView.getGlide_list().getId(),glideListFragment,true);
    }


}
