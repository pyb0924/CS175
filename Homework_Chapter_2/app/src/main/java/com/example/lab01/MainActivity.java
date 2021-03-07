package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<String> itemList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataInit();

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ItemAdapter adapter=new ItemAdapter(this,itemList);
        recyclerView.setAdapter(adapter);

        SearchView searchView=(SearchView) findViewById(R.id.sv);
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                //Log.e("searchView","text changed");
                return false;
            }
        });

        Button cancelButton=(Button)findViewById(R.id.cbutton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setQuery("",false);
                searchView.clearFocus();
            }
        });
    }

    public void dataInit() {
        for (int i = 0; i < 100; i++) {
            @SuppressLint("DefaultLocale") String item=String.format("这是第%d行",i+1);
            itemList.add(item);
        }
    }
}