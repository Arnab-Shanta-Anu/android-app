package com.example.jobbank;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfileActivity extends AppCompatActivity {

    DatabaseHandler databaseHandler;

    DatabaseReference myRef; //myRef variable globally declared
    Button homeBtn,categoryBtn,profileBtn,signInBtn;
    EditText postText;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        databaseHandler = new DatabaseHandler(this);

        //firebase Initialization
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("adittya");

        //Actionbar and it's title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My Profile");
        homeBtn = findViewById(R.id.homeId);
        categoryBtn = findViewById(R.id.catagoryId);
        profileBtn = findViewById(R.id.profileId);
        postText = findViewById(R.id.postId);
        tv = findViewById(R.id.textPostId);

    }
    //Insert Data to Firebase
    public void methodInsert(View view) {
        String data = postText.getText().toString();
        myRef.setValue(data);
        tv.setText(data);

        //to insert data into database
        databaseHandler.insertData(postText.getText().toString());
      /*  if(isInserted==true)
            Toast.makeText(UserProfileActivity.this,"posted successfully..",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(UserProfileActivity.this,"posting failed..",Toast.LENGTH_LONG).show();
            */


    }

    //Retrive date from Firebase
    public void methodDisplay(View view) {

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(UserProfileActivity.this,value,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(UserProfileActivity.this,"Failed!!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
