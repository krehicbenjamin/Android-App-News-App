package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;

    String correct_username = "admin";
    String correct_password = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.reg_username);
        password = findViewById(R.id.reg_password);
        btnLogin = findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count;

                // provjera unosa
                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Invalid input",Toast.LENGTH_LONG).show();
                } else {
                    GolazoDatabase golazoDatabase = GolazoDatabase.getInstance(getApplicationContext());
                    count = golazoDatabase.userDao().checkCredentials(username.getText().toString(), password.getText().toString());
                    // provjera passworda
                    if(count == 1) {
                        Toast.makeText(MainActivity.this, "Logged in successfully",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, MainPageActivity.class);
                        MainActivity.this.startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Username or Password",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }

    public void  onRegisterClick (View view) {

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

    }
}