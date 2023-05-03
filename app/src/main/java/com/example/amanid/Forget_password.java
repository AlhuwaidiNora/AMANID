package com.example.amanid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Executor;

public class Forget_password extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private Button confirmButton;
    private Button button137;
    private EditText forgetpassword;
    private EditText hintanswer;

    FirebaseDatabase database;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amanid-e0318-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        button137 = findViewById(R.id.button137);
        confirmButton = findViewById(R.id.confirmButton); // initialize confirmButton
         forgetpassword = findViewById(R.id.forgetpassword);
         hintanswer = findViewById(R.id.hintanswer);

        initial2();
        // Initialize Firebase Authentication
      //  mAuth = FirebaseAuth.getInstance();


        button137.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forget_password.this, login_page.class);
                startActivity(intent);
            }
        });

        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(), "Device Does Not Have Fingerprint Sensor", Toast.LENGTH_LONG).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(), "Fingerprint Sensor Is Currently Unavailable", Toast.LENGTH_LONG).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(), "No Fingerprint Sensor Found", Toast.LENGTH_LONG).show();
                break;
        }

        Executor executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(Forget_password.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }

            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                confirmButton.setVisibility(View.VISIBLE);
            }

            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Reset Password")
                .setDescription("Use Fingerprint Sensor").setDeviceCredentialAllowed(true).build();

        biometricPrompt.authenticate(promptInfo);



    }
    private void initial2() {
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!validateidnum() | !validateqhint()) {

                }  else {
                   checkUser2();
                }
            }
        });
    }

    public Boolean validateidnum() {
        String val = forgetpassword.getText().toString();
        if (val.isEmpty()) {
            forgetpassword.setError(" id number cannot be empty");
            return false;
        } else {
            forgetpassword.setError(null);
            return true;
        }

    }

    public Boolean validateqhint() {
        String val = hintanswer.getText().toString();
        if (val.isEmpty()) {
            hintanswer.setError(" cannot be empty");
            return false;
        } else {
            hintanswer.setError(null);
            return true;
        }

    }
        public void checkUser2() {
            String username1 = forgetpassword.getText().toString().trim();
            String qhint = hintanswer.getText().toString().trim();
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

           // Query checkUserDatabase = reference.equalTo("idnum",username);

            reference.child(username1).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Log.d("SSSS", "onDataChange: "+snapshot.getChildrenCount());
                    if (snapshot.exists()) {
                        forgetpassword.setError(null);
                        String qhintFromDB = snapshot.child(qhint).child("hint").getValue(String.class);
                         qhintFromDB.equals(qhint);
                        if (qhintFromDB.equals(qhint) ) {
                            forgetpassword.setError(null);
                            String idnumFromDB = snapshot.child("idnum").getValue(String.class);
                            Intent intent = new Intent(Forget_password.this, createPasssword_later.class);
                            startActivity(intent);

                        } else {

                            hintanswer.setError(" wrong answer");
                            hintanswer.requestFocus();
                        }

                    } else {
                        forgetpassword.setError(" User dose not exist");
                        forgetpassword.requestFocus();
                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });





























               /*  database = FirebaseDatabase.getInstance();

                String idnum =  forgetpassword.getText().toString();
                String qhint = hintanswer.getText().toString();

                if (idnum.isEmpty() || qhint.isEmpty() ){
                Toast.makeText(Forget_password.this, "Please fill all fields", Toast.LENGTH_LONG).show();

                }  else {
                    reference.child(idnum).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if id not registered before
                            if  (!snapshot.exists()) {
                                Toast.makeText(Forget_password.this, " ID number is not exists", Toast.LENGTH_LONG).show();
                            }else{
                                // sending data
//                                reference.child("users").child(idnum).child("pass").setValue(pass);
//                                reference.child("users").child(idnum).child("idnum").setValue(idnum);
                                HelperClass helperClass = new HelperClass(idnum , qhint);
                                reference.child(idnum).setValue(helperClass);
                                reference.child(idnum).child("idnum").setValue(idnum);
                                Toast.makeText(Forget_password.this, "you have reset successfully!", Toast.LENGTH_LONG).show();
                                finish();
                                Intent intent = new Intent(Forget_password.this, createPasssword_later.class);
                                startActivity(intent);

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }

                    });
                    // sending data
                    //  reference.child("users").child(idnum).child("qhint").setValue(qhint);
                    //  reference.child("users").child(idnum).child("pass").setValue(pass);
                    //  Toast.makeText(signup_page.this, "you have signup successfully!", Toast.LENGTH_LONG).show();
                    //  finish();

                } */


                //Toast.makeText(signup_page.this, "you have signup successfully!", Toast.LENGTH_LONG).show();
                // Intent intent = new Intent(signup_page.this, login_page.class);
                // startActivity(intent);

}
}

