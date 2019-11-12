package com.enggemy22.matajer2.SharedPreferenceP;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SharedImages {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;
    public static final String FILE_NAME = "MaTaJer";
    public static final String FILE_Image = "Image";
    public static final String FILE_Status = "Image";

    public SharedImages(Context context) {
        this.context = context;
        preferences =context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        editor=preferences.edit();
    }
    public void SaveImage(int image,boolean status){
        editor.putInt(FILE_Image,image);
        editor.apply();
    }
    public HashMap<Integer ,Integer> getImage(){
        HashMap hashMap=new HashMap();
        hashMap.put(FILE_Image,preferences.getInt(FILE_Image,0));
        return hashMap;
    }
    public boolean is_saved(){
        return preferences.getBoolean(FILE_Status,false);
    }

}
