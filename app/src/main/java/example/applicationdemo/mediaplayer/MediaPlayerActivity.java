package example.applicationdemo.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/27 0027
 */

public class MediaPlayerActivity extends AppCompatActivity
        implements View.OnClickListener,SeekBar.OnSeekBarChangeListener,MediaPlayer.OnSeekCompleteListener {

    /***
     *
     *
     MediaPlayer mp = new MediaPlayer();//新建一个的实例
     mp.setDataSource();//设置要播放文件的路径
     mp.prepare();//播放 准备完成，开始播放前要调用
     mp.start();//播放
     mp.pause();//暂停
     mp.reset();//将mp对象重置到刚创建的状态
     mp.stop();//停止播放，使用后当前mp对象无法再播放
     mp.release();//释放播放相关资源，一般在活动的onDestroy()方法里调用
     mp.isPlaying();//判断mp对象是否正在播放
     mp.seekTo();//调转到指定位置播放
     mp.getDuration();//获得载入的音频的播放时长
     *
     * */
    TextView pausebutton, playButton, stopButtonf,tv,tv2;

    private MediaPlayer mp = new MediaPlayer();
    String TAG="aaaa";
    private SeekBar seekbar;

    private boolean hadDestroy = false;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case 0x01:

                    break;

                default:
                    break;
            }
        };
    };
    Runnable runnable = new Runnable() {

        @Override
        public void run() {

            if (!hadDestroy) {
                mHandler.postDelayed(this, 1000);
                int currentTime = Math
                        .round(mp.getCurrentPosition() / 1000);
                String currentStr = String.format("%s%02d:%02d", "当前时间 ",
                        currentTime / 60, currentTime % 60);
                tv.setText(currentStr);
                seekbar.setProgress(mp.getCurrentPosition());
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_media_player);

        mp.setOnSeekCompleteListener(this);
        pausebutton = (TextView)findViewById(R.id.pausebutton);
        playButton = (TextView) findViewById(R.id.playButton);
        stopButtonf = (TextView) findViewById(R.id.stopButtonf);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        tv = (TextView)findViewById(R.id.tv);
        tv2 = (TextView)findViewById(R.id.tv2);

        stopButtonf.setOnClickListener(this);
        playButton.setOnClickListener(this);
        stopButtonf.setOnClickListener(this);
        seekbar.setOnSeekBarChangeListener(this);
        initMP();
    }

    //初始化mp
    private void initMP() {

        File file = new File(Environment.getExternalStorageDirectory()+"/qqmusic/song/");
        File[] files = file.listFiles();
        for(int i =0;i<files.length;i++){
            Log.d(TAG,files[i].getPath())  ;
        }
        try {
            Log.d(TAG,"设置资源》》》"+files[1].getPath())  ;
            mp.setDataSource(files[1].getPath());//设置播放音频文件的路径
            mp.prepare();//mp就绪
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playButton:
                //// 如果sdcard存在
                if(!mp.isPlaying()){
                    Log.d(TAG,"开始播放》》》");
                    mp.start();
                    int totalTime = Math.round(mp.getDuration() / 1000);
                    String str = String.format("%02d:%02d", totalTime / 60,
                            totalTime % 60);
                    tv2.setText(str);
                    seekbar.setMax(mp.getDuration());
                    mHandler.postDelayed(runnable, 1000);
                }

                break;
            case R.id.stopButtonf:
                if (mp.isPlaying()) {
                    mp.pause();
                }
                break;
            case R.id.pausebutton:
                if (mp.isPlaying()) {
                    mp.reset();
                    initMP();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if (mp != null) {
            mp.stop();
            hadDestroy = true;
            mp.release();
        }
        super.onDestroy();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//        if (mp != null) {
//            mp.seekTo(seekBar.getProgress());
//        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (mp != null) {
            mp.seekTo(seekBar.getProgress());
        }
    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {
        int currentTime = Math
                .round(mp.getCurrentPosition() / 1000);
        String currentStr = String.format("%s%02d:%02d", "当前时间 ",
                currentTime / 60, currentTime % 60);
        tv.setText(currentStr);
        seekbar.setProgress(mp.getCurrentPosition());

    }
}
