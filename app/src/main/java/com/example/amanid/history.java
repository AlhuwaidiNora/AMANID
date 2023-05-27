package com.example.amanid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

/**
 * Z Specification:
 *   - Preconditions: The activity has been created.
 *   - Postconditions: On button click, the home_page_8 activity is started.
 */

public class history extends AppCompatActivity {
   ImageView imageView19 ;
    private RecyclerView recyclerView;
    private HistoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        imageView19 =findViewById(R.id.imageView19);
        recyclerView=findViewById(R.id.recyclerView);
        EditText editTextSearch = findViewById(R.id.editTextText2);
        adapter = new HistoryAdapter();
        recyclerView.setAdapter(adapter);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String searchText = charSequence.toString().trim();
                adapter.filter(searchText);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Not used
            }
        });
        imageView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(history.this, home_page_8.class);
                startActivity(intent);
            }
        });

    }
    protected void onStart() {
        super.onStart();
        FirebaseFirestore.getInstance().collection("history")
                .whereEqualTo("idnum", new UserSession(this).gtUserID()).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<HistoryModel> historyModels = task.getResult().toObjects(HistoryModel.class);
                            if (historyModels.isEmpty()) {
                                Toast.makeText(history.this, "No History", Toast.LENGTH_SHORT).show();
                            } else {
                                HistoryAdapter adapter = new HistoryAdapter();
                                adapter.setOriginalList(historyModels); // Set the original list
                                adapter.submitList(historyModels);
                                recyclerView.setAdapter(adapter);
                            }
                        } else {
                            Toast.makeText(history.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

  /*  protected void onStart() {
        super.onStart();
        FirebaseFirestore.getInstance().collection("history")
                .whereEqualTo("idnum",new UserSession(this).gtUserID()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            List<HistoryModel> historyModels=task.getResult().toObjects(HistoryModel.class);
                            if(historyModels.isEmpty()){
                                Toast.makeText(history.this, "No History", Toast.LENGTH_SHORT).show();
                            }else {
                                HistoryAdapter adapter=new HistoryAdapter();
                                adapter.submitList(historyModels);
                                recyclerView.setAdapter(adapter);
                            }
                        }else {
                            Toast.makeText(history.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }*/
}