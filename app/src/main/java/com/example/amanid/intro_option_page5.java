
package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class intro_option_page5 extends AppCompatActivity {
    Button SignUpButton;
    Button LogInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_option_page5);
        SignUpButton = findViewById(R.id.SignUpButton);
        LogInButton = findViewById(R.id.LogInButton);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro_option_page5.this, Idnumber_page6.class);
                startActivity(intent);
            }
        });
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(intro_option_page5.this, login_page.class);
                startActivity(intent);
            }
        });
    }
}