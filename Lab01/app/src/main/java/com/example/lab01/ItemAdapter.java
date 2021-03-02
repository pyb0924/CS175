package com.example.lab01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> implements Filterable {

    private final List<String> itemList;
    public ItemAdapter(List<String> list) {
        this.itemList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item=itemList.get(position);
        holder.itemName.setText(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // TODO search filter
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;

        public ViewHolder(@NonNull View view) {
            super(view);
            itemName=(TextView) view.findViewById(R.id.item_name);
        }
    }
}
