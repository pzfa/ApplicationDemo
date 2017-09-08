package example.applicationdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/7 0007
 */

public class FragmentTest1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         // 看看看
        setContentView(R.layout.fragment_1);
    }
}
