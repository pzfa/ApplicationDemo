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
 * Created by cai.jia on 2017/9/13 0013
 */

public class GlideListView extends LinearLayout {

    RecyclerView mGlideRecyclerView;
    public GlideListView(Context context) {
        super(context);
    }

    public GlideListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GlideListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GlideListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void  initView(){
        mGlideRecyclerView = (RecyclerView) findViewById(R.id.glide_recycler_view);
    }

    public RecyclerView getmGlideRecyclerView() {
        return mGlideRecyclerView;
    }
}
