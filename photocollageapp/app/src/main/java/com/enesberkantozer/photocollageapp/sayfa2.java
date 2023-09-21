package com.enesberkantozer.photocollageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sayfa2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);

        Button sayfagecismatrix= findViewById(R.id.button6);
        Button sayfagecissablon= findViewById(R.id.button7);

        sayfagecismatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(sayfa2.this,matrix_secimi.class));
            }
        });

        sayfagecissablon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(sayfa2.this,hazir_sablonlar.class));
            }
        });
    }
}