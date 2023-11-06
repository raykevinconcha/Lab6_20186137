package com.example.lab6_20186137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonPuzzle = findViewById(R.id.buttonPuzzle);
        Button buttonMemory = findViewById(R.id.buttonMemory);
        buttonPuzzle.setOnClickListener(v -> {
            Intent intent = new Intent(this, Puzzle.class);
            startActivity(intent);
        });

        buttonMemory.setOnClickListener(v -> {
            Intent intent = new Intent(this, Memory.class);
            startActivity(intent);
        });



    }
}