package com.example.amanid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amanid.api.Operation;
import com.example.amanid.api.RetrofitClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home_page_8 extends AppCompatActivity {
    ImageView imageview201, imageview164, imageView50, imageView214, imageView219;
    TextView textView_spec1, greetings;

    FloatingActionButton transfer_icon;
    FirebaseAuth firebaseAuth;
    private String receiver;
    private double amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page7);
        Bundle b = getIntent().getExtras();
        String idnum=new UserSession(this).gtUserID();
        TextView greetingTextView = findViewById(R.id.greetings);
        greetingTextView.setText("Hello " + (idnum != null ? idnum : "") + "!");
        if(getIntent().hasExtra("receiver")){
            receiver=getIntent().getStringExtra("receiver");
            DialogHelper dialogHelper=new DialogHelper(home_page_8.this);
            dialogHelper.show("Please wait");
            RetrofitClient.getApi().getOpertion(receiver).enqueue(new Callback<Operation>() {
                @Override
                public void onResponse(Call<Operation> call, Response<Operation> response) {
                    dialogHelper.hide();
                    Operation operation=response.body();
                    if(operation!=null){
                        if(operation.getId().equals("-1")){
                            Toast.makeText(home_page_8.this, "Error in get Data", Toast.LENGTH_SHORT).show();
                        }else {
                            TextView amountText=findViewById(R.id.textView47);
                            TextView receiverName=findViewById(R.id.textView48);
                            amountText.setText(String.valueOf(operation.getAmount())+" SAR");
                            receiverName.setText(operation.getName());
                            String id= FirebaseFirestore.getInstance().collection("history").document().getId();
                            HistoryModel model=new HistoryModel(id,operation.getName(),String.valueOf(operation.getAmount()),
                                    idnum);
                            FirebaseFirestore.getInstance().collection("history").document().set(model);

                        }
                    }else{
                        Toast.makeText(home_page_8.this, "Error in get Data", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Operation> call, Throwable t) {
                    dialogHelper.hide();
                    Toast.makeText(home_page_8.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }

        imageview201 = findViewById(R.id.imageView201);
        imageView214 = findViewById(R.id.imageView214);
        imageView219 = findViewById(R.id.imageView219);
        transfer_icon = findViewById(R.id.transfer_icon);
        imageView50 = findViewById(R.id.imageView50);



        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();
        imageView50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, done_transfer.class);
                startActivity(intent);
            }
        });
        imageView219.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, wallet.class);
                startActivity(intent);
            }
        });

        imageView214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, history.class);
                startActivity(intent);
            }
        });

        imageview201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page_8.this, setting.class);
                startActivity(intent);
            }
        });


    }
}







