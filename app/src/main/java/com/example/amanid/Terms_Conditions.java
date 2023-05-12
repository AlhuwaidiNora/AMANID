package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Terms_Conditions extends AppCompatActivity {
ImageView imageView46 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
        imageView46 = findViewById(R.id.imageView46);
        imageView46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Terms_Conditions.this ,setting.class);
                startActivity(intent);
            }
        });
    }
}