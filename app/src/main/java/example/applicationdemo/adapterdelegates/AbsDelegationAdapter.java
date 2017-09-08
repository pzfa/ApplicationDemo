

package example.applicationdemo.adapterdelegates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;


public abstract class AbsDelegationAdapter<T> extends RecyclerView.Adapter {

  protected AdapterDelegatesManager<T> delegatesManager;
  protected T items;

  public AbsDelegationAdapter() {
    this(new AdapterDelegatesManager<T>());
  }

  public AbsDelegationAdapter(@NonNull AdapterDelegatesManager<T> delegatesManager) {
    if (delegatesManager == null) {
      throw new NullPointerException("AdapterDelegatesManager is null");
    }

    this.delegatesManager = delegatesManager;
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return delegatesManager.onCreateViewHolder(parent, viewType);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    delegatesManager.onBindViewHolder(items, position, holder, null);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List payloads) {
    delegatesManager.onBindViewHolder(items, position, holder, payloads);
  }

  @Override public int getItemViewType(int position) {
    return delegatesManager.getItemViewType(items, position);
  }

  @Override public void onViewRecycled(RecyclerView.ViewHolder holder) {
    delegatesManager.onViewRecycled(holder);
  }

  @Override public boolean onFailedToRecycleView(RecyclerView.ViewHolder holder) {
    return delegatesManager.onFailedToRecycleView(holder);
  }

  @Override public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
    delegatesManager.onViewAttachedToWindow(holder);
  }

  @Override public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
    delegatesManager.onViewDetachedFromWindow(holder);
  }

  /**
   * Get the items / data source of this adapter
   *
   * @return The items / data source
   */
  public T getItems() {
    return items;
  }

  /**
   * Set the items / data source of this adapter
   *
   * @param items The items / data source
   */
  public void setItems(T items) {
    this.items = items;
  }
}
