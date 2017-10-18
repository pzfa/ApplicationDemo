package example.applicationdemo.imageselector;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import example.applicationdemo.R;
import example.applicationdemo.imageselector.utils.ImageSelectorUtils;

/**
 * Created by cai.jia on 2017/10/13 0013
 */

public class ImageselectorTestActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 0x00000011;

    private RecyclerView rvImage;
    private ImageTestAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_imageselector);
        rvImage = (RecyclerView) findViewById(R.id.rv_image);
        rvImage.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new ImageTestAdapter(this);
        rvImage.setAdapter(mAdapter);

        findViewById(R.id.btn_single).setOnClickListener(this);
        findViewById(R.id.btn_limit).setOnClickListener(this);
        findViewById(R.id.btn_unlimited).setOnClickListener(this);
        findViewById(R.id.btn_clip).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null) {
            ArrayList<String> images = data.getStringArrayListExtra(ImageSelectorUtils.SELECT_RESULT);
            mAdapter.refresh(images);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_single:
                //单选
                ImageSelectorUtils.openPhoto(this, REQUEST_CODE, true, 0);
                break;

            case R.id.btn_limit:
                //多选(最多9张)
                ImageSelectorUtils.openPhoto(this, REQUEST_CODE, false, 9);
                break;

            case R.id.btn_unlimited:
                //多选(不限数量)
                ImageSelectorUtils.openPhoto(this, REQUEST_CODE);
                //或者
//                ImageSelectorUtils.openPhoto(JsPlayerTestActivity.this, REQUEST_CODE, false, 0);
                break;

            case R.id.btn_clip:
                //单选并剪裁
                ImageSelectorUtils.openPhotoAndClip(this, REQUEST_CODE);
                break;
        }
    }
}
