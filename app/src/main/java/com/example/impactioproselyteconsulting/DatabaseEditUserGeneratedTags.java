package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseEditUserGeneratedTags extends AppCompatActivity {

    private EditText tvEditUserGeneratedTags;
    private Button btnUserGeneratedTags;

    //FireBase Database
    FirebaseDatabase firebaseDatabase;

    //Reference for firebase

    DatabaseReference databaseReferenceUserGeneratedTags;


    //Create variable customerInfo

    CustomerInfo customerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_edit_user_generated_tags);


        tvEditUserGeneratedTags = findViewById(R.id.tvEditUserGeneratedTags);;
        btnUserGeneratedTags = findViewById(R.id.btnUserGeneratedTags);



        firebaseDatabase = FirebaseDatabase.getInstance();

        // initializing our object class variable.
        customerInfo = new CustomerInfo();

//        //This is for authentication

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //Create button to submit Custom Tag

        btnUserGeneratedTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Create string for bio change
                databaseReferenceUserGeneratedTags = firebaseDatabase.getReference("CustomerInfo/" + uid + "/cusUserGeneratedTags");
                String UserGeneratedTag = tvEditUserGeneratedTags.getText().toString();;
                databaseReferenceUserGeneratedTags.setValue(UserGeneratedTag);

            }
        });

    }
}