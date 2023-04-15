package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup_page extends AppCompatActivity {
EditText editTextid_signup , editTextpass ,editTextpass2 ,editTextid_qhint;
 Button button9 ;
 FirebaseDatabase database;
 DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        TextView btn=findViewById(R.id.textView30);
        editTextid_signup = findViewById(R.id.editTextid_signup);
        editTextpass = findViewById(R.id.editTextpass);
        editTextpass2 = findViewById(R.id.editTextpass2);
        editTextid_qhint = findViewById(R.id.editTextid_qhint);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String idnum = editTextid_signup.getText().toString();
                String pass = editTextpass.getText().toString();
                String pass2 = editTextpass2.getText().toString();
                String qhint = editTextid_qhint.getText().toString();
                HelperClass helperClass = new HelperClass(idnum , pass , pass2 ,qhint);
                reference.child(idnum).setValue(helperClass);
                Toast.makeText(signup_page.this, "you have signup successfully!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(signup_page.this,done_page9.class);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup_page.this,know_more_about_qhint.class));
            }
        });


}
}
