package example.applicationdemo.mediaplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by cai.jia on 2017/9/27 0027
 */

public class BroadcastStatic extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        context.startActivity( new Intent(context,BroadcastReceiverActivity.class));

    }
}
