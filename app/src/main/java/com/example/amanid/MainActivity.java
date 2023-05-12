package com.example.amanid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final long DELAY = 2000;
    private String receiver;
    private double amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_page1);
        receiver=getIntent().getStringExtra("receiver");
        amount=getIntent().getDoubleExtra("amount",0);
        Log.d("SSSS", "onCreate: "+getIntent().getStringExtra("receiver"));
        Log.d("SSSS", "onCreate: "+getIntent().getDoubleExtra("amount",0));

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        // Check if the Firebase app already exists
        if (FirebaseApp.getApps(this).isEmpty()) {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setProjectId("amanid-e0318")
                    .setApplicationId("com.example.amanid")
                    .setApiKey("AIzaSyBtkAFcdTyDc33qQTINzBiC6rxU1mIqInQ\n")
                    .setDatabaseUrl("https://amanid-e0318-default-rtdb.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(this, options);
        }
//full firebase
        // Delayed launch of next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, intro_option_page5.class);
                intent.putExtra("amount",amount);
                intent.putExtra("receiver",receiver);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }
}