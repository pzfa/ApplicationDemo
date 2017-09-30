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
                        mUrl="http://183.56.149.24/vlive.qqvideo.tc.qq.com/A0hUD7F5ewuIb_raMtefvecJ5RP9DLD7t7qnzIhzwQ_M/a0544weo6ya.mp4?sdtfrom=v5010&guid=d789ccee9c981f77d7e3cf28396bc7f5&vkey=6D084628E7FED4361B6F0135E090E947596FDCDC043E609FFE3E7E2E229A0146B4FDE964142CD65128C8C8EAB64458088A84C931BB9D3C5E120A37AC69A93F0182FA2F2E815230ACD638F4A415972E76FAF978D5FA79387BB2E8EF5645EAC58E9BABD1A2D9188DBDA6B0B24E7F234B0C8F52CA983B4D7671&platform=2";
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
