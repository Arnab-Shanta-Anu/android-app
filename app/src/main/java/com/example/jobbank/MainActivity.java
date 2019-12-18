package com.example.jobbank;

<<<<<<< HEAD
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

    Intent intent;
    Button btnLogin;
    TextView tvSignUp;
    EditText edtEmail,edtPass;
    private FirebaseAuth mAuth;
    private String email, password;
=======
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button homeBtn,catagoryBtn,profileBtn,signInBtn;
>>>>>>> ea335180174ccde307e38e78dfc50885ed418529
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        mAuth = FirebaseAuth.getInstance();
        intent = new Intent(this, HomeActivity.class);

        btnLogin = findViewById(R.id.btnLogIn);
        tvSignUp = findViewById(R.id.tvSignUp);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edtEmail.getText().toString();
                password = edtPass.getText().toString();
                checkValid(email, password);


            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
=======
        homeBtn = findViewById(R.id.HomeId);
        catagoryBtn = findViewById(R.id.CatagoryId);
        profileBtn = findViewById(R.id.ProfileId);
        signInBtn = findViewById(R.id.SignInId);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);

            }
        });
        catagoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_catagory);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_user_profile);
            }
        });
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_login_form);
>>>>>>> ea335180174ccde307e38e78dfc50885ed418529
            }
        });
    }

<<<<<<< HEAD
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
    }
=======

>>>>>>> ea335180174ccde307e38e78dfc50885ed418529
}
