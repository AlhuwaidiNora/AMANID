package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class About_Amanid extends AppCompatActivity {
ImageView imageView25 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_amanid);
        imageView25 = findViewById(R.id.imageView25);

        imageView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About_Amanid.this, setting.class);
                startActivity(intent);
            }
        });
    }
}