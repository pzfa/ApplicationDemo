package example.applicationdemo;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * Created by cai.jia on 2017/9/15 0015
 */

public class DemoApplication extends MultiDexApplication {
    private static DemoApplication application;



    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    private DemoApplication getApplication(){
        return application;
    }

    public static Context getContext(){
        return  application.getApplicationContext();
    }
}
