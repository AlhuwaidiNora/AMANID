package com.example.amanid;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Idnumber_page6 extends AppCompatActivity {
    Button button3;
     private EditText editTextid;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idnumber_page6);
        button3 = findViewById(R.id.button3);
        editTextid = findViewById(R.id.editTextid);
        mAuth = FirebaseAuth.getInstance();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightid(editTextid.getText().toString());

            }
            private void  rightid(String num) {
                if (num.length() >= 10 ) {
                    Intent intent = new Intent(Idnumber_page6.this, fingerPrint_page7.class);
                    startActivity(intent);
                } else {
                    if (num.length() < 10) {
                        editTextid.setError(" the ID number not valid");
                    }

                }
            }
        });

    }
}
