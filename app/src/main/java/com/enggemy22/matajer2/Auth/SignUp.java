package com.enggemy22.matajer2.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.enggemy22.matajer2.Main.HomeActivity;
import com.enggemy22.matajer2.R;
import com.enggemy22.matajer2.SharedPreferenceP.SharedSignUp;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText email;
    private EditText password;
    private EditText firstName;
    private EditText lastName;
    private EditText phone;
    private Button log;
    private Button sign;
    private SharedSignUp up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initateViews();

    }

    private void initateViews() {
    email=findViewById(R.id.emailSign);
    password=findViewById(R.id.PasswordSign);
    firstName=findViewById(R.id.FirstName);
    lastName=findViewById(R.id.lastName);
    phone=findViewById(R.id.phone);
    log=findViewById(R.id.loginSign);
    sign=findViewById(R.id.signupSign);
    up=new SharedSignUp(getApplicationContext());
    log.setOnClickListener(this);
    sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginSign:
                startActivity(new Intent(getApplicationContext(),LogIn.class));
                break;
            case R.id.signupSign:
                if (validateData()) {
                    up.saveData(firstName.getText().toString(),lastName.getText().toString(),email.getText().toString(),password.getText().toString(),true);
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));

                }
                break;
        }
    }

    public boolean validateData(){
        if (email.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please entre your email",Toast.LENGTH_LONG).show();
            return false;
        }else if(password.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please entre your password",Toast.LENGTH_LONG).show();
            return false;
        }else if(firstName.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please entre your first Name",Toast.LENGTH_LONG).show();
            return false;
        }else if(lastName.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"please entre your Last Name",Toast.LENGTH_LONG).show();
            return false;
        }else if(phone.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "please entre your Phone number", Toast.LENGTH_LONG).show();
            return false;
        } else{
            return true;
        }
    }

}
