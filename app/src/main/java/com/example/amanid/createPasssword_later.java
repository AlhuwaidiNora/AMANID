package com.example.amanid;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class createPasssword_later extends AppCompatActivity {
    Button button5;
    EditText editTextTextPersonName2;
    EditText pass1 ,pass2;
    EditText editTextTextPersonName4;
    String passnew1, passnew2;
    FirebaseDatabase database;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amanid-e0318-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_passsword_later);
        reference = FirebaseDatabase.getInstance().getReference("users");

        button5 = findViewById(R.id.button5);
        pass2 = findViewById(R.id.editTextTextPersonName4);
        pass1 = findViewById(R.id.editTextTextPersonName2);
        Userdata();

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ispasswordchange() && ispasswordchange2()) {
                    Toast.makeText(createPasssword_later.this, "Password has been changed", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(createPasssword_later.this, "Password cannot be changed", Toast.LENGTH_LONG).show();
                }

            }
        });

    }





    private void Userdata() {
        Intent intent = getIntent();
        passnew1 = intent.getStringExtra("pass1");
        passnew2 = intent.getStringExtra("pass2");


        pass1.setText(passnew1);
        pass2.setText(passnew2);
    }

    private boolean ispasswordchange2() {
        if (!passnew2.equals(pass2.getText().toString())){
            reference.child(passnew2).child("pass2").setValue(editTextTextPersonName4.getText().toString());
            passnew2 =pass2.getText().toString();
            return true;
        }else {
            return false;

        }
    }

    private boolean ispasswordchange() {
        if (!passnew1.equals(pass1.getText().toString())){
            reference.child(passnew1).child("pass").setValue(editTextTextPersonName2.getText().toString());
            passnew1 =pass1.getText().toString();
            return true;
        }else {
            return false;

        }

    }
}