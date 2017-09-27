package example.applicationdemo.mediaplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/27 0027
 */

public class BroadcastReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    final static String BROADCASTRECEIVER = "BroadcastReceiver_TEST";
    TextView register_tv, unregister_tv, post_tv;
    LocalBroadcastManager localBroadcastManager;
    BroadcastTest2 broadcastTest2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_broadcast);
        broadcastTest2 = new BroadcastTest2();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        register_tv = (TextView) findViewById(R.id.register_tv);
        unregister_tv = (TextView) findViewById(R.id.unregister_tv);
        post_tv = (TextView) findViewById(R.id.post_tv);

        register_tv.setOnClickListener(this);
        unregister_tv.setOnClickListener(this);
        post_tv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_tv:
                IntentFilter intentFilter = new IntentFilter();
                //步骤3：设置接收广播的类型
                intentFilter.addAction(BROADCASTRECEIVER);
                localBroadcastManager.registerReceiver(broadcastTest2, intentFilter);
                break;
            case R.id.unregister_tv:
                localBroadcastManager.unregisterReceiver(broadcastTest2);
                break;
            case R.id.post_tv:
                //发送应用内广播
                Intent intent = new Intent();
                intent.setAction(BROADCASTRECEIVER);
                localBroadcastManager.sendBroadcast(intent);
                break;
        }
    }

    class BroadcastTest2 extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("aaaa",intent.getAction());

        }
    }
}
