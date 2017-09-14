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
    TextView go_glide;
    Context context;
    private ImageView image_glide, glide_placeholder,
            glide_errorr, glide_crossfade, glide_override,
            glide_gif;

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


    public void init(Context context, OnClickListener clickListener) {
        this.context = context;
        image_glide = (ImageView) findViewById(R.id.image_glide);
        glide_placeholder = (ImageView) findViewById(R.id.glide_placeholder);
        glide_errorr = (ImageView) findViewById(R.id.glide_errorr);
        glide_crossfade = (ImageView) findViewById(R.id.glide_crossfade);
        go_glide = (TextView) findViewById(R.id.go_glide);
        glide_gif = (ImageView) findViewById(R.id.glide_gif);
        glide_override = (ImageView) findViewById(R.id.glide_override);
        go_glide.setOnClickListener(clickListener);
    }

    public void initGlide() {
        String placeholder = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505379605772&di=976a257071848631e793d75a07b96224&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fd1160924ab18972b157f20eeeccd7b899e510a48.jpg";
        String internetUrl = "http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=3d2175db3cd3d539d530078052ee8325/b7003af33a87e950c1e1a6491a385343fbf2b425.jpg";
        Glide.with(context).load(internetUrl).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                Log.d("aaaa", e.toString());
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(image_glide);
        // 占位符
        Glide.with(context).load(placeholder)
                .placeholder(R.mipmap.ic_launcher)
                .thumbnail( 0.1f )//百分之10缩放
                .skipMemoryCache( true )//跳过内存直接网络读取图片
                .into(glide_placeholder);
        // 加载失败占位符
        Glide
                .with(context)
                .load("http://futurestud.io/non_existing_image66.png")
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .error(R.drawable.error) // will be displayed if the image cannot be loaded
                .into(glide_errorr);

        // 加载失败占位符
        Glide
                .with(context)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505379605771&di=38fe946d193b510449669bb49ad18b0c&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2015%2Fmxy%2F6%2F19%2F14%2F3.jpg")
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .error(R.drawable.error) // will be displayed if the image cannot be loaded
                .crossFade() //淡入淡出
                .dontAnimate()// 直接显示
                .thumbnail( 0.1f )//百分之10缩放
                .into(glide_crossfade);

        //  缩放图像 +
        Glide
                .with(context)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505379605771&di=38fe946d193b510449669bb49ad18b0c&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2015%2Fmxy%2F6%2F19%2F14%2F3.jpg")
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .error(R.drawable.error) // will be displayed if the image cannot be loaded
                .override(200, 200)//缩放图像
                .centerCrop()//裁剪
                .into(glide_override);
        //  GIF
        Glide
                .with(context)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505381060410&di=74853d7d26820c33e51d494256b41d37&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160621%2Fb2404cc3b6604e5a95a47052b3cee690.jpg")
                .asGif()//GIF 智能预判
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .error(R.drawable.error) // will be displayed if the image cannot be loaded
                .skipMemoryCache( true )//跳过内存直接网络读取图片
                .into(glide_gif);


    }
}
