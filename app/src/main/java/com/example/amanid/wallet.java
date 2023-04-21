package com.example.amanid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class wallet extends AppCompatActivity {
    Button button15;
    ImageView imageView26, imageView25, imageView164;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        button15 = findViewById(R.id.button15);
        imageView26 = findViewById(R.id.imageView26);
        imageView25 = findViewById(R.id.imageView25);
        imageView164 = findViewById(R.id.imageView164);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wallet.this, home_page_8.class);
                startActivity(intent);
            }
        });

        imageView164.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                // You can show a dialog, start a new activity, or perform any other action
                // to display the options "Add money from credit card" and "Add money from bank transfer"

                // Example: Show a dialog with the two options
                AlertDialog.Builder builder = new AlertDialog.Builder(wallet.this);
                builder.setTitle("Add Money");
                builder.setItems(new CharSequence[]{"Add money from credit card", "Add money from bank transfer"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle the option click event here
                                if (which == 0) {
                                    // Option 1: Add money from credit card
                                    // Perform the corresponding action
                                } else if (which == 1) {
                                    // Option 2: Add money from bank transfer
                                    // Perform the corresponding action
                                }
                            }
                        });
                builder.show();
            }

        });
        Button button = findViewById(R.id.button15);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity to navigate back to home page or desired activity
                Intent intent = new Intent(wallet.this, home_page_8.class);
                startActivity(intent);
            }
        });

    }

}
