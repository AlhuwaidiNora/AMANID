
package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class intro_option_page5 extends AppCompatActivity {

//Button button22, button7;
ImageView imageView24 , imageView28;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_option_page1);

        imageView24 = findViewById(R.id.imageView24);
        imageView28 = findViewById(R.id.imageView28);
        imageView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro_option_page5.this, getStarted_page2.class);
                startActivity(intent);
            }
        });

        imageView28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro_option_page5.this, login_page.class);
                startActivity(intent);
            }
        });
    }
}
