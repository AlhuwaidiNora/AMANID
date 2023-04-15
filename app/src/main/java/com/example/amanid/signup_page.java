package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup_page extends AppCompatActivity {
EditText editTextid_signup , editTextpass ,editTextpass2 ,editTextid_qhint;
 Button button9 ;
    EditText hintAnswerEditText;
    EditText hint_answer_edit_text;
    String selectedHintQuestion;
 FirebaseDatabase database;
 DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        Spinner hintQuestionsSpinner = findViewById(R.id.hint_questions_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hint_questions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hintQuestionsSpinner.setAdapter(adapter);

        hintAnswerEditText = findViewById(R.id.hint_answer_edit_texts);

        hintQuestionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedHintQuestion = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        TextView btn=findViewById(R.id.textView30);
        editTextid_signup = findViewById(R.id.editTextid_signup);
        editTextpass = findViewById(R.id.editTextpass);
        editTextpass2 = findViewById(R.id.editTextpass2);
        editTextid_qhint = findViewById(R.id.hint_answer_edit_texts);
        hint_answer_edit_text = findViewById(R.id.hint_answer_edit_texts);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String idnum = editTextid_signup.getText().toString();
                String pass = editTextpass.getText().toString();
                String pass2 = editTextpass2.getText().toString();
                String qhint = editTextid_qhint.getText().toString();
                HelperClass helperClass = new HelperClass(idnum, pass, pass2, qhint);
                reference.child(idnum).setValue(helperClass);
                Toast.makeText(signup_page.this, "you have signup successfully!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(signup_page.this, done_page9.class);

                startActivity(intent);
                database = FirebaseDatabase.getInstance("https://amanid-9f955-default-rtdb.firebaseio.com/");
                reference = database.getReference("users");

            }});

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup_page.this,know_more_about_qhint.class));
            }
        });


}
}
