package example.applicationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import example.applicationdemo.adapter.NewMainAdapter;
import example.applicationdemo.controller.GlideController;
import example.applicationdemo.view.GlideActivityView;

public class MainActivity extends AppCompatActivity {


    GlideActivityView mGlideActivityView;
    GlideController controller;
    RecyclerView mRecyclerView;
    NewMainAdapter  nNewMainAdapter;
    ArrayList<String>data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_glide);
        mGlideActivityView = (GlideActivityView) findViewById(R.id.glide_act_view);
        controller = new GlideController(this,mGlideActivityView);
        mGlideActivityView.init();
        controller.initController();
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        nNewMainAdapter = new NewMainAdapter(this,data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        mRecyclerView.setAdapter(nNewMainAdapter);
        data.add("Imageselector图片选择");
        nNewMainAdapter.notifyDataSetChanged();
        Logger.d("aaaa","aaaaaaaaaaaaaaaaaaaa");

    }
}
