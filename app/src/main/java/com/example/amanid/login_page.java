package com.example.amanid;

import android.widget.AdapterView;
import com.example.amanid.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ArrayAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;
import com.google.firebase.FirebaseApp;

public class login_page extends AppCompatActivity {
    Spinner hintQuestionsSpinner;
    EditText hintAnswerEditText;
    EditText hint_answer_edit_text;
    String selectedHintQuestion;

    Button button8;
    EditText editTextid_login;
    EditText edit_pass;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        FirebaseApp.initializeApp(this);

        FirebaseApp.initializeApp(this);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        Spinner hintQuestionsSpinner = findViewById(R.id.hint_questions_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hint_questions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hintQuestionsSpinner.setAdapter(adapter);

        hintAnswerEditText = findViewById(R.id.hint_answer_edit_text);

        hintQuestionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedHintQuestion = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if (currentUser != null) {
            // user is properly authenticated
        } else {
            // user is not authenticated
        }


        button8 = findViewById(R.id.button8);
        edit_pass = findViewById(R.id.edit_pass);
        editTextid_login = findViewById(R.id.editTextid_login);
        progressBar = findViewById(R.id.progress);
        hint_answer_edit_text = findViewById(R.id.hint_answer_edit_text);
        initial();
    }

    private void initial() {
        TextView btn = findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this, signup_page.class));
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object num;
                Object pass;
                if (!validateidnum() | !validatepass()) {


                } else {
                    checkUser();
                }

            }
        });
    }

    private void loginWithId(String num, String pass) {
        if (num.length() >= 10 && pass.length() > 6) {
            Intent intent = new Intent(login_page.this, fingerPrint_plus.class);
            startActivity(intent);
        } else {

            if (editTextid_login.length() < 10) {
                editTextid_login.setError(" the ID number not valid");
            }
            if (edit_pass.length() < 6) {
                edit_pass.setError(" the Password not valid");
            }
        }
    }

    public Boolean validateidnum() {
        String val = editTextid_login.getText().toString();
        if (val.isEmpty()) {
            editTextid_login.setError(" id number cannot be empty");
            return false;
        } else {
            editTextid_login.setError(null);
            return true;
        }

    }

    public Boolean validatepass() {
        String val = edit_pass.getText().toString();
        if (val.isEmpty()) {
            edit_pass.setError(" password cannot be empty");
            return false;
        } else {
            editTextid_login.setError(null);
            return true;
        }

    }


    public void checkUser() {
        String username = editTextid_login.getText().toString().trim();
        String userpass = edit_pass.getText().toString().trim();
        String qhint = hint_answer_edit_text.getText().toString().trim();

        // Add this code to authenticate the user
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(username, userpass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // user is signed in
                        } else {
                            // sign in failed
                        }
                    }
                });
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child("1108263409");

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(username);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    editTextid_login.setError(null);
                    String passwordFromDB = snapshot.child(username).child("password").getValue(String.class);
                    String qhintFromDB = snapshot.child(username).child("qhint").getValue(String.class);
                    if (passwordFromDB.equals(userpass) && qhintFromDB.equals(qhint)) {
                        editTextid_login.setError(null);
                        Intent intent = new Intent(login_page.this, navigation_menu.class);
                        startActivity(intent);
                    } else {
                        edit_pass.setError("Invalid Credentials");
                        edit_pass.requestFocus();
                        hint_answer_edit_text.setError("Wrong answer");
                        hint_answer_edit_text.requestFocus();
                    }
                } else {
                    editTextid_login.setError("User does not exist");
                    editTextid_login.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("login_page", "checkUser: " + error.getMessage());
                Toast.makeText(login_page.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }}


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