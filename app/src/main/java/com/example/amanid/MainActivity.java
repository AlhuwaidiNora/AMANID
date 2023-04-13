package com.example.amanid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final long DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page1);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setProjectId("your-project-id")
                .setApplicationId("your-application-id")
                .setApiKey("your-api-key")
                .setDatabaseUrl("your-database-url")
                .build();
        FirebaseApp.initializeApp(this, options);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, intro_option_page5.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }
}
