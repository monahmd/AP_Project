package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button login1 = this.findViewById(R.id.login1);
        EditText newTitleTaskText = this.findViewById(R.id.username);
        EditText newDescriptionTaskText = this.findViewById(R.id.password);
    }
}
