package com.example.amanid;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class home_page_8 extends AppCompatActivity {
ImageView imageview201 , imageview164 , imageView77 , imageView214 ,imageView219;
TextView textView_spec1,greetings;
FloatingActionButton transfer_icon;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page7);

        // Retrieve the idnum value from the intent

        // Display a greeting message with the user ID
        String idnum = getIntent().getStringExtra("idnum");

        // Display a greeting message with the user ID
        TextView greetingTextView = findViewById(R.id.greetings);
        greetingTextView.setText("Hello " + idnum + "!");

        setContentView(R.layout.activity_home_page7);
        imageview201 =findViewById(R.id.imageView210);
        imageview164 = findViewById(R.id.imageView164);
        imageView77 = findViewById(R.id.imageView77);
        imageView214 = findViewById(R.id.imageView214);
        imageView219 = findViewById(R.id.imageView219);
        transfer_icon = findViewById(R.id.transfer_icon);

        transfer_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, transfer.class);
                startActivity(intent);
            }
        });



        imageView219.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, wallet.class);
                startActivity(intent);
            }
        });








        imageView214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, profile.class);
                startActivity(intent);
            }
        });

        imageview201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, setting.class);
                startActivity(intent);
            }
        });
// Ensure that the layout is inflated before referencing the ImageView
        setContentView(R.layout.activity_home_page7);

// Get a reference to the ImageView
        ImageView imageview164 = findViewById(R.id.imageView1645);

// Check if the ImageView is not null before setting the OnClickListener
        if (imageview164 != null) {
            imageview164.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the click event here
                    // You can show a dialog, start a new activity, or perform any other action
                    // to display the options "Add money from credit card" and "Add money from bank transfer"

                    // Example: Show a dialog with the two options
                    AlertDialog.Builder builder = new AlertDialog.Builder(home_page_8.this);
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
        }

        imageView77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, transfer.class);
                startActivity(intent);
            }
        });
        ImageView imageViewWallet = findViewById(R.id.imageView219);
        imageViewWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity to navigate to wallet XML layout
                Intent intent = new Intent(home_page_8.this, wallet.class); // Replace YourCurrentActivity with the name of your current activity
                startActivity(intent);
            }
        });
        ImageView imageViewSetting = findViewById(R.id.imageView210);
        imageViewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity to navigate to wallet XML layout
                Intent intent = new Intent(home_page_8.this, setting.class); // Replace YourCurrentActivity with the name of your current activity
                startActivity(intent);
            }
        });
        ImageView imageViewProfile = findViewById(R.id.imageView13);
        imageViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity to navigate to wallet XML layout
                Intent intent = new Intent(home_page_8.this, profile.class); // Replace YourCurrentActivity with the name of your current activity
                startActivity(intent);
            }
        });


            // Rest of your code here...
            // ...
        }

    }


