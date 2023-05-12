package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class done_transfer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_transfer2);
        new Handler().postDelayed(new Runnable() {



            @Override

            public void run() {

                Intent i = new Intent(done_transfer.this, home_page_8.class);

                startActivity(i);


                finish();

            }

        }, 1*1000); // wait for 1 seconds

    }

}
