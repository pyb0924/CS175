package com.example.lab01;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> implements Filterable {

    private final Context context;
    private List<String> itemList;
    private final List<String> prevList;

    public ItemAdapter(Context context, List<String> list) {
        this.context = context;
        this.itemList = list;
        this.prevList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                String result = itemList.get(position);
                Intent intent = new Intent(context, ResultActivity.class);
                intent.putExtra("search_result", result);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = itemList.get(position);
        holder.itemName.setText(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String string_list = constraint.toString();
                if (string_list.isEmpty()) {
                    itemList=prevList;
                } else {
                    List<String> tmpList = new ArrayList<>();
                    for (String str : prevList) {
                        if (str.contains(string_list)) {
                            tmpList.add(str);
                        }
                    }
                    itemList = tmpList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = itemList;
                filterResults.count=itemList.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                itemList = (ArrayList<String>) results.values;
                Log.e("Filter length", String.valueOf(itemList.size()));
                if (results.count <= 0) {
                    itemList.add("No Results");
                }
                notifyDataSetChanged();
            }
        };
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        View itemView;

        public ViewHolder(@NonNull View view) {
            super(view);
            itemView = view;
            itemName = (TextView) view.findViewById(R.id.item_name);
        }
    }
}
