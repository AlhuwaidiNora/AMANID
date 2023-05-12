package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class fingerPrint_plus_later extends AppCompatActivity {
    private ImageView imageView2;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private ConstraintLayout mainLayout1;
    private Button confirmButton;
    private boolean forgotPasswordClicked = false;
    private String receiver;
    private double amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print_plus_later);
        mainLayout1 = findViewById(R.id.mMainLayout1);
        receiver=getIntent().getStringExtra("receiver");
        amount=getIntent().getDoubleExtra("amount",0);

        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(), "Device does not have fingerprint reader", Toast.LENGTH_LONG).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(), "Fingerprint reader not working", Toast.LENGTH_LONG).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(), "No fingerprints assigned", Toast.LENGTH_LONG).show();
                break;
        }

        Executor executor = ContextCompat.getMainExecutor(this);

        biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                mainLayout1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(() -> {
                    Intent i;
                    if (forgotPasswordClicked) {
                        i = new Intent(fingerPrint_plus_later.this, Forget_password.class);
                    } else {
                        i = new Intent(fingerPrint_plus_later.this, home_page_8.class);
                        i.putExtra("amount",amount);
                        i.putExtra("receiver",receiver);
                    }
                    startActivity(i);
                    finish();
                }, 1000);
            }

            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("AMANID")
                .setDescription("Use fingerprint to login")
                .setDeviceCredentialAllowed(true)
                .build();

        biometricPrompt.authenticate(promptInfo);

        confirmButton = findViewById(R.id.confirmButton);
        if (confirmButton != null) {
            confirmButton.setOnClickListener(v -> {
                forgotPasswordClicked = true;
                biometricPrompt.cancelAuthentication();
                Intent intent = new Intent(fingerPrint_plus_later.this, Forget_password.class);
                startActivity(intent);
            });
        }
    }


}


// imageView2 = findViewById(R.id.imageView2);
///    imageView2.setOnClickListener(new View.OnClickListener() {
//  @Override
//  public void onClick(View v) {
//     Intent intent = new Intent(fingerPrint_plus_later.this, done_page9.class);
//    startActivity(intent);
//     }
// });