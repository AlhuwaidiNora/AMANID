package com.example.amanid;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class fingerPrint_page7 extends AppCompatActivity {
      ImageView imageView2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_finger_print_later);
            imageView2 = findViewById(R.id.imageView2);
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(fingerPrint_page7.this, createPasssword_page8.class);
                    startActivity(intent);
                }
            });
        }
    }
