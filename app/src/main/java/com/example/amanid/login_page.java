package com.example.amanid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

        hintQuestionsSpinner = findViewById(R.id.hint_questions_spinner);
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
                if (!validateidnum() || !validatepass()) {

                } else {
                    checkUser();
                }
            }
        });
    }

    private void loginWithId(String num, String pass) {
        if (num.length() >= 10 && pass.length() > 6) {
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
            edit_pass.setError(null);
            return true;
        }

    }
    public class User {
        private String idNum;
        private String password;
        private String hintAnswer;
        private String hintQuestion;

        // Default constructor
        public User() {
            // Required for Firebase
        }

        // Getter for idNum field
        public String getIdNum() {
            return idNum;
        }

        // Setter for idNum field
        public void setIdNum(String idNum) {
            this.idNum = idNum;
        }

        // Getter for password field
        public String getPassword() {
            return password;
        }

        // Setter for password field
        public void setPassword(String password) {
            this.password = password;
        }

        // Getter for hintAnswer field
        public String getHintAnswer() {
            return hintAnswer;
        }

        // Setter for hintAnswer field
        public void setHintAnswer(String hintAnswer) {
            this.hintAnswer = hintAnswer;
        }

        // Getter for hintQuestion field
        public String getHintQuestion() {
            return hintQuestion;
        }

        // Setter for hintQuestion field
        public void setHintQuestion(String hintQuestion) {
            this.hintQuestion = hintQuestion;
        }
    }

    public void checkUser() {
        String username = editTextid_login.getText().toString().trim();
        String userpass = edit_pass.getText().toString().trim();
        String userHintAnswer = hint_answer_edit_text.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("idnum").equalTo(username);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        User user = snapshot.getValue(User.class);
                        if (user != null) {
                            String passFromDB = user.getPassword();
                            String hintAnswerFromDB = user.getHintAnswer();
                            if (passFromDB.equals(userpass)) {
                                if (selectedHintQuestion.equals(user.getHintQuestion())
                                        && userHintAnswer.equals(hintAnswerFromDB)) {
                                    loginWithId(username, userpass);
                                } else {
                                    hint_answer_edit_text.setError("Hint answer is incorrect.");
                                }
                            } else {
                                edit_pass.setError("Password is incorrect.");
                            }
                        }
                    }
                } else {
                    editTextid_login.setError("ID number not found.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database error
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