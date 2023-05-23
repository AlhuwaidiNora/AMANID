package com.example.amanid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    ImageView imageview201, imageview164, imageView77, imageView214, imageView219;
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
//       if (b != null) {
//          Toast.makeText(this, b.getString("name"), Toast.LENGTH_LONG).show();
//   String idnum = getIntent().getStringExtra("idnum");
//         TextView greetingTextView = findViewById(R.id.greetings);
//          greetingTextView.setText("Hello " + (idnum != null ? idnum : "") + "!");
//     } else {
//            // handle the case where the bundle is null
//        }
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
      //  imageview164 = findViewById(R.id.imageView164);
        //  imageView77 = findViewById(R.id.imageView77);
        imageView214 = findViewById(R.id.imageView214);
        imageView219 = findViewById(R.id.imageView219);
        transfer_icon = findViewById(R.id.transfer_icon);
        // imageView77.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //   public void onClick(View v) {
        //      Intent intent = new Intent(home_page_8.this, transfer.class);
        //     startActivity(intent);
        //   }
        // });
        // ImageView imageViewWallet = findViewById(R.id.imageView219);
        //   imageViewWallet.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //    public void onClick(View v) {
        // Start a new activity to navigate to wallet XML layout
        //      Intent intent = new Intent(home_page_8.this, wallet.class); // Replace YourCurrentActivity with the name of your current activity
        //     startActivity(intent);
        //   }
        //  });
        //  ImageView imageView201 = findViewById(R.id.imageView201);
        //  imageView201.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        // Start a new activity to navigate to wallet XML layout
        //        Intent intent = new Intent(home_page_8.this, setting.class); // Replace YourCurrentActivity with the name of your current activity
        //       startActivity(intent);
        //    }
        // });
        //   ImageView imageViewProfile = findViewById(R.id.imageView13);
        //  imageViewProfile.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //    public void onClick(View v) {
        // Start a new activity to navigate to wallet XML layout
        ///      Intent intent = new Intent(home_page_8.this, profile.class); // Replace YourCurrentActivity with the name of your current activity
        //     startActivity(intent);
        //    }
        //   });



        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();

        // transfer_icon.setOnClickListener(new View.OnClickListener() {
        // @Override
        //  public void onClick(View v) {
        //      Intent intent = new Intent(home_page_8.this, transfer.class);
        //      startActivity(intent);
        //   }
        // });

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

        // setContentView(R.layout.activity_home_page7);

//        ImageView imageview164 = findViewById(R.id.imageView1645);

        //  if (imageview164 != null) {
        //   imageview164.setOnClickListener(new View.OnClickListener() {
        ///   @Override
        //  public void onClick(View v) {
        //     AlertDialog.Builder builder = new AlertDialog.Builder(home_page_8.this);
        //  builder.setTitle("Add Money");
        //    builder.setItems(new CharSequence[]{"Add money from credit card", "Add money from bank transfer"},
        //        new DialogInterface.OnClickListener() {
        //       @Override
        //       public void onClick(DialogInterface dialog, int which) {
        //      if (which == 0) {
        //          // Option 1: Add money from credit card
        // Perform the corresponding action
        //      } else if (which == 1) {
        // Option 2: Add money from bank transfer
        //           // Perform the corresponding action
        //         }
        //        }
        //    });
        //  builder.show();
        //    }
        //    });
    }




    // Rest of your code here...
    // ...
}







