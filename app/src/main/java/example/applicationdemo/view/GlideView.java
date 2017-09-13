package example.applicationdemo.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/9/12 0012
 */

public class GlideView extends LinearLayout {
    private ImageView image_glide;
   TextView go_glide;
    Context context;

    public GlideView(Context context) {
        super(context);

    }

    public GlideView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


    }

    public GlideView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GlideView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);


    }


    public void init(Context context,OnClickListener clickListener) {
        this.context=context;
        image_glide = (ImageView)findViewById(R.id.image_glide);
        go_glide = (TextView) findViewById(R.id.go_glide);
        go_glide.setOnClickListener(clickListener);
    }
    public  void initGlide(){
        String internetUrl = "http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=3d2175db3cd3d539d530078052ee8325/b7003af33a87e950c1e1a6491a385343fbf2b425.jpg" ;
        Glide.with(context).load(internetUrl).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                Log.d("aaaa",e.toString());
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(image_glide);

    }
}
