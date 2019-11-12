package com.enggemy22.matajer2.SharedPreferenceP;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class shared {
SharedPreferences preferences;
SharedPreferences.Editor editor;
Context mContext;

    private static final String FILE_NAME = "MaTaJer";
    private static final String KEY_NAME = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_STATUS = "Status";

    public shared(Context mContext) {
        this.mContext = mContext;
        preferences=mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        editor=preferences.edit();
    }

    public void savedata(String email,String Password,boolean status){
        editor.putString(KEY_NAME,email);
        editor.putString(KEY_PASSWORD,Password);
        editor.putBoolean(KEY_STATUS,status);
        editor.apply();
    }


    public HashMap<String,String> getUser(){
        HashMap map =new HashMap();
        map.put(KEY_NAME,preferences.getString(KEY_NAME,null));
        map.put(KEY_PASSWORD,preferences.getString(KEY_PASSWORD,null));
        return map;
    }

    public  boolean isLogn()
    {
        return preferences.getBoolean(KEY_STATUS,false);
    }

}
