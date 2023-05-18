package com.example.amanid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseAuth;

public class UserSession {
    private SharedPreferences preferences;

    private SharedPreferences.Editor editor;
    private Context context;

    public UserSession(Context context){
        this.context=context;
        preferences=context.getSharedPreferences("data",0);
        editor=preferences.edit();
    }



    public void setUserID(String id){
        editor.putString("id",id).commit();
    }

    public String gtUserID(){
        return preferences.getString("id",null);
    }


}
