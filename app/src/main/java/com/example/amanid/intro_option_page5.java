
package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class intro_option_page5 extends AppCompatActivity {



    ImageView imageView35 , imageView38;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_option_page1);

        imageView35 = findViewById(R.id.imageView35);
        imageView38 = findViewById(R.id.imageView38);

        imageView35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro_option_page5.this, getStarted_page2.class);
                startActivity(intent);
            }
        });

        imageView38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro_option_page5.this, login_page.class);
                startActivity(intent);
            }
        });
    }
}
