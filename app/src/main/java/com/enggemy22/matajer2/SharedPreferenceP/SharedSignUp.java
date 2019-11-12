package com.enggemy22.matajer2.SharedPreferenceP;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;

import java.util.HashMap;

public class SharedSignUp {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    public static final String FILE_NAME = "MaTaJer";
    public static final String KEY_NAME = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_STATUS = "Status";
    public static final String KEY_FNAME="firstname";
    public static final String KEY_LNAME="lastname";

    public SharedSignUp(Context context) {
        this.context = context;
        preferences=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        editor=preferences.edit();
    }

    public void saveData(String Fname,String Lname,String Email,String Password,boolean status){
        editor.putString(KEY_FNAME,Fname);
        editor.putString(KEY_LNAME, Lname);
        editor.putString(KEY_NAME,Email);
        editor.putString(KEY_PASSWORD,Password);
        editor.apply();
    }
    public HashMap<String ,String>getUser(){
        HashMap hashMap =new HashMap();

        hashMap.put(KEY_FNAME,preferences.getString(KEY_FNAME,null));
        hashMap.put(KEY_LNAME,preferences.getString(KEY_LNAME,null));
        hashMap.put(KEY_NAME,preferences.getString(KEY_NAME,null));
        hashMap.put(KEY_PASSWORD,preferences.getString(KEY_PASSWORD,null));
        return hashMap;
    }

    public boolean isLogin(){
        return preferences.getBoolean(KEY_STATUS,false);
    }


}
