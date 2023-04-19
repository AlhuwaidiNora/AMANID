package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class home_page_8 extends AppCompatActivity {
ImageView imageview201 , imageview164 , imageView77 , imageView214 ,imageView219;
TextView textView_spec1;
FloatingActionButton transfer_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page7);
        imageview201 =findViewById(R.id.imageView210);
        imageview164 = findViewById(R.id.imageView164);
        imageView77 = findViewById(R.id.imageView77);
        imageView214 = findViewById(R.id.imageView214);
        imageView219 = findViewById(R.id.imageView219);


        imageView219.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, wallet.class);
                startActivity(intent);
            }
        });








        imageView214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, profile.class);
                startActivity(intent);
            }
        });

        imageview201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, setting.class);
                startActivity(intent);
            }
        });
        imageview164.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, Add_New_User.class);
                startActivity(intent);
            }
        });
       imageView77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, transfer.class);
                startActivity(intent);
            }
        });

    }
    }


