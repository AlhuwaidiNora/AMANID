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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.Executor;

public class change_password extends AppCompatActivity {
    private EditText newPasswordEditText;
    private EditText confirmPasswordEditText;
    private Button button6;
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
        button6 = findViewById(R.id.button6);
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

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(change_password.this, setting.class);
                startActivity(intent);
            }
        });

// ...

        button232.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button", "Button Clicked");
                String pass = newPasswordEditText.getText().toString();
                String pass2 = confirmPasswordEditText.getText().toString();

                // Check if the new password matches the confirm password
                if (!pass.equals(pass2)) {
                    Toast.makeText(change_password.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // User is authenticated
                    String userId = user.getUid();
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userId);

                    // Update the password in the database directly with the new password
                    databaseReference.child("pass").setValue(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                // Password updated successfully in the database
                                // Now update the password in Firebase Authentication
                                user.updatePassword(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            // Password updated successfully in Firebase Authentication system
                                            Toast.makeText(change_password.this, "Password updated successfully", Toast.LENGTH_SHORT).show();

                                            Intent intent = new Intent(change_password.this, setting.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            // Password update failed in Firebase Authentication system
                                            Toast.makeText(change_password.this, "Failed to update password", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                // Password update failed in the database
                                Toast.makeText(change_password.this, "Failed to update password in database", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    // User is not authenticated
                    Toast.makeText(change_password.this, "User not authenticated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}