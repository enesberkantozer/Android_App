package com.enesberkantozer.photocollageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class matrix_secimi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_secimi);

        Button btn2x2= findViewById(R.id.button2);
        Button btn3x2= findViewById(R.id.button3);
        Button btn4x2= findViewById(R.id.button4);

        btn2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(matrix_secimi.this, kolaj2x2.class));
            }
        });
        btn3x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(matrix_secimi.this, kolaj3x2.class));
            }
        });
        btn4x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(matrix_secimi.this, kolaj3x3.class));
            }
        });
    }
}