package example.applicationdemo.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;

import example.applicationdemo.MainActivity;
import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/10/12 0012
 */

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    TextView Notification1,Notification2,Notification3;
    NotificationManager mNotificationManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_notification);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification1 = (TextView) findViewById(R.id.Notification1);
        Notification2 = (TextView) findViewById(R.id.Notification2);
        Notification3 = (TextView) findViewById(R.id.Notification3);
        Notification1.setOnClickListener(this);
        Notification2.setOnClickListener(this);
        Notification3.setOnClickListener(this);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Notification1:
                Notification.Builder builder=new Notification.Builder(this);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jianshu.com/p/82e249713f1b"));
                PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
                builder.setContentIntent(pendingIntent);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                builder.setAutoCancel(true);
                builder.setContentTitle("普通通知");
                mNotificationManager.notify(1, builder.getNotification());
                break;
            case R.id.Notification2:
                Notification.Builder builder2=new Notification.Builder(this);
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jianshu.com/p/82e249713f1b"));
                PendingIntent pendingIntent2=PendingIntent.getActivity(this,0,intent2,0);
                builder2.setContentIntent(pendingIntent2);
                builder2.setSmallIcon(R.mipmap.ic_launcher);
                builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                builder2.setAutoCancel(true);
                builder2.setContentTitle("折叠通知");
                RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.layout_view);
                Notification  notification=builder2.build();
                notification.bigContentView=remoteViews;
                mNotificationManager.notify(1,notification);

                break;

            case R.id.Notification3:

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Notification.Builder builder3  = new Notification.Builder(this)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setPriority(Notification.PRIORITY_DEFAULT)
                            .setCategory(Notification.CATEGORY_MESSAGE)
                            .setContentTitle("Headsup Notification")
                            .setContentText("I am a Headsup notification.");
                    Intent push = new Intent();
                    push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    push.setClass(this, MainActivity.class);
                    PendingIntent pendingIntent3 = PendingIntent.getActivity(
                            this, 0, push, PendingIntent.FLAG_CANCEL_CURRENT);
                    builder3.setContentText("Heads-Up Notification on Android 5.0")
                            .setFullScreenIntent(pendingIntent3, true);
                    NotificationManager nm = (NotificationManager)
                            getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(2, builder3.build());
                }


                break;
        }
    }
}
