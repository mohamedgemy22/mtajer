package com.enggemy22.matajer2.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.enggemy22.matajer2.Main.HomeActivity;
import com.enggemy22.matajer2.R;
import com.enggemy22.matajer2.SharedPreferenceP.shared;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditMail;
    private EditText mEditPassword;
    private Button mbtnLogIn;
    private Button mBtnSignUp;
    private TextView textforgetPassword;
    shared  shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        intiateViews();
    }

    private void intiateViews() {
        mEditMail=findViewById(R.id.Emaillog);
        mEditPassword=findViewById(R.id.passwordlog);
        mbtnLogIn=findViewById(R.id.loginlog);
        mbtnLogIn.setOnClickListener(this);
        mBtnSignUp=findViewById(R.id.SignUPlog);
        textforgetPassword=findViewById(R.id.forget_password);
        textforgetPassword.setOnClickListener(this);
        mBtnSignUp.setOnClickListener(this);
        shared=new shared(getApplicationContext());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginlog:
                if(validateData()) {
                    shared.savedata(mEditMail.getText().toString(), mEditPassword.getText().toString(), true);
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
                    break;
            case R.id.SignUPlog:
                startActivity(new Intent(getApplicationContext(), SignUp.class));
                finish();
                break;
            case R.id.forget_password:
                startActivity(new Intent(getApplicationContext(), forget_password.class));
                finish();
                break;
        }

    }
    public boolean validateData(){
        if (mEditMail.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please entre your email",Toast.LENGTH_LONG).show();
            return false;
        }else if(mEditPassword.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please entre your password",Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }
}
