package com.example.amanid;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_page extends AppCompatActivity {
    Button button8;
    EditText editTextid_login;
    EditText edit_pass;
    ProgressBar progresseBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        button8 = findViewById(R.id.button8);
        edit_pass = findViewById(R.id.edit_pass);
        editTextid_login = findViewById(R.id.editTextid_login);
        progresseBar = findViewById(R.id.progress);
                mAuth = FirebaseAuth.getInstance();
        initial();

    }

    private void initial() {
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithid(editTextid_login.getText().toString(), edit_pass.getText().toString());
            }
        });
    }

    private void loginWithid(String num, String pass) {
        if (num.length() >= 10 && pass.length() > 6) {
             progresseBar.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(num, pass)

                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progresseBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseUser user = mAuth.getCurrentUser();
                                //   updateUI(user);
                                Intent intent = new Intent(login_page.this, fingerPrint_plus.class);
                                startActivity(intent);
                            } else {

                                Toast.makeText(login_page.this, " Login failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

        } else {
            if (num.length() < 10) {
                editTextid_login.setError(" the ID number not valid");
            }
            if (pass.length() < 6) {
                edit_pass.setError(" the Password not valid");
            }
        }


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