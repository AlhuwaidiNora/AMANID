package com.example.amanid;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Terms_Conditions extends AppCompatActivity {
    ImageView imageView46;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);

        imageView46 = findViewById(R.id.imageView46);
        imageView46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Navigate back to the previous activity
                finish(); // Close the current activity
            }
        });
    }
}
