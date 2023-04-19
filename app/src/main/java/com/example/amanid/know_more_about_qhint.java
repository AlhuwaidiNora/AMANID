package com.example.amanid;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class know_more_about_qhint extends AppCompatActivity {
Button button19 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_more_about_qhint);

       String[] hintQuestions = getResources().getStringArray(R.array.hint_questions);
       Spinner hintQuestionsSpinner = findViewById(R.id.hint_questions_spinner);
      ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hintQuestions);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      hintQuestionsSpinner.setAdapter(adapter);


        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(know_more_about_qhint.this, signup_page.class);
                startActivity(intent);
            }
        });
    }
}
