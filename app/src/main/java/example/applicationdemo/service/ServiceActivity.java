package example.applicationdemo.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/26 0026
 */

public class ServiceActivity extends AppCompatActivity  implements View.OnClickListener{

    TestService.TestBind testBind;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            testBind = (TestService.TestBind) service;
            testBind.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    TextView start_service,stop_service,bind_service,unbind_service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_service);
        start_service = (TextView) findViewById(R.id.start_service);
        stop_service = (TextView) findViewById(R.id.stop_service);
        bind_service = (TextView) findViewById(R.id.bind_service);
        unbind_service = (TextView) findViewById(R.id.unbind_service);

        start_service.setOnClickListener(this);
        stop_service.setOnClickListener(this);
        bind_service.setOnClickListener(this);
        unbind_service.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service:
                Intent  startintent = new Intent(this,TestService.class);
                startService(startintent);
                break;
            case R.id.stop_service:
                Intent stopintent = new Intent(this,TestService.class);
                stopService(stopintent);
                break;
            case R.id.bind_service:
                bindService(new Intent(this, TestService.class), serviceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                if(serviceConnection!=null){
                    unbindService(serviceConnection);
                }
                break;
        }
    }
}
