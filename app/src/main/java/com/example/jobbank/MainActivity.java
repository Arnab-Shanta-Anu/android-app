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

    Intent intent;
    Button btnLogin;
    TextView tvSignUp;
    EditText edtEmail,edtPass;
    private FirebaseAuth mAuth;
    private String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                if(checkValid(email, password)){
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "auth failed",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
            }
        });
    }

    private boolean checkValid(String email, String password) {
        if(email.isEmpty()){
            edtEmail.setError("Enter an email address");
            edtEmail.requestFocus();
            return false;
        }
        if(password.isEmpty()){
            edtPass.setError("Enter an password address");
            edtPass.requestFocus();
            return false;
        }
        if(password.length()<6){
            edtPass.setError("password needs to be at least 6 characters");
            edtPass.requestFocus();
            return false;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            edtEmail.setError("Enter a valid email address");
            edtEmail.requestFocus();
            return false;
        }

        return true;
    }
}
