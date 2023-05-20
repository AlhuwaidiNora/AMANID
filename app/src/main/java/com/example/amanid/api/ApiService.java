package com.example.amanid.api;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("operation/insertOperation.php")
    public Call<Operation> addOpertion(@Query(value = "name",encoded = true)String name,
                                       @Query(value = "amount",encoded = true) String amount);

    @GET("operation/getOperation.php")
    public Call<Operation> getOpertion(@Query(value = "id",encoded = true)String id);

}
