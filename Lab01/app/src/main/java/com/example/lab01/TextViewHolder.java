package com.example.lab01;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mTextview;

    public TextViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextview = itemView.findViewById(R.id.text);
        itemView.setOnClickListener(this);
    }

    public void bind(String text){
        mTextview.setText(text);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(v.getContext(),SearchActivity.class);
        intent.putExtra("extra",mTextview.getText().toString());
        v.getContext().startActivity(intent);
    }
}
