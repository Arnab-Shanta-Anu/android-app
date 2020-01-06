package com.example.jobbank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler myDB;
    EditText edtEmail,edtPass;
    private FirebaseAuth mAuth;
    private String email, password;
    ProgressDialog progressDialog;
    private DatabaseReference mDatabase;

    DatabaseHandler databaseHandler;
    //declare variable
    Button mLoginBtn,mSignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHandler(this);
       // databaseHandler = new DatabaseHandler(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging In.....");

       //finding btn
        mLoginBtn = findViewById(R.id.loginBtn);
        mSignUpBtn = findViewById(R.id.signUpBtn);
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);

        //handle login btn click
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edtEmail.getText().toString().trim();
                password = edtPass.getText().toString().trim();

                checkValid(email,password);
            }
        });

        //handle signup btn click
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
    }

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
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Toast.makeText(getApplicationContext(), "in OnComplete",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "authentication success",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, UserProfileActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "authentication failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

