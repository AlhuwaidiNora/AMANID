package com.example.amanid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class change_password extends AppCompatActivity {
    private EditText oldPasswordEditText;
    private EditText newPasswordEditText;
    private EditText confirmPasswordEditText;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Button button23 = findViewById(R.id.button23);
        oldPasswordEditText = findViewById(R.id.editTextTextPersonName3);
        newPasswordEditText = findViewById(R.id.editTextTextPersonName5);
        confirmPasswordEditText = findViewById(R.id.editTextTextPersonName6);

        // initialize the Firebase database reference

        button23.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                databaseReference = FirebaseDatabase.getInstance().getReference("users");
                Log.d("ChangePassword", "Button clicked");
                final String oldPassword = oldPasswordEditText.getText().toString();
                final String newPassword = newPasswordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // check if the new password matches the confirm password
                if (!newPassword.equals(confirmPassword)) {
                    Toast.makeText(change_password.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }



                if (user != null) {
                    final String userId = user.getUid();

                    AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), oldPassword);
                    user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                // Fetch the password from the database
                                databaseReference.child(userId).child("password").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        String passwordFromDB = snapshot.getValue(String.class);
                                        if (oldPassword.equals(passwordFromDB)) {
                                            // Passwords match, update the password
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
                                        } else {
                                            // Passwords don't match
                                            Toast.makeText(change_password.this, "Old password is incorrect", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        // Error occurred while fetching password from database
                                        Toast.makeText(change_password.this, "Failed to fetch password from database", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                // Re-authentication failed
                                Toast.makeText(change_password.this, "Old password is incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
