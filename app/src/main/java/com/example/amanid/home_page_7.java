package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home_page_7 extends AppCompatActivity {
ImageView imageview201 , imageview164 , imageView77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page7);
        imageview201 =findViewById(R.id.imageView210);
        imageview164 = findViewById(R.id.imageView164);
        imageView77 = findViewById(R.id.imageView77);

        imageview201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_7.this, setting.class);
                startActivity(intent);
            }
        });
        imageview164.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_7.this, Add_New_User.class);
                startActivity(intent);
            }
        });
        imageView77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_7.this, transfer.class);
                startActivity(intent);
            }
        });

    }
    }


