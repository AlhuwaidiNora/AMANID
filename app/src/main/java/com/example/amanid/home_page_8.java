package com.example.amanid;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class home_page_8 extends AppCompatActivity {
    ImageView imageview201, imageview164, imageView77, imageView214, imageView219;
    TextView textView_spec1, greetings;
    FloatingActionButton transfer_icon;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page7);

        String idnum = getIntent().getStringExtra("idnum");
        TextView greetingTextView = findViewById(R.id.greetings);
        greetingTextView.setText("Hello " + (idnum != null ? idnum : "") + "!");



        imageview201 = findViewById(R.id.imageView201);
        imageview164 = findViewById(R.id.imageView164);
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
                Intent intent = new Intent(home_page_8.this, profile.class);
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




