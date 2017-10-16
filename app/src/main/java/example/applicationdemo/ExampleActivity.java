package example.applicationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import example.applicationdemo.controller.GlideController;
import example.applicationdemo.view.GlideActivityView;

/**
 * Created by cai.jia on 2017/10/16 0016
 */

public class ExampleActivity extends AppCompatActivity {

    GlideActivityView mGlideActivityView;
    GlideController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_example);
        mGlideActivityView = (GlideActivityView) findViewById(R.id.glide_act_view);
        controller = new GlideController(this,mGlideActivityView);
        mGlideActivityView.init();
        controller.initController();


    }
}
