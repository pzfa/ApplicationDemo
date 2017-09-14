package example.applicationdemo.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/14 0014
 */

public class ListFragmentView extends LinearLayout {
    RecyclerView mRecyclerView;

    public ListFragmentView(Context context) {
        super(context);
    }

    public ListFragmentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ListFragmentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ListFragmentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public  void  initView(){
        mRecyclerView= (RecyclerView) findViewById(R.id.recycler_view);
    }

    public RecyclerView getmRecyclerView() {
        return mRecyclerView;
    }
}
