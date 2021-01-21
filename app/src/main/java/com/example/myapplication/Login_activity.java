package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.*;
import java.net.*;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class Login_activity extends AppCompatActivity {
    public static Socket socket;
    public static DataOutputStream dataOutputStream;
    public static DataInputStream dataInputStream;
    public static String command = "";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button loginButton = this.findViewById(R.id.login_login);
        EditText usernameLogin =(EditText) this.findViewById(R.id.username_login);
        EditText passwordLogin = (EditText)this.findViewById(R.id.password_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                    boolean done =false;
                    while (done == false) {
                        dataOutputStream.writeUTF("login");
                        String usernameInput = usernameLogin.getText().toString();
                        dataOutputStream.writeUTF(usernameInput);
                        //intent
                        String passwordInput = passwordLogin.getText().toString();
                        dataOutputStream.writeUTF(passwordInput);
                        //intent
                        //dataOutputStream.flush();
                        command = dataInputStream.readUTF();
                        if(command.equals("not_exist")){
                            Toast.makeText(getApplicationContext(),"Wrong Username or Password ! \n Please try again",Toast.LENGTH_LONG ).show();
                        }else if (command.equals("Done")){
                            Toast.makeText(getApplicationContext(),"Welcome :)",Toast.LENGTH_LONG).show();
                            //intent to next activity
                            done = true;
                        }
                    }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
    }
}
