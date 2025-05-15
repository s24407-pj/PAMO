package com.example.bmicalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adapter obsługujący elementy listy zakupów w RecyclerView.
 */
public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private final List<ShoppingItem> items;

    /**
     * Konstruktor adaptera.
     *
     * @param items Lista elementów do wyświetlenia.
     */
    public ShoppingListAdapter(List<ShoppingItem> items) {
        this.items = items;
    }

    /**
     * ViewHolder reprezentujący pojedynczy element listy.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox checkbox;

        public ViewHolder(View itemView) {
            super(itemView);
            checkbox = itemView.findViewById(R.id.checkbox);
        }
    }

    @NonNull
    @Override
    public ShoppingListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shopping, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListAdapter.ViewHolder holder, int position) {
        ShoppingItem item = items.get(position);
        holder.checkbox.setText(item.getName());
        holder.checkbox.setChecked(item.isChecked());

        holder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setChecked(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
