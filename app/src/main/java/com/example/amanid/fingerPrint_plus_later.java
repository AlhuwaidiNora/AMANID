package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.Executor;

import java.util.concurrent.Executor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class fingerPrint_plus_later extends AppCompatActivity {
    ImageView imageView2;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    ConstraintLayout mMainLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print_plus_later);
        mMainLayout1 = findViewById(R.id.mMainLayout1);


        BiometricManager biometricManager= BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()){
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(),"Device Dose not have FingerPrint ",Toast.LENGTH_LONG).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(),"not working ",Toast.LENGTH_LONG).show();


            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext()," NO FingerPrint Assign ",Toast.LENGTH_LONG).show();
        }
        Executor executor= ContextCompat.getMainExecutor(this);

        biometricPrompt= new BiometricPrompt(fingerPrint_plus_later.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }


            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext()," Login Successful ",Toast.LENGTH_LONG).show();
                mMainLayout1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {



                    @Override

                    public void run() {

                        Intent i = new Intent(fingerPrint_plus_later.this, home_page_8.class);

                        startActivity(i);


                        finish();

                    }

                }, 1*1000); // wait for 1 seconds



            }


            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString){
                super.onAuthenticationError(errorCode, errString);
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("AMANID")
                .setDescription("Use FingerPrint To Login ").setDeviceCredentialAllowed(true).build();

        biometricPrompt.authenticate(promptInfo);





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