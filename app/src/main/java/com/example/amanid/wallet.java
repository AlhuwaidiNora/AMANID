package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class wallet extends AppCompatActivity {
      Button button15 ;
      ImageView imageView26,imageView25 ,imageView164;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        button15 =findViewById(R.id.button15);
        imageView26 = findViewById(R.id.imageView26);
        imageView25 =findViewById(R.id.imageView25);
        imageView164 = findViewById(R.id.imageView164);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wallet.this, home_page_8.class);
                startActivity(intent);
            }
        });
    }
}