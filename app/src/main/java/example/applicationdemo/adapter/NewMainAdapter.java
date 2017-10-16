package example.applicationdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import example.applicationdemo.R;

/**
 * Created by cai.jia on 2017/10/13 0013
 */

public class NewMainAdapter extends RecyclerView.Adapter<NewMainAdapter.ViewHolder>  {

    private Context mContext;
    private ArrayList<Class<?>> data;
    private LayoutInflater mInflater;
    View.OnClickListener onClickListener;

    public NewMainAdapter(Context mContext, ArrayList<Class<?>> data) {
        this.mContext = mContext;
        this.data = data;
        this.mInflater = LayoutInflater.from(mContext);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_new_main,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.new_tv.setText(data.get(position).getSimpleName());
        holder.new_tv.setTag(position);
        holder.new_tv.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView new_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            new_tv = (TextView) itemView.findViewById(R.id.new_tv);
        }
    }
}
