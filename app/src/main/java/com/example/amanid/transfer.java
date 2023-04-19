package com.example.amanid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class transfer extends AppCompatActivity {
    Button button12 ;
    EditText editTextamount;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transfer);
        button12 = findViewById(R.id.button12);
        editTextamount = findViewById(R.id.editTextamount);

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(transfer.this, home_page_8.class);
                startActivity(intent);
            }
        });
    }
}