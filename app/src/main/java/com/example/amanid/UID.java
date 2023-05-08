package com.example.amanid;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class UID extends AppCompatActivity {
    Button button3;
    TextView textViewUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uid);

        button3 = findViewById(R.id.button3);
        textViewUID = findViewById(R.id.textViewUID);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate UID
                String uid = generateUID();

                // Display UID in the text view
                textViewUID.setText(uid);
            }
        });
    }

    private String generateUID() {
        // Define the characters that can be used in the UID
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Set the desired length of the UID
        int uidLength = 10;

        // Generate the UID
        StringBuilder uidBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < uidLength; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            uidBuilder.append(allowedChars.charAt(randomIndex));
        }

        return uidBuilder.toString();
    }
}
