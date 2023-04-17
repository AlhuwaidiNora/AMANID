package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessfulLogin extends AppCompatActivity {
    Button addbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);
        addbutton2 =findViewById(R.id.addbutton2);
        addbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessfulLogin.this, profile_user.class);
                  startActivity(intent);
            }
        });
    }



}
