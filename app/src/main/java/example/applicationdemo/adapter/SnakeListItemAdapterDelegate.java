package example.applicationdemo.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.applicationdemo.R;
import example.applicationdemo.adapterdelegates.AbsListItemAdapterDelegate;
import example.applicationdemo.model.DisplayableItem;
import example.applicationdemo.model.Snake;

/**
 * @author Hannes Dorfmann
 */
public class SnakeListItemAdapterDelegate extends
        AbsListItemAdapterDelegate<Snake, DisplayableItem, SnakeListItemAdapterDelegate.SnakeViewHolder> {

  private LayoutInflater inflater;

  public SnakeListItemAdapterDelegate(Activity activity) {
    inflater = activity.getLayoutInflater();
  }

  @Override
  protected boolean isForViewType(@NonNull DisplayableItem item, List<DisplayableItem> items,
                                  int position) {
    return item instanceof Snake;
  }

  @NonNull @Override public SnakeViewHolder onCreateViewHolder(
      @NonNull ViewGroup parent) {
    return new SnakeViewHolder(
        inflater.inflate(R.layout.item_snake, parent, false));
  }

  @Override protected void onBindViewHolder(@NonNull Snake snake,
      @NonNull SnakeViewHolder vh, @Nullable List payloads) {

    vh.name.setText(snake.getName());
    vh.race.setText(snake.getRace());
  }

  static class SnakeViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView race;

    public SnakeViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.name);
      race = (TextView) itemView.findViewById(R.id.race);
    }
  }
}
