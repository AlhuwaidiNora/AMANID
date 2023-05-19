package com.example.amanid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

public class Add_New_User extends AppCompatActivity {

    Button button20;
    S3Client s3Client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        button20 = findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_New_User.this, home_page_8.class);
                startActivity(intent);
            }
        });

        s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .build();

        listBuckets();
    }

    private void listBuckets() {
        ListBucketsResponse response = s3Client.listBuckets();
        List<Bucket> buckets = response.buckets();

        for (Bucket bucket : buckets) {
            System.out.println(bucket.name());
        }
    }
}
