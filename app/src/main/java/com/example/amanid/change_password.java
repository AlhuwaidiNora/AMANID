package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class change_password extends AppCompatActivity {

    private EditText newPasswordEditText;
    private EditText confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Button button23 = findViewById(R.id.button23);
        newPasswordEditText = findViewById(R.id.editTextTextPersonName5);
        confirmPasswordEditText = findViewById(R.id.editTextTextPersonName6);

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = newPasswordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if (!newPassword.equals(confirmPassword)) {
                    // if the new password does not match the confirm password, display an error message
                    // and return without encrypting the password
                    Toast.makeText(change_password.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // if the new password matches the confirm password, encrypt the password
                String encryptedPassword = encryptPassword(newPassword);

                // you can then store the encrypted password in a database or a file
                // or send it to a server, depending on your requirements

                // finally, navigate to the next activity
                Intent intent = new Intent(change_password.this, setting.class);
                startActivity(intent);
            }
        });
    }

    private String encryptPassword(String password) {
        // encrypt the password using an appropriate encryption algorithm
        // you can use a library like Bouncy Castle or a built-in encryption algorithm like AES
        // for simplicity, we will just return the password as is
        return password;
    }
}
