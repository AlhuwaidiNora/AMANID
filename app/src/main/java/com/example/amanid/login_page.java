package com.example.amanid;
import android.util.Log;
import android.widget.Toast;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

public class login_page extends AppCompatActivity {
    Spinner hintQuestionsSpinner;

    EditText hint_answer_edit_text;
    String selectedHintQuestion;

    Button button8;
    EditText editTextid_login;
    EditText edit_pass;
    ProgressBar progressBar;
    TextView textView19;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

      /* Spinner hintQuestionsSpinner = findViewById(R.id.hint_questions_spinner);
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
        });*/

        button8 = findViewById(R.id.button8);
        edit_pass = findViewById(R.id.edit_pass);
        editTextid_login = findViewById(R.id.editTextid_login);
        //  hint_answer_edit_text = findViewById(R.id.hint_answer_edit_text);
        textView19 = findViewById(R.id.textView19);

        initial();


    }

    private void initial() {
        textView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this, Forget_password.class));
            }
        });
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

                }  else {


                    checkUser();
                }

            }
        });
    }

    private void loginWithIds(String num, String pass) {
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
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            // User is signed in, update UI accordingly
            String idnum = user.getUid(); // Get the user I// replace with actual user ID value
            Intent intent = new Intent(login_page.this, home_page_8.class);
            intent.putExtra("idnum", idnum);
            startActivity(intent);
        } else {
            // User is signed out, update UI accordingly
            // For example, show/hide certain views or display a login prompt
        }
    }


    private void loginWithId(String num, String pass) {
        if (num != null && !num.isEmpty() && pass != null && !pass.isEmpty()) {
            // Sign in with email/username/phone number and password
            FirebaseAuth.getInstance().signInWithEmailAndPassword(num, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                updateUI(user);
                                Intent intent = new Intent(login_page.this, fingerPrint_plus_later.class);
                                startActivity(intent);
                            } else {
                                // Sign in failed, display an error message
                                Toast.makeText(login_page.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            // Handle empty email/username/phone number or password
            if (num == null || num.isEmpty()) {
                editTextid_login.setError(" Email/Username/Phone number cannot be empty");
            }
            if (pass == null || pass.isEmpty()) {
                edit_pass.setError(" Password cannot be empty");
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
        // String qhint = hint_answer_edit_text.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        //Query checkUserDatabase = reference.equalTo("idnum",username);

        reference.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("SSSS", "onDataChange: "+snapshot.getChildrenCount());
                if (snapshot.exists()) {
                    editTextid_login.setError(null);
                    String passwordFromDB = snapshot.child("pass").getValue(String.class);
                    //String qhintFromDB = snapshot.child(username).child("hint").getValue(String.class);
                    //&& qhintFromDB.equals(qhint)
                    if (passwordFromDB.equals(userpass) ) {
                        editTextid_login.setError(null);
                        String idnumFromDB = snapshot.child("idnum").getValue(String.class);
                        Intent intent = new Intent(login_page.this, fingerPrint_plus_later.class);
                        startActivity(intent);

                    } else {
                        edit_pass.setError(" Invalid Credentials");
                        edit_pass.requestFocus();
                        // hint_answer_edit_text.setError(" wrong answer");
                        //  hint_answer_edit_text.requestFocus();
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