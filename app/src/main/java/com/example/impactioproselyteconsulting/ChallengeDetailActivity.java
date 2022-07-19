package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChallengeDetailActivity extends AppCompatActivity {

    private ImageView challengeImageViewDtl;
    private TextView challengeNameTextDtl, challengeBlurbTextDtl, challengeDescTextDtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_challenge);
        setTitle("Challenge Details");

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
    }

    private void loadChallengeData(Challenge challenge) {
        challengeImageViewDtl.setImageResource(challenge.getChallengeImage());
        challengeNameTextDtl.setText(challenge.getChallengeName());
        challengeBlurbTextDtl.setText(challenge.getChallengeBlurb());
        challengeDescTextDtl.setText(challenge.getChallengeDesc());
    }

}
