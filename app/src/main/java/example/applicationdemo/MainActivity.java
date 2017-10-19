package example.applicationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import example.applicationdemo.adapter.NewMainAdapter;
import example.applicationdemo.imageselector.ImageselectorTestActivity;
import example.applicationdemo.jsplayer.JsPlayerTestActivity;
import example.applicationdemo.tinker.TinkerMainActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView mRecyclerView;
    NewMainAdapter  nNewMainAdapter;
    ArrayList<Class<?> >dataClass = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_glide);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        nNewMainAdapter = new NewMainAdapter(this,dataClass);
        nNewMainAdapter.setOnClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(nNewMainAdapter);

        dataClass.add(ImageselectorTestActivity.class);
        dataClass.add(ExampleActivity.class);
        dataClass.add(JsPlayerTestActivity.class);
        dataClass.add(TinkerMainActivity.class);

        nNewMainAdapter.notifyDataSetChanged();
        Logger.d("aaaa","aaaaaaaaaaaaaaaaaaaa");

    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        setClass(dataClass.get(tag));
    }

    private void setClass(Class<?> cls) {
        Intent intent =new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }
}
