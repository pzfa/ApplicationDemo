package example.applicationdemo.adapterdelegates;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;


public abstract class AbsListItemAdapterDelegate<I extends T, T, VH extends RecyclerView.ViewHolder>
    extends AdapterDelegate<List<T>> {

  @Override protected final boolean isForViewType(@NonNull List<T> items, int position) {
    return isForViewType(items.get(position), items, position);
  }

  @Override protected final void onBindViewHolder(@NonNull List<T> items, int position,
      @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
    onBindViewHolder((I) items.get(position), (VH) holder, payloads);
  }

  /**
   * Called to determine whether this AdapterDelegate is the responsible for the given item in the
   * list or not
   * element
   *
   * @param item The item from the list at the given position
   * @param items The items from adapters dataset
   * @param position The items position in the dataset (list)
   * @return true if this AdapterDelegate is responsible for that, otherwise false
   */
  protected abstract boolean isForViewType(@NonNull T item, @NonNull List<T> items, int position);

  /**
   * Creates the  {@link RecyclerView.ViewHolder} for the given data source item
   *
   * @param parent The ViewGroup parent of the given datasource
   * @return ViewHolder
   */
  @NonNull @Override protected abstract VH onCreateViewHolder(@NonNull ViewGroup parent);

  /**
   * Called to bind the {@link RecyclerView.ViewHolder} to the item of the dataset
   *
   * @param item The data item
   * @param viewHolder The ViewHolder
   * @param payloads The payloads
   */
  protected abstract void onBindViewHolder(@NonNull I item, @NonNull VH viewHolder,
      @NonNull List<Object> payloads);
}
