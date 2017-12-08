package com.example.donavarghese.myhome;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText getAge;
    EditText getCpass;
    EditText getEmail;
    EditText getHint;
    EditText getIp;
    EditText getName;
    EditText getPass;
    EditText getUser;
    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.getName = (EditText) findViewById(R.id.name);
        this.getAge = (EditText) findViewById(R.id.age);
        this.getEmail = (EditText) findViewById(R.id.email);
        this.getUser = (EditText) findViewById(R.id.user);
        this.getPass = (EditText) findViewById(R.id.pass);
        this.getCpass = (EditText) findViewById(R.id.cpass);
        this.getHint = (EditText) findViewById(R.id.hint);
        this.getIp = (EditText) findViewById(R.id.ip);
        this.mDatabaseHelper = new DatabaseHelper(getApplicationContext());
    }

    public void saveToDatabase(View view) {
        String name = this.getName.getText().toString();
        int age = Integer.parseInt(this.getAge.getText().toString());
        String email = this.getEmail.getText().toString();
        String user = this.getUser.getText().toString();
        String pass = this.getPass.getText().toString();
        String cpass = this.getCpass.getText().toString();
        String hint = this.getHint.getText().toString();
        String ip = this.getIp.getText().toString();
        if (name.equals("") || email.equals("") || user.equals("") || pass.equals("") || cpass.equals("") || hint.equals("") || ip.equals("")) {
            Toast.makeText(getApplicationContext(), "All input field must be filled", Toast.LENGTH_SHORT).show();
        } else if (!pass.equals(cpass)) {
            Toast.makeText(getApplicationContext(), "Password do not match enter same password", Toast.LENGTH_SHORT).show();
        } else if (pass.equals(cpass)) {
            SQLiteDatabase db = this.mDatabaseHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(RegistrationHelper.UserEntry.USER_FULLNAME, name);
            values.put(RegistrationHelper.UserEntry.USERAGE, Integer.valueOf(age));
            values.put(RegistrationHelper.UserEntry.USEREMAIL, email);
            values.put(RegistrationHelper.UserEntry.USERNAME, user);
            values.put(RegistrationHelper.UserEntry.PASSWORD, pass);
            values.put(RegistrationHelper.UserEntry.PASSWORDHINT, hint);
            values.put(RegistrationHelper.UserEntry.IPADDRESS, ip);
            long newRowId = db.insert(RegistrationHelper.UserEntry.TABLE_NAME, null, values);
            Toast.makeText(getApplicationContext(), "Data saved to database", Toast.LENGTH_SHORT).show();
            this.getName.setText("");
            this.getAge.setText("");
            this.getEmail.setText("");
            this.getUser.setText("");
            this.getPass.setText("");
            this.getCpass.setText("");
            this.getHint.setText("");
            this.getIp.setText("");
        }
    }
}
