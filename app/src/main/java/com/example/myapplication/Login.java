package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button login1 = this.findViewById(R.id.login_login);
        EditText username = this.findViewById(R.id.username_login);
        EditText password = this.findViewById(R.id.password_login);
    }
}
