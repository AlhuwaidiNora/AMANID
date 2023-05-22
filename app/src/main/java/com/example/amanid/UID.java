package com.example.amanid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class UID extends AppCompatActivity {
    private Button button3;
    private TextView textViewUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uid);

        button3 = findViewById(R.id.button3);
        textViewUID = findViewById(R.id.textViewUID);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateAndDisplayUID();
            }
        });
    }

    private void generateAndDisplayUID() {
        String uid = generateUID();
        textViewUID.setText(uid);
    }

    private String generateUID() {
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int uidLength = 10;
        StringBuilder uidBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < uidLength; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            uidBuilder.append(allowedChars.charAt(randomIndex));
        }

        return uidBuilder.toString();
    }
}
