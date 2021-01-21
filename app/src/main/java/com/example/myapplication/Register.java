package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        EditText usernameRegister = (EditText)this.findViewById(R.id.username_register);
        EditText passwordRegister = (EditText) this.findViewById(R.id.password_register);
        EditText confirmPasswordRegister   = (EditText)this.findViewById(R.id.confirm_password_register);
        Intent intentToHome = new Intent(this,HomePageActivity.class);
        Intent backToMain =new Intent(this , MainActivity.class);

        final boolean[] user = {false};
        final boolean[] pass = {false};
        boolean cPass = false;

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentToHome);
            }
        });


        //in code baray register na check kardan har field bood , ama bekhater ye moshkel jozee toy ertebat socket va dorost kardan toast dashtim
        //be khater hamin , baraye inke activity badi namayesh dade beshe in ghesmat az code comment shode va ta darsad khubi kar ro angam midade

//        Thread thread = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        dataOutputStream.writeUTF("register");
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//
//                                usernameRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                                    @Override
//                                    public void onFocusChange(View v, boolean hasFocus) {
//                                        if (!hasFocus){
//
//                                        Thread thread1 = new Thread(new Runnable() {
//                                             @Override
//                                             public void run() {
//                                                 String usernameInput = usernameRegister.getText().toString();
//                                                 System.out.println(usernameInput);
//                                                 try {
//                                                     dataOutputStream.writeUTF(usernameInput);
//                                                     command = dataInputStream.readUTF();
//                                                     if (command.equals("exist")) {
//                                                         Toast.makeText(getApplicationContext(), "This Username already exist ! \n Please try again", Toast.LENGTH_LONG).show();
//                                                         startActivity(backToMain);
//                                                     }
//                                                 } catch (IOException e) {
//                                                     e.printStackTrace();
//                                                 }
//                                             }
//                                        });
//                                            thread1.start();
//                                        }
//                                    }
//                                });
//
//
//                                passwordRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                                    @Override
//                                    public void onFocusChange(View v, boolean hasFocus) {
//                                        if (!hasFocus){
//                                            System.out.println("not focus!!!!!!");
//
//                                            Thread thread1 = new Thread(new Runnable() {
//
//                                                @Override
//                                                public void run() {
//                                                System.out.println("runnnnn!!!!!!");
//                                                    String passwordInput = passwordRegister.getText().toString();
//                                                    System.out.println(passwordInput);
//                                                    try {
//                                                        dataOutputStream.writeUTF(passwordInput);
//                                                        command = dataInputStream.readUTF();
//                                                        if (command.equals("less_than_five_letters")) {
//                                                            Toast.makeText(getApplicationContext(), "Password should not be less than five letters", Toast.LENGTH_LONG).show();
//                                                            startActivity(backToMain);
//                                                        }
//                                                    } catch (IOException e) {
//                                                        e.printStackTrace();
//                                                    }
//                                                }
//                                            });
//                                            thread1.start();
//                                        }
//                                    }
//                                });
//
//                                confirmPasswordRegister.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                                    @Override
//                                    public void onFocusChange(View v, boolean hasFocus) {
//                                        System.out.println("focus!!!!!!");
//                                        if (!hasFocus){
//                                            Thread thread1 = new Thread(new Runnable() {
//                                                @Override
//                                                public void run() {
//                                                    String confirmPasswordInput = confirmPasswordRegister.getText().toString();
//                                                    System.out.println(confirmPasswordInput);
//                                                    try {
//                                                        dataOutputStream.writeUTF(confirmPasswordInput);
//                                                        command = dataInputStream.readUTF();
//                                                        dataOutputStream.writeUTF(confirmPasswordInput);
//                                                        if (command.equals("not_match")) {
//                                                            Toast.makeText(getApplicationContext(), "Password and Confirm Password do not match", Toast.LENGTH_LONG).show();
//                                                            startActivity(backToMain);
//                                                        }
//                                                    } catch (IOException e) {
//                                                        e.printStackTrace();
//                                                    }
//                                                }
//                                            });
//                                            thread1.start();
//                                        }
//                                    }
//                                });
//
//                        registerButton.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                System.out.println("click!!!!!");
//
//                                Thread thread1 = new Thread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                try {
//                                    dataInputStream = new DataInputStream(socket.getInputStream());
//                                    command = dataInputStream.readUTF();
//                                    if (command.equals("Done")) {
//                                     Toast.makeText(getApplicationContext(), "Welcome :)", Toast.LENGTH_LONG).show();
//                                     startActivity(intentToHome);
//                                    }
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//
//                                    }
//                                });
//
//                            }
//                        });
//
//                            }
//                        });
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//            thread.start();
    }
}

