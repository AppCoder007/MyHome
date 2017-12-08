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
       // EditText editText = (EditText) findViewById(R.id.editText);
      //  String message = editText.getText().toString();
     //   intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void getPassword(View view){
        Intent intent = new Intent(this, GetPasswordActivity.class);
       // EditText editText = (EditText) findViewById(R.id.editText);
       // String message = editText.getText().toString();
       // intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }

}
