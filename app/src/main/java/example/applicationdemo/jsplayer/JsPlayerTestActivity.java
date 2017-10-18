package example.applicationdemo.jsplayer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import example.applicationdemo.R;
import example.applicationdemo.jsplayer.listener.OnVideoControlListener;
import example.applicationdemo.jsplayer.utils.DisplayUtils;
import example.applicationdemo.jsplayer.video.JsPlayer;

public class JsPlayerTestActivity extends AppCompatActivity {

    // 播放器
    private JsPlayer player;

    // 去弹幕页
    private Button bt_danmu;

    private String path = "http://baobab.wdjcdn.com/1455782903700jy.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.act_js_player_test);

        bt_danmu= (Button) findViewById(R.id.bt_danmu);
        bt_danmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JsPlayerTestActivity.this,DanmuActivity.class));
            }
        });


        player = (JsPlayer) findViewById(R.id.player);

        player.setOnVideoControlListener(new OnVideoControlListener() {
            @Override
            public void onStartPlay() {
                player.startPlay();
            }

            @Override
            public void onBack() {

            }

            @Override
            public void onFullScreen() {
                DisplayUtils.toggleScreenOrientation(JsPlayerTestActivity.this);
            }

            @Override
            public void onRetry(int errorStatus) {

            }
        });

        player.setPath(new VideoInfo("艺术人生", path));


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    @Override
    public void onBackPressed() {
        if (!DisplayUtils.isPortrait(this)) {
            if (!player.isLock()) {
                DisplayUtils.toggleScreenOrientation(this);
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.onDestroy();
    }
}
