package com.enesberkantozer.photocollageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hazir_sablonlar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hazir_sablonlar);

        Button sablon1gecis=findViewById(R.id.sablon1gecis);
        Button sablon2gecis=findViewById(R.id.sablon2gecis);

        sablon1gecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hazir_sablonlar.this,hazir_sablon_1.class));
            }
        });

        sablon2gecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hazir_sablonlar.this,hazir_sablon_2.class));
            }
        });
    }
}