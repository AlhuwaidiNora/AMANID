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

public class login_page extends AppCompatActivity {
    Spinner hintQuestionsSpinner;
    EditText hintAnswerEditText;
    String selectedHintQuestion;

    Button button8;
    EditText editTextid_login;
    EditText edit_pass;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

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

        button8 = findViewById(R.id.button8);
        edit_pass = findViewById(R.id.edit_pass);
        editTextid_login = findViewById(R.id.editTextid_login);
        progressBar = findViewById(R.id.progress);
        mAuth = FirebaseAuth.getInstance();

        initial();
    }

    private void initial() {
        TextView btn = findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this, Idnumber_page6.class));
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginWithId(editTextid_login.getText().toString(), edit_pass.getText().toString());
            }
        });
    }

    private void loginWithId(String num, String pass) {
        if (num.length() >= 10 && pass.length() > 6) {
            progressBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(num, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        //   updateUI(user);
                        Intent intent = new Intent(login_page.this, fingerPrint_plus.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(login_page.this, " Login failed.", Toast.LENGTH_SHORT).show();
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