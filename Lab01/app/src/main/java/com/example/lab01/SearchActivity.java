package com.example.lab01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends AppCompatActivity {

    private final SearchAdapter sa=new SearchAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(sa);

        List<String> items=new ArrayList<>();
        for (int i=0;i<100;i++){
            items.add(String.valueOf(i));
        }
        sa.notifyItems(items);
    }
}