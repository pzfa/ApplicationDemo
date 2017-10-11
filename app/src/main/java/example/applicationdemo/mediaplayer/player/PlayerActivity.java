/*
 *
 * PlayerActivity.java
 * 
 * Created by Wuwang on 2016/9/29
 * Copyright © 2016年 深圳哎吖科技. All rights reserved.
 */
package example.applicationdemo.mediaplayer.player;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;

import example.applicationdemo.R;

/**
 * Description:
 */
public class PlayerActivity extends Activity {

    private EditText mEditAddress;
    private SurfaceView mPlayerView;
    private MPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initView();
        initPlayer();
    }

    private void initView(){
        mEditAddress= (EditText) findViewById(R.id.mEditAddress);
        mPlayerView= (SurfaceView) findViewById(R.id.mPlayerView);
    }

    private void initPlayer(){
        player=new MPlayer();
        player.setDisplay(new MinimalDisplay(mPlayerView));
    }

    @Override
    protected void onResume() {
        super.onResume();
        player.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.onDestroy();
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.mPlay:
                String mUrl=mEditAddress.getText().toString();
                if(mUrl.length()>0){
                    Log.e("wuwang","播放->"+mUrl);
                    try {
                        mUrl="http://14.29.117.16/vlive.qqvideo.tc.qq.com/AinpzCmpc6oSVPjIcA4vkY5QozzQ9N-AKMYfV1MoEV2Q/u0024x2ds5h.mp4?sdtfrom=v5010&guid=d789ccee9c981f77d7e3cf28396bc7f5&vkey=252519D30E9584518022946E7DF7B6AE66B06536EFC615F55C90276B8E16698A325E8A040AD45A59E2153AEB27994EBD14B83807BFA16D1216E7FED4035846A9EAF813AA000F972CB838826D5A8C73213A2CD411B48F175BBC25F9E444EE44B1C2B281A4DE03EFCA6ABC9A9DA56BEBE7E249A1ED18EAEA94&platform=2";
                        player.setSource(mUrl);
                        player.play();
                    } catch (MPlayerException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.mPlayerView:
                if(player.isPlaying()){
                    player.pause();
                }else{
                    try {
                        player.play();
                    } catch (MPlayerException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.mType:
                player.setCrop(!player.isCrop());
                break;
        }
    }

}
