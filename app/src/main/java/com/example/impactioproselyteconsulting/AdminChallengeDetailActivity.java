package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminChallengeDetailActivity extends AppCompatActivity {
    private ImageView challengeImageViewDtl;
    private TextView challengeNameTextDtl, challengeBlurbTextDtl, challengeDescTextDtl;

    Animation animSlideIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_challenge);
        setTitle("Challenge Details");

        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Dashboard selected
        bottomNavigationView.setSelectedItemId(R.id.menuNav_Dashboard);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.menuNav_Dashboard:
                        return true;
                    case R.id.menuNav_Discover:
                        startActivity(new Intent(getApplicationContext(),DiscoverChallengeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuNav_Profile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        challengeImageViewDtl = findViewById(R.id.ChallengeImgViewDetail);
        challengeNameTextDtl = findViewById(R.id.ChallengeNameTxtDetail);
        challengeBlurbTextDtl = findViewById(R.id.ChallengeBlurbTxtDetail);
        challengeDescTextDtl = findViewById(R.id.ChallengeDescTxtDetail);

        Intent intent = getIntent();
        Challenge challenge = Challenge.getChallenge(intent.getStringExtra("Name"));

        loadChallengeData(challenge);


        // Button to go to solutions for this challenge
        Button viewSolutionsBtn = (Button) findViewById(R.id.goToSolutionBtn);
        viewSolutionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Solutions Activity
                Intent intent = new Intent(AdminChallengeDetailActivity.this, DiscoverSolutionActivity.class);
                // Toast message to test and for info
                Toast.makeText(AdminChallengeDetailActivity.this, "Loading Solutions for this Challenge", Toast.LENGTH_LONG).show();
                // Add an extra intent to pass in the Challenge Name to get the correct Solutions to Discover
                intent.putExtra("Name", challenge.getChallengeName());
                startActivity(intent);
            }
        });






    }

    private void loadChallengeData(Challenge challenge) {
        challengeImageViewDtl.setImageResource(challenge.getChallengeImage());
        challengeNameTextDtl.setText(challenge.getChallengeName());
        challengeBlurbTextDtl.setText(challenge.getChallengeBlurb());
        challengeDescTextDtl.setText(challenge.getChallengeDesc());
    }
}
