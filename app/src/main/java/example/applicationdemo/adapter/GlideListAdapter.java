package example.applicationdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import example.applicationdemo.R;
import example.applicationdemo.commom.ItemViewDelegate;
import example.applicationdemo.commom.ViewHolder;

/**
 * Created by cai.jia on 2017/9/13 0013
 */

public class GlideListAdapter extends ItemViewDelegate<String,ViewHolder> {
    Context context;

    public GlideListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {

        return new ViewHolder(inflater.getContext(),inflater.inflate(R.layout.item_glide_list,parent, false));
    }

    @Override
    public void onBindViewHolder(List<?> dataSource, String s, RecyclerView.Adapter adapter, ViewHolder holder, int position) {

        ImageView item_glide_image = holder.getView(R.id.item_glide_image);
        Glide.with(context)
                .load(s)
                .into(item_glide_image);
    }

    @Override
    public boolean isForViewType(@NonNull Object item) {
        return item instanceof String;
    }
}
