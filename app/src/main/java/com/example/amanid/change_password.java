package com.example.amanid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executor;

public class change_password extends AppCompatActivity {
    private EditText newPasswordEditText;
    private EditText confirmPasswordEditText;
    private ImageView imageView23;
    private Button button232;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private FirebaseUser user;

    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        newPasswordEditText = findViewById(R.id.editTextTextPersonName5);
        confirmPasswordEditText = findViewById(R.id.editTextTextPersonName6);
        imageView23 = findViewById(R.id.imageView23);
        button232 = findViewById(R.id.button232);

        Executor executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(change_password.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }

            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                button232.setVisibility(View.VISIBLE);
            }

            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Reset Password")
                .setDescription("Use Fingerprint Sensor").setDeviceCredentialAllowed(true).build();

        biometricPrompt.authenticate(promptInfo);

        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(change_password.this, setting.class);
                startActivity(intent);
            }
        });

        button232.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button", "Button Clicked");
                String pass = newPasswordEditText.getText().toString();
                String pass2 = confirmPasswordEditText.getText().toString();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                // Check if the new password matches the confirm password
                if (!pass.equals(pass2)) {
                    Toast.makeText(change_password.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                String idnum=new UserSession(change_password.this).gtUserID();
                HashMap<String, Object> map=new HashMap<>();
                map.put("pass",pass);
                map.put("pass2",pass);
                FirebaseDatabase.getInstance().getReference().child("users").child(idnum).updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(change_password.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(change_password.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                // Update the password using Firebase Authentication
//                user.updatePassword(pass)
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    // Password updated successfully
//                                    Toast.makeText(change_password.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
//
//                                    // Reauthenticate the user with the new password
//                                    AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), pass);
//                                    user.reauthenticate(credential)
//                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<Void> task) {
//                                                    if (task.isSuccessful()) {
//                                                        // User reauthenticated successfully
//                                                        // Proceed with further actions if needed
//                                                    } else {
//                                                        // Failed to reauthenticate the user
//                                                        // Handle the failure or prompt the user to sign in again
//                                                    }
//                                                }
//                                            });
//                                } else {
//                                    // An error occurred while updating the password
//                                    Toast.makeText(change_password.this, "Failed to update password", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
            }
        });


    }}