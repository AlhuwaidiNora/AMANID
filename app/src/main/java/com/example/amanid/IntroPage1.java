package com.example.amanid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class IntroPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page1);
    }

    public void nextPage(View view) {
        Intent intent = new Intent(this, intro_option_page5.class);
        startActivity(intent);
    }
}
