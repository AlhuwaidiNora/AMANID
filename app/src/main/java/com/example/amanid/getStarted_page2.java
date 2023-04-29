package com.example.amanid;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class getStarted_page2 extends AppCompatActivity {

     ImageView imageView33 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started_page2);

        imageView33 = findViewById(R.id.imageView33);
        imageView33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getStarted_page2.this, getStrated_page3.class);
                startActivity(intent);
            }
        });
    }

    public void goToPage3(View view) {
        Intent intent = new Intent(this, getStrated_page3.class);
        startActivity(intent);
    }
}
