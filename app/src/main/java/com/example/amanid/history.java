package com.example.amanid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Z Specification:
 *   - Preconditions: The activity has been created.
 *   - Postconditions: On button click, the home_page_8 activity is started.
 */

public class history extends AppCompatActivity {
 Button button18 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        button18 =findViewById(R.id.button18);








        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(history.this, home_page_8.class);
                startActivity(intent);
            }
        });

    }
}