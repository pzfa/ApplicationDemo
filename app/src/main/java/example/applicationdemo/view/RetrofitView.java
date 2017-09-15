package example.applicationdemo.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/15 0015
 */

public class RetrofitView extends LinearLayout {
    TextView get_tv,response_body;

    public RetrofitView(Context context) {
        super(context);
    }

    public RetrofitView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RetrofitView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RetrofitView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView(OnClickListener onClickListener) {
        get_tv = (TextView) findViewById(R.id.get_tv);
        get_tv.setOnClickListener(onClickListener);
        response_body = (TextView) findViewById(R.id.response_body);
    }

    public void  setBodyData(String data){
        response_body.setText("数据》》》"+data);
    }


}
