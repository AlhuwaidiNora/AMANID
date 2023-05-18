package com.example.amanid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
/*
original code
 */
public class signup_page extends AppCompatActivity {
    EditText editTextid_signup , editTextpass ,editTextpass2 ,editTextid_qhint;
    TextView  textView29;
    Button button9 ;
    EditText hintAnswerEditText;
    String selectedHintQuestion;
    FirebaseDatabase database;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amanid-e0318-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        Spinner hintQuestionsSpinner = findViewById(R.id.hint_questions_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hint_questions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hintQuestionsSpinner.setAdapter(adapter);

        hintAnswerEditText = findViewById(R.id.hintAnswerEditText);

        hintQuestionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedHintQuestion = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

      //   TextView btn=findViewById(R.id.textView30);
        editTextid_signup = findViewById(R.id.editTextid_signup);
        editTextpass = findViewById(R.id.editTextpass);
        textView29 = findViewById(R.id.textView29);
        editTextpass2 = findViewById(R.id.editTextpass2);
        // editTextid_qhint = findViewById(R.id. hintAnswerEditText);
        hintAnswerEditText = findViewById(R.id.hintAnswerEditText);
        button9 = findViewById(R.id.button9);

        textView29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup_page.this, Terms_Conditions.class);
                startActivity(intent);
            }
        });
        button9.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String idnum = editTextid_signup.getText().toString();
                String pass = editTextpass.getText().toString();
                String pass2 = editTextpass2.getText().toString();
                String qhint = hintAnswerEditText.getText().toString();
                if (idnum.isEmpty() || qhint.isEmpty() || pass.isEmpty() || pass2.isEmpty()) {
                    Toast.makeText(signup_page.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                } else if (!pass.equals(pass2)) {
                    Toast.makeText(signup_page.this, "Passwords are not matching", Toast.LENGTH_LONG).show();
                } else if (pass.length() < 6 || !pass.matches(".*[a-zA-Z]+.*")) {
                    Toast.makeText(signup_page.this, "Password should be at least 6 characters long and contain letters", Toast.LENGTH_LONG).show();
            } else {
                    reference.child(idnum).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if id not registered before
                            if (snapshot.exists()){
                                Toast.makeText(signup_page.this, " ID number is already signup", Toast.LENGTH_LONG).show();
                            }else{
                                // sending data
                                HelperClass helperClass = new HelperClass(idnum, pass, pass2,qhint);
                                reference.child(idnum).setValue(helperClass);
                                new UserSession(signup_page.this).setUserID(idnum);
                                reference.child(idnum).child("idnum").setValue(idnum);
                                reference.child("users").child(idnum).child("hint").setValue(qhint);

                                Toast.makeText(signup_page.this, "you have signup successfully!", Toast.LENGTH_LONG).show();
                                finish();
                                Intent intent = new Intent(signup_page.this, fingerPrint_page7_later.class);
                                startActivity(intent);}}
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }});
                }
            }});

    }
}
