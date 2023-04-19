package com.example.amanid;


        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class createPasssword_later extends AppCompatActivity {
    Button button5;
    EditText editTextTextPersonName2;
    EditText editTextTextPersonName4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_passsword_later);
        button5 = findViewById(R.id.button5);
        editTextTextPersonName4 =findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName2 =findViewById(R.id.editTextTextPersonName2);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    rightpass(editTextTextPersonName2.getText().toString(), editTextTextPersonName4.getText().toString());
                }
            private void   rightpass(String pass1, String pass2) {
                if (pass1.length() >= 6 && pass2.length() >= 6) {
                Intent intent = new Intent(createPasssword_later.this, done_page.class);
               startActivity(intent);

                    } else {
                        if (pass1.length() <6 || pass2.length() < 6) {
                            editTextTextPersonName2.setError(" Error must enter 6 number");
                            editTextTextPersonName4.setError(" Error must enter 6 number");
                        }

                    }
                }
            });

        }

    }