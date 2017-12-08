package com.example.donavarghese.myhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void createAccount(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);

        startActivity(intent);

    }

    public void getPassword(View view){
        Intent intent = new Intent(this, GetPasswordActivity.class);

        startActivity(intent);


    }

    public void login(View view){
        // get info from login screen and check with database
        Intent intent = new Intent(this, WebPageActivity.class);

        startActivity(intent);
    }


}
