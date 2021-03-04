package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String result=getIntent().getStringExtra("search_result");
        TextView textView=findViewById(R.id.result_view);
        textView.setText(result);
    }
}