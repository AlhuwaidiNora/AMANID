package com.example.amanid;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class know_more_about_qhint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_more_about_qhint);

        String[] hintQuestions = getResources().getStringArray(R.array.hint_questions);
        Spinner hintQuestionsSpinner = findViewById(R.id.activity_know_more_about_qhint);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, hintQuestions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hintQuestionsSpinner.setAdapter(adapter);
    }
}
