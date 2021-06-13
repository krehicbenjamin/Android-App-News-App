package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.reg_username);
        password = findViewById(R.id.reg_password);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(username.getText().toString(), password.getText().toString());

                    GolazoDatabase golazoDatabase = GolazoDatabase.getInstance(getApplicationContext());


                        golazoDatabase.userDao().makeNewUser(user);
                        Toast.makeText(RegisterActivity.this, "Account created succesfully!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                    }


            });

    }

    public Boolean validateInput(User user){
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty())
            return false;
        return true;
    }


}