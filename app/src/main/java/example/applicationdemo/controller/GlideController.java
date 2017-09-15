package example.applicationdemo.controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import example.applicationdemo.commom.FragmentService;
import example.applicationdemo.fragment.ListFragment;
import example.applicationdemo.view.GlideActivityView;

/**
 * Created by cai.jia on 2017/9/13 0013
 */

public class GlideController implements ListFragment.ViewTag {

    Context context;
    GlideActivityView glideActivityView;
    FragmentService fragmentService;
    ArrayList<Fragment> arrayList;
    private int type;
    public GlideController(AppCompatActivity context, GlideActivityView glideActivityView) {
        this.context = context;
        this.glideActivityView = glideActivityView;
        fragmentService = new FragmentService(context.getSupportFragmentManager());
    }

    public GlideController(AppCompatActivity context, GlideActivityView glideActivityView,int type) {
        this.context = context;
        this.glideActivityView = glideActivityView;
        this.type =type;
        fragmentService = new FragmentService(context.getSupportFragmentManager());

    }
    public  void  initController(){
        ListFragment listFragment = ListFragment.getListFragment(type);
        listFragment.setViewTag(this);
        arrayList = listFragment.getArrayList();
        fragmentService.add(glideActivityView.getGlide_list().getId(),listFragment,false,ListFragment.class.getSimpleName(),true);
    }


    @Override
    public void tagInt(int inden) {
        fragmentService.add(glideActivityView.getGlide_list().getId(),arrayList.get(inden),true,arrayList.get(inden).getClass().getSimpleName(),true);

    }
}
