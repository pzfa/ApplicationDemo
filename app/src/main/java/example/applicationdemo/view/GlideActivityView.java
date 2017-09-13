package example.applicationdemo.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/13 0013
 */

public class GlideActivityView extends LinearLayout {
    Context context;
    FrameLayout glide_list;

    public GlideActivityView(Context context) {
        super(context);
        this.context =context;
    }

    public GlideActivityView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context =context;

    }

    public GlideActivityView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context =context;

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GlideActivityView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context =context;
    }

    public void  init(){
        glide_list = (FrameLayout) findViewById(R.id.glide_list);
    }

    public FrameLayout getGlide_list() {
        return glide_list;
    }
}
