package example.applicationdemo.glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import example.applicationdemo.R;
import example.applicationdemo.controller.GlideController;
import example.applicationdemo.view.GlideActivityView;

/**
 * Created by cai.jia on 2017/9/13 0013
 */

public class GlideActivity extends AppCompatActivity {


    GlideActivityView mGlideActivityView;
    GlideController controller;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_glide);
        mGlideActivityView = (GlideActivityView) findViewById(R.id.glide_act_view);
        controller = new GlideController(this,mGlideActivityView);
        mGlideActivityView.init();
        controller.initController();
    }
}
