package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.*;
import java.net.*;
import java.lang.ref.WeakReference;


public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button register;
    public static Socket socket;
    public static final int serverPort = 4444;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioPlay.soundPlayer(this, R.raw.music);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    socket = new Socket("192.168.100.7",serverPort );
                    DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                    DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                    Login_activity.socket = socket;
                    Login_activity.dataInputStream = inputStream;
                    Login_activity.dataOutputStream = outputStream;
                    Register.socket = socket;
                    Register.dataInputStream = inputStream;
                    Register.dataOutputStream = outputStream;

                    String check = inputStream.readUTF();
                    System.out.println(check);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
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