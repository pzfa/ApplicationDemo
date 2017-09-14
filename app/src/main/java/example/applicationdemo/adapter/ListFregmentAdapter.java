package example.applicationdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import example.applicationdemo.R;
import example.applicationdemo.commom.ItemViewDelegate;
import example.applicationdemo.commom.ViewHolder;

/**
 * Created by cai.jia on 2017/9/14 0014
 */

public class ListFregmentAdapter extends ItemViewDelegate<String,ViewHolder> {
   View.OnClickListener onClickListener;

    public ListFregmentAdapter(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.getContext(),inflater.inflate(R.layout.item_list_fregment,parent, false));
    }

    @Override
    public void onBindViewHolder(List<?> dataSource, String s, RecyclerView.Adapter adapter, ViewHolder holder, int position) {

        holder.setTag(R.id.item_list_fregment_tv,position).setText(R.id.item_list_fregment_tv,onClickListener,s);
    }

    @Override
    public boolean isForViewType(@NonNull Object item) {
        return item instanceof String;
    }
}
