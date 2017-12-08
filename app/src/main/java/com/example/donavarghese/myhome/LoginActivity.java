package com.example.donavarghese.myhome;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private String TAG = "MDC_ANDROID_CLASS";
    CheckBox checkBox;
    String[] info = new String[1000];
    DatabaseHelper mDatabaseHelper;
    EditText userLogin;
    EditText userPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userLogin = (EditText) findViewById(R.id.username);
        userPass = (EditText) findViewById(R.id.password);
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput("myFile")));
            int i = 0;
            while (true) {
                String data = bufferedReader.readLine();
                if (data == null) {
                    break;
                }
                stringBuffer.append(data);
                this.info[i] = data;
                i++;
                stringBuffer.append("\n");
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
            Log.e(this.TAG, "file can not be opened");
        } catch (IOException e) {
            Log.e(this.TAG, "IO EXCEPTION READING FILE");
        }
        this.userLogin.setText(this.info[0]);
        this.userPass.setText(this.info[1]);
        Log.v(this.TAG, "SHOWING THE DATA.");
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
        String loginuser = this.userLogin.getText().toString();
        String password = this.userPass.getText().toString();
        String[] selectionArgs = new String[1];
        selectionArgs[0] = loginuser;
        String pw = null;
        String ip = null;
        String str = RegistrationHelper.UserEntry.TABLE_NAME;
        Cursor cursor = this.mDatabaseHelper.getReadableDatabase().query(str, new String[]{"_id", RegistrationHelper.UserEntry.USER_FULLNAME, RegistrationHelper.UserEntry.USERAGE, RegistrationHelper.UserEntry.USEREMAIL, RegistrationHelper.UserEntry.PASSWORD, RegistrationHelper.UserEntry.PASSWORDHINT, RegistrationHelper.UserEntry.IPADDRESS}, "USERNAME = ?", selectionArgs, null, null, "FULLNAME DESC");
        List<String> getpassword = new ArrayList();
        while (cursor.moveToNext()) {
            pw = cursor.getString(cursor.getColumnIndexOrThrow(RegistrationHelper.UserEntry.PASSWORD));
            ip = cursor.getString(cursor.getColumnIndexOrThrow(RegistrationHelper.UserEntry.IPADDRESS));
        }
        if (password.equals(pw)) {
            Intent intent = new Intent(this, WebPageActivity.class);
            intent.putExtra("ipAddress", ip);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Username and password do not match", Toast.LENGTH_SHORT).show();
        }
        if (this.checkBox.isChecked()) {
            try {
                FileOutputStream fileOutputStream = openFileOutput("myFile", 0);
                fileOutputStream.write(loginuser.getBytes());
                fileOutputStream.write("\n".getBytes());
                fileOutputStream.write(password.getBytes());
                fileOutputStream.close();
                return;
            } catch (FileNotFoundException f) {
                f.printStackTrace();
                return;
            } catch (IOException e) {
                return;
            }
        }
        try {
            FileOutputStream fileOutputStream;
            fileOutputStream = openFileOutput("myFile", 0);
            fileOutputStream.write("".getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write("".getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException f2) {
            f2.printStackTrace();
        } catch (IOException e2) {
        }
        // get info from login screen and check with database

    }


}
