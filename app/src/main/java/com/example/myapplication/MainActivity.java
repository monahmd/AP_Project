package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button register;

    public static void main(String[] args)throws IOException {
        Socket socket = new Socket("localhost" , 4444);
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputStream =new DataInputStream(socket.getInputStream());
        Login_activity.socket = socket;
        Login_activity.dataInputStream = inputStream;
        Login_activity.dataOutputStream = outputStream;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent loginIntent = new Intent(this , Login_activity.class);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(loginIntent);
            }
        });
        Intent registerIntent = new Intent(this,Register.class );
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registerIntent);
            }
        });
    }
}