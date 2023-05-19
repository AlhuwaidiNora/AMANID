package com.example.amanid;

import com.google.firebase.firestore.DocumentSnapshot;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiService {
    @GET("/users")
    Call<List<DocumentSnapshot>> getUsers();
}

