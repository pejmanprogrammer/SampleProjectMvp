package com.example.pejman.model;

import android.content.Context;
import android.content.SharedPreferences;

public class ModelUser {


    private SharedPreferences preferences ;
    private Context context;
    private final String mypref = "User";


    public ModelUser(Context context)
    {

        this.context = context;


        preferences = context.getSharedPreferences(mypref , Context.MODE_PRIVATE);

    }

    public void savedata_sharedprefrens(String username , String password)
    {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username" , username);
        editor.putString("password" , password);
        editor.apply();

    }

    public boolean checkUser_Signup()
    {


        if(preferences.contains("username") && preferences.contains("password"))
        {

            return true;

        }else
        {
            return  false;
        }


    }



}
