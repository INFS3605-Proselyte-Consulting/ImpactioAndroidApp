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

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ProfileActivity";
    public static final String INTENT_MESSAGE = "intent_message";
    private TextView tvName, tvBiography;
    private ImageView ivProfilePic;
    private Button btnEdit, btnLogOut;
    private CardView cardBiography, cardAreaOfExpertise, cardSustainable, cardPreferredTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Your Profile");
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
                i = new Intent(this,ProfileBiographyActivity.class);
                startActivity(i);
                break;

            case R.id.cardAreaOfExpertise:
                i = new Intent(this, ProfileAreaOfExpertiseActivity.class);
                startActivity(i);
                break;

            case R.id.cardSustainable:
                i = new Intent(this, ProfileEditActivity.class);
                startActivity(i);
                break;

            case R.id.cardPreferredTags:
                i = new Intent(this, ProfilePreferredTagsActivity.class);
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