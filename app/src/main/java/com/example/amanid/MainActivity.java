package com.example.amanid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void goToPage3(View view) {
        Intent intent = new Intent(this, getStrated_page3.class);
        startActivity(intent);
    }

    public void goToPage4(View view) {
        Intent intent = new Intent(this, getStarted_page4.class);
        startActivity(intent);
    }

    private static final long DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page1);

        // Start the IntroActivity first
        Intent intentIntro = new Intent(MainActivity.this, IntroOption.class);
        startActivity(intentIntro);

        // Wait for a few seconds, and then start the getStated_2 activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, getStated_2.class);
                startActivity(intent);
            }
        }, DELAY);
    }
}
