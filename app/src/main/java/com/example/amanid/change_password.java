package com.example.amanid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
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
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String oldPassword = oldPasswordEditText.getText().toString();
                final String newPassword = newPasswordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // check if the new password matches the confirm password
                if (!newPassword.equals(confirmPassword)) {
                    Toast.makeText(change_password.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // check if the old password matches the one stored in Firebase
                databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            String passwordFromDB = snapshot.child("password").getValue(String.class);
                            if (passwordFromDB.equals(oldPassword)) {
                                // if the old password matches, update the password in Firebase
                                databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("password").setValue(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(change_password.this, "Password changed successfully", Toast.LENGTH_SHORT).show();
                                            // navigate to the next activity
                                            Intent intent = new Intent(change_password.this, setting.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(change_password.this, "Failed to change password", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(change_password.this, "Old password is incorrect", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(change_password.this, "User not found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(change_password.this, "Error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
