package com.example.amanid;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;


public class SuccessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);
        new Handler().postDelayed(new Runnable() {



            @Override

            public void run() {

                Intent i = new Intent(SuccessfulLogin.this, home_page_7.class);

                startActivity(i);


                finish();

            }

        }, 1*1000); // wait for 1 seconds

    }



}
