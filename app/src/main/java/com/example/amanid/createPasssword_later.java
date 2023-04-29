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
    EditText editTextTextPersonName4;
    FirebaseDatabase database;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amanid-e0318-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_passsword_later);

        button5 = findViewById(R.id.button5);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String pass1 = editTextTextPersonName2.getText().toString();
                String pass2 = editTextTextPersonName4.getText().toString();
                if (pass1.isEmpty() || pass2.isEmpty()){
                    Toast.makeText(createPasssword_later.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                } else if (!pass1.equals(pass2)) {
                    Toast.makeText(createPasssword_later.this, "Passwords are not matching", Toast.LENGTH_LONG).show();
                } else {
                    reference.child(pass1).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if id not registered before
                            if (snapshot.exists()){
                                // sending data
//                  reference.child("users").child(idnum).child("pass").setValue(pass);
//                  reference.child("users").child(idnum).child("idnum").setValue(idnum);
                                HelperClass helperClass = new HelperClass(pass1,pass2);
                                reference.child(pass1).setValue(helperClass);
                                reference.child(pass1).child("pass").setValue(pass1);
                                Toast.makeText(createPasssword_later.this, "you have change the password successfully!", Toast.LENGTH_LONG).show();
                                finish(); }
                                Intent intent = new Intent(createPasssword_later.this, login_page.class);
                                startActivity(intent);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

        });
    }
}
