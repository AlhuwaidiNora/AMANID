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

    private String receiver;
    private double amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        receiver=getIntent().getStringExtra("receiver");
        amount=getIntent().getDoubleExtra("amount",0);
        button8 = findViewById(R.id.button8);
        edit_pass = findViewById(R.id.edit_pass);
        editTextid_login = findViewById(R.id.editTextid_login);
        textView19 = findViewById(R.id.textView19);
        initial();
        String uniqueId = getIntent().getStringExtra("uniqueId");}
    private void initial() {
        textView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this, Forget_password.class));}});
        TextView btn = findViewById(R.id.textViewSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this, signup_page.class));}});
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateidnum() | !validatepass()) {
                }  else {
                    checkUser();}}});}
    private void loginWithIds(String num, String pass) {
        if (num.length() >= 10 && pass.length() > 6) {
            Intent intent = new Intent(login_page.this, fingerPrint_plus_later.class);
            startActivity(intent);
        } else {
            if (editTextid_login.length() < 10) {
                editTextid_login.setError(" the ID number not valid");
            }
            if (edit_pass.length() < 6) {
                edit_pass.setError(" the Password not valid");
            }}}
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
                            }}});
        } else {
            // Handle empty email/username/phone number or password
            if (num == null || num.isEmpty()) {
                editTextid_login.setError(" Email/Username/Phone number cannot be empty");
            }
            if (pass == null || pass.isEmpty()) {
                edit_pass.setError(" Password cannot be empty");
            }}}
    public Boolean validateidnum() {
        String val = editTextid_login.getText().toString();
        if (val.isEmpty()) {
            editTextid_login.setError(" id number cannot be empty");
            return false;
        } else {
            editTextid_login.setError(null);
            return true;
        }}
    public Boolean validatepass() {
        String val = edit_pass.getText().toString();
        if (val.isEmpty()) {
            edit_pass.setError(" password cannot be empty");
            return false;
        } else {
            editTextid_login.setError(null);
            return true;}}
    public void checkUser() {
        String username = editTextid_login.getText().toString().trim();
        String userpass = edit_pass.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("SSSS", "onDataChange: "+snapshot.getChildrenCount());
                if (snapshot.exists()) {
                    editTextid_login.setError(null);
                    String passwordFromDB = snapshot.child("pass").getValue(String.class);
                    if (passwordFromDB.equals(userpass) ) {
                        editTextid_login.setError(null);
                        String idnumFromDB = snapshot.child("idnum").getValue(String.class);
                        new UserSession(login_page.this).setUserID(idnumFromDB);
                        Intent intent = new Intent(login_page.this, fingerPrint_plus_later.class);
                        intent.putExtra("amount",amount);
                        intent.putExtra("receiver",receiver);
                        startActivity(intent);
                    } else {
                        edit_pass.setError(" Invalid Credentials");
                        edit_pass.requestFocus();}
                } else {
                    editTextid_login.setError(" User dose not exist");
                    editTextid_login.requestFocus();
                }}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }});

    }

}

