package com.example.impactioproselyteconsulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DatabaseEditUserGeneratedTags extends AppCompatActivity {

    private EditText tvEditUserGeneratedTags;
    private TextView tvTag;
    private Button btnUserGeneratedTags, btnRemove, btnBackUserGeneratedTags;
    Animation animSlideIn;
    LottieAnimationView loginanimation;


    //FireBase Database
    FirebaseDatabase firebaseDatabaseUserGeneratedTags;

    //Reference for firebase

    DatabaseReference databaseReferenceUserGeneratedTags;
    DatabaseReference referenceGetGeneratedTag;


    //Create variable customerInfo

    CustomerInfo customerInfoUserGeneratedTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_edit_user_generated_tags);


        tvEditUserGeneratedTags = findViewById(R.id.tvEditUserGeneratedTags);
        tvEditUserGeneratedTags.startAnimation(animSlideIn);
        tvTag = findViewById(R.id.tvTag);
        tvTag.startAnimation(animSlideIn);
        btnUserGeneratedTags = findViewById(R.id.btnUserGeneratedTags);
        btnUserGeneratedTags.startAnimation(animSlideIn);
        btnRemove = findViewById(R.id.btnRemove);
        btnRemove.startAnimation(animSlideIn);
        btnBackUserGeneratedTags = findViewById(R.id.btnBackUserTag);
        btnBackUserGeneratedTags.startAnimation(animSlideIn);
        loginanimation = findViewById(R.id.loginanimation);
        loginanimation.startAnimation(animSlideIn);



        firebaseDatabaseUserGeneratedTags = FirebaseDatabase.getInstance();

        // initializing our object class variable.
        customerInfoUserGeneratedTags = new CustomerInfo();

//        //This is for authentication

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //Create button to submit Custom Tag

        btnUserGeneratedTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Create string for tag change
                databaseReferenceUserGeneratedTags = firebaseDatabaseUserGeneratedTags.getReference("CustomerInfo/" + uid + "/cusUserGeneratedTags");
                String UserGeneratedTag = tvEditUserGeneratedTags.getText().toString();
                //Someone please put an if statement here if a user creates an empty tag it does nothing pls
                if(UserGeneratedTag != null && !UserGeneratedTag.trim().isEmpty()){
                    databaseReferenceUserGeneratedTags.setValue(UserGeneratedTag);
                    Toast.makeText(DatabaseEditUserGeneratedTags.this,"Tag Created Successfully",Toast.LENGTH_SHORT).show();

                    // Sean: This is where the custom tag gets saved, so here I will need to update
                    // the combineTag list and string object and database
                    referenceGetGeneratedTag =  firebaseDatabaseUserGeneratedTags.getReference().child("CustomerInfo").child(uid);

                    referenceGetGeneratedTag.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // Make a new array list string

                            String expertiseTemp = snapshot.child("cusExpertise").getValue().toString();
                            String sdgTemp = snapshot.child("cusSDG").getValue().toString();

                            ArrayList<String> tempCombineTag = new ArrayList<>();
                            tempCombineTag.add(expertiseTemp);
                            tempCombineTag.add(sdgTemp);
                            tempCombineTag.add(UserGeneratedTag);

                            // Now use the method to get the string with separated by % from an array list
                            String tempCombineTagString = getCombinedString(tempCombineTag);

                            // Add the string of combined tags to the database
                            referenceGetGeneratedTag.child("cusCombinedTagsString").setValue(tempCombineTagString);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }

                    });



                }

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Remove the child node and custom tag from firebase
                databaseReferenceUserGeneratedTags = firebaseDatabaseUserGeneratedTags.getReference("CustomerInfo/" + uid + "/cusUserGeneratedTags");
                databaseReferenceUserGeneratedTags.setValue("");
                Toast.makeText(DatabaseEditUserGeneratedTags.this,"Tag Removed Successfully",Toast.LENGTH_SHORT).show();


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

        //Create button to go back to Profile page

        btnBackUserGeneratedTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatabaseEditUserGeneratedTags.this,ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public static String getCombinedString(ArrayList<String> inputList) {
        return TextUtils.join("%", inputList);
    }
}