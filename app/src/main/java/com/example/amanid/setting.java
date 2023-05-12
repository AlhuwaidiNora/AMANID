package com.example.amanid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class setting extends AppCompatActivity {
    ImageView imageView37;
    TextView textView_password;
    TextView textView_logout;
    TextView textView_any , help;
    TextView privacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setteing);
        imageView37=findViewById(R.id.imageView37);
        textView_password = findViewById(R.id.textView_password);
        textView_logout = findViewById(R.id.textView_logout);
        textView_any = findViewById(R.id.textView_any);
        help = findViewById(R.id.help);
        privacy = findViewById(R.id.privacy);

        
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting.this, help_support.class);
                startActivity(intent);
            }
        });

        textView_any.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting.this, About_Amanid.class);
                startActivity(intent);
            }
        });
        textView_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        textView_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting.this, change_password.class);
                startActivity(intent);
            }
        });

        imageView37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting.this, home_page_8.class);
                startActivity(intent);
            }
        });
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting.this, privacy_1.class);
                startActivity(intent);
            }
        });
    }

    public void logout(){
        textView_logout(setting.this);
    }
    private void textView_logout( setting setting){
        AlertDialog.Builder builder = new AlertDialog.Builder(setting);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent intent = new Intent(setting.this, intro_option_page5.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


}