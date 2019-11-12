package com.enggemy22.matajer2.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.enggemy22.matajer2.Auth.LogIn;
import com.enggemy22.matajer2.R;
import com.enggemy22.matajer2.SharedPreferenceP.shared;

public class Splash extends AppCompatActivity {
    shared  shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        shared=new shared(getApplicationContext());
        startSpalash();
    }

    private void startSpalash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(shared.isLogn()){
                    startActivity(new Intent(Splash.this, HomeActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(Splash.this, LogIn.class));
                    finish();
                }


            }
        },5000);
    }
}
