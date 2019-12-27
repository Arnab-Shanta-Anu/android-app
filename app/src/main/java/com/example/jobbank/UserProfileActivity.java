package com.example.jobbank;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserProfileActivity extends AppCompatActivity {

    Button homeBtn,categoryBtn,profileBtn,signInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        //Actionbar and it's title
        ActionBar actionBar= getSupportActionBar();
        actionBar.setTitle("My Profile");
        homeBtn = findViewById(R.id.homeId);
        categoryBtn = findViewById(R.id.catagoryId);
        profileBtn = findViewById(R.id.profileId);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
