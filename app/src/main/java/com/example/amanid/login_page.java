package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login_page extends AppCompatActivity {
 Button button8;
 EditText   editTextid_login;
    EditText edit_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        button8 = findViewById(R.id.button8);
        edit_pass = findViewById(R.id.edit_pass);
        editTextid_login = findViewById(R.id.editTextid_login);
        initial();

        }
    private void initial() {
        button8.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           loginWithid(editTextid_login.getText().toString(), edit_pass.getText().toString());
                                           Intent intent = new Intent(login_page.this, fingerPrint_page7.class);
                                           startActivity(intent);
                                       }


                                       private void loginWithid(String num, String pass) {
                                           if (num.length() > 10 && pass.length() > 6) {

                                           } else {
                                               if (num.length() < 10) {
                                                   editTextid_login.setError(" the ID number not valid");
                                               }
                                               if (pass.length() < 6) {
                                                   edit_pass.setError(" the Password not valid");
                                               }
                                           }
                                       }
                                   });

    }
}






/*
 button8.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(login_page.this,fingerPrint_plus.class);
        startActivity(intent);
        }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login_page.this,fingerPrint_plus.class);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           loginWithid(editTextid_login.getText().toString(), edit_pass.getText().toString());
                                       }

                                       private void loginWithid(String num, String pass) {
                                           if (num.length() > 10 && pass.length() > 6) {

                                           }else {
                                               if(num.length()<10){
                                                   editTextid_login.setError(" the ID number not valid");
                                       }
                                               if(pass.length()<6){
                                                   editTextid_login.setError(" the Password not valid");
                                               }
    }
}

 */