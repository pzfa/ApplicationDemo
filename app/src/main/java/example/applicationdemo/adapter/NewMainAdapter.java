package example.applicationdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import example.applicationdemo.R;
import example.applicationdemo.imageselector.ImageselectorTestActivity;

/**
 * Created by cai.jia on 2017/10/13 0013
 */

public class NewMainAdapter extends RecyclerView.Adapter<NewMainAdapter.ViewHolder>  {

    private Context mContext;
    private ArrayList<String> data;
    private LayoutInflater mInflater;

    public NewMainAdapter(Context mContext, ArrayList<String> data) {
        this.mContext = mContext;
        this.data = data;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_new_main,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.new_tv.setText(data.get(position));
        holder.new_tv.setTag(position);
        holder.new_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = (int) v.getTag();
                Intent intent =new Intent();

                switch (tag){
                    case 0:
                        intent.setClass(mContext, ImageselectorTestActivity.class);
                        break;
                }
                mContext.startActivity(intent);
            }
        });

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
