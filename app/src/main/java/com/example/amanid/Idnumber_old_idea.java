package com.example.amanid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Idnumber_old_idea extends AppCompatActivity {
    private Button button3;
    private EditText editTextid;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idnumber_old_idea);
        initializeViews();
        mAuth = FirebaseAuth.getInstance();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateIdNumber(editTextid.getText().toString());
            }

            private void validateIdNumber(String num) {
                if (num.length() >= 10) {
                    Intent intent = new Intent(Idnumber_old_idea.this, fingerPrint_page7_later.class);
                    startActivity(intent);
                } else {
                    editTextid.setError("The ID number is not valid");
                }
            }
        });
    }

    private void initializeViews() {
        button3 = findViewById(R.id.button3);
        editTextid = findViewById(R.id.editTextid);
    }
}
