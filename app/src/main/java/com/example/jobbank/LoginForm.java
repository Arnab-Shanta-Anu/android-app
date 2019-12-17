package com.example.jobbank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginForm extends AppCompatActivity {
    Button signIn,signUp,fsignUp;
     protected void onCreate(Bundle savedIntancesState){
         super.onCreate(savedIntancesState);
         setContentView(R.layout.activity_login_form);

         signIn = findViewById(R.id.loginBtn);
         signUp = findViewById(R.id.signUpId);
         fsignUp = findViewById(R.id.fsignupId);
         signIn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 setContentView(R.layout.activity_main);
             }
         });

         signUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 setContentView(R.layout.activity_signup_form);
             }
         });
         fsignUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 setContentView(R.layout.activity_main);
             }
         });
     }

}
