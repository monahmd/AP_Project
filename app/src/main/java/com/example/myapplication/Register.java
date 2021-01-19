package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Register extends AppCompatActivity {
    public static Socket socket;
    public static DataOutputStream dataOutputStream;
    public static DataInputStream dataInputStream;
    public static String command = "";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        Button registerButton = this.findViewById(R.id.register_button);
        EditText usernameRegister = this.findViewById(R.id.username_register);
        EditText passwordRegister = this.findViewById(R.id.password_register);
        EditText confirmPasswordRegister   = this.findViewById(R.id.confirm_password_register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    boolean done =false;
                    while (done == false){
                        dataOutputStream.writeUTF("register");
                        String usernameInput = usernameRegister.getText().toString();
                        dataOutputStream.writeUTF(usernameInput);
                        //intent
                        String passwordInput = passwordRegister.getText().toString();
                        dataOutputStream.writeUTF(passwordInput);
                        //intent
                        String confirmPasswordInput = confirmPasswordRegister.getText().toString();
                        dataOutputStream.writeUTF(confirmPasswordInput);
                        //intent
                        dataOutputStream.flush();
                        command = dataInputStream.readUTF();
                        if(command.equals("exist")){
                            Toast.makeText(getApplicationContext(),"This Username already exist ! \n Please try again",Toast.LENGTH_LONG ).show();
                        }else if(command.equals("less_than_five_letters")) {
                            Toast.makeText(getApplicationContext(),"Password should not be less than five letters",Toast.LENGTH_LONG ).show();
                        }else if(command.equals("not_match")) {
                            Toast.makeText(getApplicationContext(),"Password and Confirm Password do not match",Toast.LENGTH_LONG ).show();
                        }else if (command.equals("Done")){
                            Toast.makeText(getApplicationContext(),"Welcome :)",Toast.LENGTH_LONG).show();
                            //intent to next activity
                            done = true;
                        }
                    }


                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}

