package com.example.amanid;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class HelperClass {
    String indnium;
    String pass;
    String pass2;
    String hint;

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

    public String idnum() {
        return indnium;
    }

    public void idnum(String indium) {
        this.indnium = indnium;
    }

    public HelperClass(String idnum, String pass, String pass2, String qhint) {
        this.indnium = indnium;
        this.pass2 = pass2;
        this.pass = pass;
        this.hint = qhint;
    }

    public HelperClass() {
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
}
