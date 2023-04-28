package com.example.amanid;
import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class done_page extends AppCompatActivity {
    Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_page9);
       // button6 = findViewById(R.id.button6);
       /* button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(done_page9.this, login_page.class);
                startActivity(intent);
            }
        });*/
        new Handler().postDelayed(new Runnable() {



            @Override

            public void run() {

                Intent i = new Intent(done_page.this, intro_option_page5.class);

                startActivity(i);


                finish();

            }

        }, 1*1000); // wait for 1 seconds

    }
    }

