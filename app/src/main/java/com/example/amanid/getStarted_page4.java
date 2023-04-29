package com.example.amanid;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class getStarted_page4 extends AppCompatActivity {
     ImageView imageView32 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started_page4);
        imageView32 = findViewById(R.id.imageView32);
        imageView32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getStarted_page4.this, signup_page.class);
                startActivity(intent);
            }
        });
    }
}
//