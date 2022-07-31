package com.example.impactioproselyteconsulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseEditUserGeneratedTags extends AppCompatActivity {

    private EditText tvEditUserGeneratedTags;
 private TextView tvTag;
    private Button btnUserGeneratedTags, btnRemove;

    //FireBase Database
    FirebaseDatabase firebaseDatabaseUserGeneratedTags;

    //Reference for firebase

    DatabaseReference databaseReferenceUserGeneratedTags;
    DatabaseReference referenceGetGeneratedTag;


    //Create variable customerInfo

    CustomerInfo customerInfoUserGeneratedTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_edit_user_generated_tags);


        tvEditUserGeneratedTags = findViewById(R.id.tvEditUserGeneratedTags);
        tvTag = findViewById(R.id.tvTag);
        btnUserGeneratedTags = findViewById(R.id.btnUserGeneratedTags);
        btnRemove = findViewById(R.id.btnRemove);



        firebaseDatabaseUserGeneratedTags = FirebaseDatabase.getInstance();

        // initializing our object class variable.
        customerInfoUserGeneratedTags = new CustomerInfo();

//        //This is for authentication

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //Create button to submit Custom Tag

        btnUserGeneratedTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Create string for bio change
                databaseReferenceUserGeneratedTags = firebaseDatabaseUserGeneratedTags.getReference("CustomerInfo/" + uid + "/cusUserGeneratedTags");
                String UserGeneratedTag = tvEditUserGeneratedTags.getText().toString();;
                databaseReferenceUserGeneratedTags.setValue(UserGeneratedTag);

                //Someone please put an if statement here if a user creates an empty tag it does nothing pls
//                Intent intent = new Intent(DatabaseEditUserGeneratedTags.this,ProfileActivity.class);
//                startActivity(intent);
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Remove the child node and custom tag from firebase
                databaseReferenceUserGeneratedTags = firebaseDatabaseUserGeneratedTags.getReference("CustomerInfo/" + uid + "/cusUserGeneratedTags");
                databaseReferenceUserGeneratedTags.setValue("");


            }
        });


        referenceGetGeneratedTag =  firebaseDatabaseUserGeneratedTags.getReference().child("CustomerInfo").child(uid);
        referenceGetGeneratedTag.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("cusUserGeneratedTags")) {
                    String userTag = dataSnapshot.child("cusUserGeneratedTags").getValue().toString();
                    tvTag.setText(userTag);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}