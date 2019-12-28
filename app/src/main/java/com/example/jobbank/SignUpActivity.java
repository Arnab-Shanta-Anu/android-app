package com.example.jobbank;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    EditText mEmailEdt, mPasswordEdt,mUserNameEdt;
    Button mRegisterBtn;
    //progressbar to display while registering user
    ProgressDialog progressDialog;
    RadioGroup radioGroup;
    String gender;

    //Declare an instance of FirebaseAuth
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Actionbar and it's title
        ActionBar actionBar= getSupportActionBar();
        actionBar.setTitle("Create Account");
        //enable back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //init

        radioGroup = findViewById(R.id.genderRadio);
        mUserNameEdt = findViewById(R.id.usernameEdt);
        mEmailEdt = findViewById(R.id.emailEdt);
        mPasswordEdt = findViewById(R.id.passwordEdt);
        mRegisterBtn = findViewById(R.id.registerBtn);
        //in the onCreate() method, initialize the FirebaseAuth instance
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering User...");

        radioGroup.clearCheck();

        //handle register btn click
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                gender = radioButton.getText().toString();
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //input email, password
                String email = mEmailEdt.getText().toString().trim();
                String password = mPasswordEdt.getText().toString().trim();

                //validate email and password
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    //set error and focus on email editText
                    mEmailEdt.setError("Invalid Email Address");
                    mEmailEdt.setFocusable(true);
                }
                else if(password.length()<6)
                {
                    //set error and focus on password editText
                    mPasswordEdt.setError("password length at least 6 character");
                    mPasswordEdt.setFocusable(true);
                }
                else
                {
                    registerUser(email,password);   //Register the user
                }


            }
        });

    }

    private void registerUser(final String email, final String password) {
        //email and password pattern is valid
        //show progress dialog and start user registration

        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, dismiss dialog and start register activity
                            progressDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();

                            String email = user.getEmail();
                            String uid = user.getUid();
                            String username = mUserNameEdt.getText().toString().trim();
                            int selectedId = radioGroup.getCheckedRadioButtonId();
                            RadioButton radioSexButton = findViewById(selectedId);
                            String gender = radioSexButton.getText().toString();

                            //store the registered user info into firebase using Hashmap
                            HashMap<Object, String> hashMap = new HashMap<>();

                            hashMap.put("email",email);
                            hashMap.put("uid",uid);
                            hashMap.put("username", username);
                            hashMap.put("gender", gender);

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference reference = database.getReference();

                            reference.child(uid).setValue(hashMap);

                            Toast.makeText(SignUpActivity.this, "Registered...\n"+user.getEmail(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this,UserProfileActivity.class));
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.dismiss();
                            Toast.makeText(SignUpActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //error, dismiss progress error, get and show the error message
                progressDialog.dismiss();
                Toast.makeText(SignUpActivity.this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();  //go previous activity
        return super.onSupportNavigateUp();
    }
}
