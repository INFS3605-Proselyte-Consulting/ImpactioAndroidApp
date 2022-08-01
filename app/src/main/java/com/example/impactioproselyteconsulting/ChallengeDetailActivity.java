package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChallengeDetailActivity extends AppCompatActivity {

    private ImageView challengeImageViewDtl;
//    ToggleButton tglBtn;
    private TextView challengeNameTextDtl, challengeBlurbTextDtl, challengeDescTextDtl, descriptionTV;
    ImageView ChallengeImgViewDetail;
    Animation animSlideIn;
    CardView ChallengeCV;
    Button btnChallengeBack, goToSolutionBtn;

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

        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);


        ChallengeCV = findViewById(R.id.SolCV);
        ChallengeCV.startAnimation(animSlideIn);
        descriptionTV = findViewById(R.id.descriptionTV);
        descriptionTV.startAnimation(animSlideIn);
        challengeImageViewDtl = findViewById(R.id.SolutionImgViewDetail);
        challengeImageViewDtl.startAnimation(animSlideIn);
        challengeNameTextDtl = findViewById(R.id.ChallengeNameTxtDetail);
        challengeNameTextDtl.startAnimation(animSlideIn);
        challengeBlurbTextDtl = findViewById(R.id.ChallengeBlurbTxtDetail);
        challengeBlurbTextDtl.startAnimation(animSlideIn);
        challengeDescTextDtl = findViewById(R.id.ChallengeDescTxtDetail);
        challengeDescTextDtl.startAnimation(animSlideIn);
//        tglBtn = findViewById(R.id.tglBtn);
//        tglBtn.startAnimation(animSlideIn);
        ChallengeImgViewDetail = findViewById(R.id.SolutionImgViewDetail);
        ChallengeImgViewDetail.startAnimation(animSlideIn);
        btnChallengeBack = findViewById(R.id.btnChallengeBack);
        btnChallengeBack.startAnimation(animSlideIn);
        goToSolutionBtn = findViewById(R.id.goToSolutionBtn);
        goToSolutionBtn.startAnimation(animSlideIn);


        Intent intent = getIntent();
        Challenge challenge = Challenge.getChallenge(intent.getStringExtra("Name"));

        loadChallengeData(challenge);


        // Button to go to solutions for this challenge
        Button viewSolutionsBtn = (Button) findViewById(R.id.goToSolutionBtn);
        viewSolutionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Solutions Activity
                Intent intent = new Intent(ChallengeDetailActivity.this, DiscoverSolutionActivity.class);
                // Toast message to test and for info
                Toast.makeText(ChallengeDetailActivity.this, "Loading Solutions For Challenge...", Toast.LENGTH_SHORT).show();
                // Add an extra intent to pass in the Challenge Name to get the correct Solutions to Discover
                intent.putExtra("Name", challenge.getChallengeName());
                startActivity(intent);
                // Delay to fix bug where data wont display unless lock and unlock screen
                // So just restart the activity after the delay
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //startActivity(intent);;
                    }
                }, 3500);

            }
        });

        //Button to go back
        Button btnBack = (Button) findViewById(R.id.btnChallengeBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(ChallengeDetailActivity.this, DiscoverChallengeActivity.class);
                startActivity(backIntent);
                finish();
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
