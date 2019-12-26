package com.example.jobbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //Intent intent;
    //EditText edtEmail,edtPass;
   // private FirebaseAuth mAuth;
    //private String email, password;

    //declare variable
    Button mLoginBtn,mSignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mAuth = FirebaseAuth.getInstance();
        //intent = new Intent(this, UserProfileActivity.class);

       //finding btn
        mLoginBtn = findViewById(R.id.loginBtn);
        mSignUpBtn = findViewById(R.id.signUpBtn);


        //edtEmail = findViewById(R.id.edtEmail);
        //edtPass = findViewById(R.id.edtPass);



        //handle signup btn click
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
    }
/*
    private void checkValid(String email, String password) {
        if(email.isEmpty()){
            edtEmail.setError("Enter an email address");
            edtEmail.requestFocus();
            return ;
        }
        if(password.isEmpty()){
            edtPass.setError("Enter an password address");
            edtPass.requestFocus();
            return ;
        }
        if(password.length()<6){
            edtPass.setError("password needs to be at least 6 characters");
            edtPass.requestFocus();
            return ;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            edtEmail.setError("Enter a valid email address");
            edtEmail.requestFocus();
            return ;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Toast.makeText(getApplicationContext(), "in OnComplete",Toast.LENGTH_SHORT).show();

                        if (task.isSuccessful()) {
                            edtEmail.setText("success");
                            Toast.makeText(getApplicationContext(), "auth success",Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "auth failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


 */
    }

