package com.enggemy22.matajer2.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.enggemy22.matajer2.R;
import com.enggemy22.matajer2.SharedPreferenceP.shared;
import com.google.android.material.snackbar.Snackbar;

public class forget_password extends AppCompatActivity implements View.OnClickListener {

    com.enggemy22.matajer2.SharedPreferenceP.shared shared;
    EditText meditTextForgetPassword;
    Button mButtonSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        iniateViews();
    }

    private void iniateViews() {
        meditTextForgetPassword=findViewById(R.id.forget_password);
        mButtonSend=findViewById(R.id.send);
        mButtonSend.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send:
                if (ValidateData()) {
                    startActivity(new Intent(getApplicationContext(), LogIn.class));
                    finish();
                }
                break;
        }
    }
    public boolean ValidateData(){
        if (meditTextForgetPassword.getText().toString().isEmpty()){
            Snackbar snackbar=Snackbar.make(findViewById(android.R.id.content),"please Entre Right Email",Snackbar.LENGTH_LONG);
            snackbar.show();
        return false;
        }else{
            return true;
        }


    }
}
