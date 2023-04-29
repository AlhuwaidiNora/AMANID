package com.example.amanid;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class getStrated_page3 extends AppCompatActivity {
ImageView imageView34;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_strated_page3);

         imageView34 = findViewById(R.id.imageView34);
        imageView34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getStrated_page3.this, getStarted_page4.class);
                startActivity(intent);
            }
        });
    }
}
