package example.applicationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import example.applicationdemo.controller.GlideController;
import example.applicationdemo.view.GlideActivityView;

public class MainActivity extends AppCompatActivity {


    GlideActivityView mGlideActivityView;
    GlideController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_glide);
        mGlideActivityView = (GlideActivityView) findViewById(R.id.glide_act_view);
        controller = new GlideController(this,mGlideActivityView);
        mGlideActivityView.init();
        controller.initController();
        Logger.d("aaaa","aaaaaaaaaaaaaaaaaaaa");

    }
}
