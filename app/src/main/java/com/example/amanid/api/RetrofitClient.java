package com.example.amanid.api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit=null;

    public static final String IP="https://amanapplication.000webhostapp.com/";
    public static final String PORT="8080";
    public static final String BASE_URL="https://amanapplication.000webhostapp.com/";
    //public static final String BASE_URL="http://"+IP+":"+PORT+"/amanApi/";

    public static ApiService getApi(){
        Gson gson = new GsonBuilder()
                .setLenient().disableHtmlEscaping()
                .create();


        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit.create(ApiService.class);
    }
}
