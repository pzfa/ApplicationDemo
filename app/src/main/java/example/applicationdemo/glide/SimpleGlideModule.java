package example.applicationdemo.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by cai.jia on 2017/9/14 0014
 */

public class SimpleGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);//设置图片质量
        // 调整缓存池大小
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache( new LruResourceCache( customMemoryCacheSize ));
        builder.setBitmapPool( new LruBitmapPool( customBitmapPoolSize ));

        // set size & external vs. internal 内部存储 100M
        int cacheSize100MegaBytes = 104857600;

        builder.setDiskCache(
                new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes)
        );

        // 外部存储 100M
        //builder.setDiskCache(
        //new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));

        // or any other path 指定存储路径
//        String downloadDirectoryPath = Environment.getDownloadCacheDirectory().getPath();
//
//        builder.setDiskCache(
//                new DiskLruCacheFactory( downloadDirectoryPath, cacheSize100MegaBytes ))


    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
