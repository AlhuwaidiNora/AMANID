package com.example.amanid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
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
    private EditText oldPasswordEditText;
    private EditText newPasswordEditText;
    private EditText confirmPasswordEditText;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    Button button6 ;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        Button button232 = findViewById(R.id.button232);
        oldPasswordEditText = findViewById(R.id.editTextTextPersonName3);
        newPasswordEditText = findViewById(R.id.editTextTextPersonName5);
        confirmPasswordEditText = findViewById(R.id.editTextTextPersonName6);
        button6=findViewById(R.id.button6);
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

        // Get the current FirebaseUser
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        // Initialize the Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        button232.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = newPasswordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // Check if the new password matches the confirm password
                if (!newPassword.equals(confirmPassword)) {
                    Toast.makeText(change_password.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (user != null) {
                    String userId = user.getUid();

                    // Fetch the old password from the database
                    databaseReference.child(userId).child("password").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String passwordFromDB = snapshot.getValue(String.class);

                            if (passwordFromDB != null && passwordFromDB.equals(newPassword)) {
                                // Old password matches, update the password in both Firebase Authentication and the database
                                user.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            // Password updated successfully in Firebase Authentication system
                                            // Now update the password in the database as well
                                            databaseReference.child(userId).child("password").setValue(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        // Password updated successfully in the database
                                                        Toast.makeText(change_password.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
                                                        finish();
                                                    } else {
                                                        // Password update failed in the database
                                                        Toast.makeText(change_password.this, "Failed to update password in database", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                        } else {
                                            // Password update failed in Firebase Authentication system
                                            Toast.makeText(change_password.this, "Failed to update password", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            // Error occurred while

                            // Error occurred while fetching password from database
// Error occurred while fetching password from database
                            Toast.makeText(change_password.this, "Failed to fetch password from database", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
