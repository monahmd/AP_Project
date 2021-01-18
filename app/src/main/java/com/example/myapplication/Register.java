package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        Button loginRegister = this.findViewById(R.id.login_register);
        EditText usernameRegister = this.findViewById(R.id.username_register);
        EditText passwordRegister = this.findViewById(R.id.password_register);
        EditText confirmPasswordRegister   = this.findViewById(R.id.confirm_password_register);
    }
}

