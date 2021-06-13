package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void  onRegister(View view) {
        User user = new User(username.getText().toString(), password.getText().toString());

        if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
            Toast.makeText(RegisterActivity.this, "Invalid input", Toast.LENGTH_LONG).show();
        } else {
            GolazoDatabase golazoDatabase = GolazoDatabase.getInstance(getApplicationContext());
            List<User> userList = golazoDatabase.userDao().checkUsernameUnique(username.getText().toString());
            if (userList.get(0) == null) {
                golazoDatabase.userDao().makeNewUser(user);
                Toast.makeText(RegisterActivity.this, "Account created succesfully!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(RegisterActivity.this, "Username not unique", Toast.LENGTH_LONG).show();
            }
        }
    }

}