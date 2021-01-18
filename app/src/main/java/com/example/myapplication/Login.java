package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button loginLogin = this.findViewById(R.id.login_login);
        EditText usernameLogin = this.findViewById(R.id.username_login);
        EditText passwordLogin = this.findViewById(R.id.password_login);

    }
}
