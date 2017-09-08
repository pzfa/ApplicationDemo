package example.applicationdemo.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

import example.applicationdemo.adapterdelegates.AdapterDelegatesManager;
import example.applicationdemo.model.DisplayableItem;

/**
 * Created by cai.jia on 2017/9/6 0006
 */

public class MainAdapter extends RecyclerView.Adapter {

    private AdapterDelegatesManager<List<DisplayableItem>> delegatesManager;
    private List<DisplayableItem> items;

    public MainAdapter(Activity activity, List<DisplayableItem> items) {
        this.items = items;

        // Delegates
        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new AdvertisementAdapterDelegate(activity));
        delegatesManager.addDelegate(new CatAdapterDelegate(activity));
        delegatesManager.addDelegate(new DogAdapterDelegate(activity));
        delegatesManager.addDelegate(new GeckoAdapterDelegate(activity));
        delegatesManager.addDelegate(new SnakeListItemAdapterDelegate(activity));

    }

    @Override public int getItemViewType(int position) {
        Log.d("aaaa","position>>>>>"+position);
        items.get(position);
        return delegatesManager.getItemViewType(items, position);
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
        delegatesManager.onBindViewHolder(items, position, holder, payloads);
    }

    @Override public int getItemCount() {
        return items.size();
    }
}
