package example.applicationdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by cai.jia on 2017/9/26 0026
 */

public class TestService extends Service {

    String TAG = "aaa";
    TestBind testBind = new TestBind();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate>>>>>");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand>>>>>");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy>>>>>");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return testBind;
    }

    class TestBind extends Binder {
        public void startDownload() {
            Log.d(TAG, "startDownload() executed>>>>");
            // 执行具体的下载任务
        }
    }
}
