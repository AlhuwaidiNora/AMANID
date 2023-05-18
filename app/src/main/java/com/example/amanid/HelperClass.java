package com.example.amanid;
import android.content.Context;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HelperClass {
    String indium;
    String pass;
    String pass2;
    String hint;
    public HelperClass() {
    }
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String gethint() {
        return hint;
    }

    public void sethint(String hint) {
        this.hint = hint;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String indium() {
        return indium;
    }

    public void indium(String indium) {
        this.indium = indium;
    }

    public HelperClass(String indium, String pass, String pass2, String qhint) {
        this.indium = this.indium;
        this.pass2 = pass2;
        this.pass = pass;
        this.hint = qhint;
    }

    public HelperClass(String idnum, String qhint) {
    }


    // Example method to sign in a user with email and password
    public void signInWithEmail(String email, String password) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        // Call a method or update UI with user information
                    } else {
                        // Sign in failed, display an error message
                        // Call a method or display an error message
                    }
                });
    }


    // Example method to sign out a user
    public void signOut() {
        FirebaseAuth.getInstance().signOut();
        // Call a method or update UI after sign out
    }
    public void changePassword(String newPassword, Context context) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.updatePassword(newPassword).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    // Password updated successfully
                    // Call a method or display a success message
                } else {
                    // Password update failed
                    // Call a method or display an error message
                }
            });
        }
    }

    public class AuthManager {
        private FirebaseAuth firebaseAuth;

        public AuthManager() {
            firebaseAuth = FirebaseAuth.getInstance();
        }

        public void registerUser(String email, String password) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // User registration successful
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            // Proceed with further actions, e.g., saving user data to a database
                        } else {
                            // User registration failed
                            // Display an error message or handle the failure
                        }
                    });
        }

        public void loginUser(String email, String password) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // User login successful
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            // Proceed with further actions, e.g., navigate to the main screen
                        } else {
                            // User login failed
                            // Display an error message or handle the failure
                        }
                    });
        }

        public void resetPassword(String email) {
            firebaseAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Password reset email sent successfully
                            // Display a success message or navigate to a confirmation screen
                        } else {
                            // Failed to send password reset email
                            // Display an error message or handle the failure
                        }
                    });
        }

        public FirebaseUser getCurrentUser() {
            return firebaseAuth.getCurrentUser();
        }
    }


}


// last update