package example.applicationdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import example.applicationdemo.R;
import example.applicationdemo.glide.GlideExample;

/**
 * Created by cai.jia on 2017/9/7 0007
 */

public class FragmentTest2 extends AppCompatActivity {
    FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_2);

        supportFragmentManager = getSupportFragmentManager();
        findViewById(R.id.add_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                GlideExample f = new GlideExample();
                fragmentTransaction.add(R.id.contentPanel, f, "FragmentState");
                fragmentTransaction.commit();

            }
        });

        findViewById(R.id.add_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

                FragmentState2 f = new FragmentState2();
                fragmentTransaction.add(R.id.contentPanel, f, "FragmentState2");
                fragmentTransaction.commit();
            }
        });
        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

                Fragment fragmentState = supportFragmentManager.findFragmentByTag("FragmentState");
                fragmentTransaction.remove(fragmentState);
                fragmentTransaction.commit();
            }
        });
        findViewById(R.id.replace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                FragmentState f = new FragmentState();
                fragmentTransaction.replace(R.id.contentPanel, f);
                fragmentTransaction.commit();
            }
        });
    }
}
