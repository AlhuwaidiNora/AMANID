package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuccessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);
    }

    public void onClick(View v) {
        Intent intent = new Intent(SuccessfulLogin.this, navigation_menu.class);
        startActivity(intent);
    }
}
