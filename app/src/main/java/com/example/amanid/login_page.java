package com.example.amanid;

import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login_page extends AppCompatActivity {
    Spinner hintQuestionsSpinner;

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

        Spinner hintQuestionsSpinner = findViewById(R.id.hint_questions_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hint_questions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hintQuestionsSpinner.setAdapter(adapter);

        hint_answer_edit_text = findViewById(R.id.hint_answer_edit_text);

        hintQuestionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedHintQuestion = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button8 = findViewById(R.id.button8);
        edit_pass = findViewById(R.id.edit_pass);
        editTextid_login = findViewById(R.id.editTextid_login);
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


                if (!validateidnum() | !validatepass()) {


                } else {
                    checkUser();

                }

            }
        });
    }

    private void loginWithId(String num, String pass) {
        if (num.length() >= 10 && pass.length() > 6) {
            //  progressBar.setVisibility(View.VISIBLE);
            //  mAuth.signInWithEmailAndPassword(num, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            //   @Override
            //   public void onComplete(@NonNull Task<AuthResult> task) {
            //       progressBar.setVisibility(View.GONE);
            //      if (task.isSuccessful()) {
            // Sign in success, update UI with the signed-in user's information
            //       FirebaseUser user = mAuth.getCurrentUser();
            //   updateUI(user);
            Intent intent = new Intent(login_page.this, fingerPrint_plus_later.class);
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
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("indium").equalTo(username);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    editTextid_login.setError(null);
                    String passwordFromDB = snapshot.child(username).child("pass").getValue(String.class);
                    String qhintFromDB = snapshot.child(username).child("hint").getValue(String.class);
                    if (passwordFromDB.equals(userpass) && qhintFromDB.equals(qhint)) {
                        editTextid_login.setError(null);
                        String idnumFromDB = snapshot.child(username).child("indium").getValue(String.class);
                        Intent intent = new Intent(login_page.this, SuccessfulLogin.class);
                        startActivity(intent);

                    } else {
                        edit_pass.setError(" Invalid Credentials");
                        edit_pass.requestFocus();
                        hint_answer_edit_text.setError(" wrong answer");
                        hint_answer_edit_text.requestFocus();
                    }

                } else {
                    editTextid_login.setError(" User dose not exist");
                    editTextid_login.requestFocus();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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