package com.example.lab6_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Puzzle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        Button button3=findViewById(R.id.button);
        button3.setOnClickListener(v -> {
            Intent intent = new Intent(this, tres_tres.class);
            startActivity(intent);
        });
    }
}