package com.example.donavarghese.myhome;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class GetPasswordActivity extends AppCompatActivity {
    EditText email;
    DatabaseHelper mDatabaseHelper;
    EditText pass;
    EditText passHint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_password);
        this.email = (EditText) findViewById(R.id.userName);
        this.passHint = (EditText) findViewById(R.id.passHint);
        this.pass = (EditText) findViewById(R.id.pass);
        this.mDatabaseHelper = new DatabaseHelper(getApplicationContext());
    }


    public void getPassword1(View view) {
        String userEmail = this.email.getText().toString();
        String passH = this.passHint.getText().toString();
        String password = this.pass.getText().toString();
        String[] selectionArgs = new String[1];
        selectionArgs[0] = userEmail;
        String pw = null;
        String str = RegistrationHelper.UserEntry.TABLE_NAME;
        Cursor cursor = this.mDatabaseHelper.getReadableDatabase().query(str, new String[]{"_id", RegistrationHelper.UserEntry.USER_FULLNAME, RegistrationHelper.UserEntry.USERAGE, RegistrationHelper.UserEntry.USEREMAIL, RegistrationHelper.UserEntry.PASSWORD, RegistrationHelper.UserEntry.PASSWORDHINT, RegistrationHelper.UserEntry.IPADDRESS}, "EMAIL = ?", selectionArgs, null, null, "FULLNAME DESC");
        List<String> getpassword = new ArrayList();
        while (cursor.moveToNext()) {
            pw = cursor.getString(cursor.getColumnIndexOrThrow(RegistrationHelper.UserEntry.PASSWORD));
        }
        this.pass.setText(pw);
    }

}
