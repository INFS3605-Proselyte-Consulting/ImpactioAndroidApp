package com.example.impactioproselyteconsulting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.impactioproselyteconsulting.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ProfileActivity";
    public static final String INTENT_MESSAGE = "intent_message";
    private TextView tvName, tvBiography, tvBio, tvAOE, tvSDGDisplay, tvUserTag;
    private ImageView ivProfilePic;
    private Button btnEdit, btnLogOut;
    private CardView cardBiography, cardAreaOfExpertise, cardSustainable, cardPreferredTags;

    //FireBase Database
    FirebaseDatabase firebaseDatabase;

    //CustomerInfo Instance

    CustomerInfo customerInfo;

    //DataBase Reference

    DatabaseReference referenceGetName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Your Profile");

        //Recognise the firebase database user
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // initializing our object class variable.
        customerInfo = new CustomerInfo();


        //Reference Database
        firebaseDatabase = FirebaseDatabase.getInstance();
        referenceGetName =  firebaseDatabase.getReference().child("CustomerInfo").child(uid);


        //Reference Name and Profile Details
        referenceGetName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("cusName").getValue().toString();
                tvName.setText(name);
                String bio = dataSnapshot.child("cusBio").getValue().toString();
                tvBio.setText(bio);
                String aoe = dataSnapshot.child("cusExpertise").getValue().toString();
                tvAOE.setText(aoe);
                String sdg = dataSnapshot.child("cusSDG").getValue().toString();
                tvSDGDisplay.setText(sdg);
                if (dataSnapshot.hasChild("cusUserGeneratedTags")) {
                    String userTag = dataSnapshot.child("cusUserGeneratedTags").getValue().toString();
                    tvUserTag.setText(userTag);
                }else{
                    tvUserTag.setText("");
                }

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







        // Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Profile selected
        bottomNavigationView.setSelectedItemId(R.id.menuNav_Profile);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menuNav_Dashboard:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.menuNav_Discover:
                        startActivity(new Intent(getApplicationContext(), DiscoverChallengeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.menuNav_Profile:
                        return true;
                }
                return false;
            }
        });

        // Get handle for view elements
        ivProfilePic = findViewById(R.id.ivProfilePic);
        tvName = findViewById(R.id.tvName);
        tvBiography = findViewById(R.id.tvBiography);
        tvBio = findViewById(R.id.tvBio);
        tvAOE = findViewById(R.id.tvAOE);
        tvSDGDisplay = findViewById(R.id.tvSDGDisplay);
        tvUserTag = findViewById(R.id.tvUserTag);
        btnLogOut = findViewById(R.id.btnLogOut);
        cardBiography = (CardView) findViewById(R.id.cardBiography);
        cardAreaOfExpertise = (CardView) findViewById(R.id.cardAreaOfExpertise);
        cardSustainable = (CardView) findViewById(R.id.cardSustainable);
        cardPreferredTags = (CardView) findViewById(R.id.cardPreferredTags);

        cardBiography.setOnClickListener(this);
        cardAreaOfExpertise.setOnClickListener(this);
        cardSustainable.setOnClickListener(this);
        cardPreferredTags.setOnClickListener(this);

        btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

//        btnEdit = findViewById(R.id.btnEdit);
//        btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Launch the Discover Challenges Activity
//                Intent intent = new Intent(ProfileActivity.this, ProfileEditActivity.class);
//                startActivityForResult(intent, 101);
//            }
//        });
    }

    //Switch to desired profile activity when cardView is clicked

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.cardBiography:
                i = new Intent(this,DatabaseEditProfile.class);
                startActivity(i);
                break;

            case R.id.cardAreaOfExpertise:
                i = new Intent(this, DatabaseEditExpertise.class);
                startActivity(i);
                break;

            case R.id.cardSustainable:
                i = new Intent(this, DatabaseEditSDG.class);
                startActivity(i);
                break;

            case R.id.cardPreferredTags:
                i = new Intent(this, DatabaseEditUserGeneratedTags.class);
                startActivity(i);
                break;

        }

    }

    //        Filter and Produce selected SDGs
 //       @Override
 //       protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
 //           super.onActivityResult(requestCode, resultCode, data);
//
  //          if (requestCode == 101) {
 //               TextView textView = findViewById(R.id.tvResult);
  //              textView.setText(data.getStringExtra("data"));
//
  //          }
   //     }
}