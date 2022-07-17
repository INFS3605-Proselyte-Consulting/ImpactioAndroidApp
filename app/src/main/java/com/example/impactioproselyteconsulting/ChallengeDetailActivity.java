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

        challengeImageViewDtl = findViewById(R.id.ChallengeImgViewDetail);
        challengeNameTextDtl = findViewById(R.id.ChallengeNameTxtDetail);
        challengeBlurbTextDtl = findViewById(R.id.ChallengeBlurbTxtDetail);
        challengeDescTextDtl = findViewById(R.id.ChallengeDescTxtDetail);

        Intent intent = getIntent();
        Challenge challenge = Challenge.getChallenge(intent.getStringExtra("Name"));

        loadChallengeData(challenge);

//        TODO: fix this - gives null object reference
//        String challengeName = intent.getStringExtra(INTENT_MESSAGE);
//        Challenge challenge = Challenge.getChallenge(challengeName);


        // test
        //Challenge challenge = Challenge.getChallenge("The Great Fashion Decarbonisation");
    }

    private void loadChallengeData(Challenge challenge) {
        challengeImageViewDtl.setImageResource(challenge.getChallengeImage());
        challengeNameTextDtl.setText(challenge.getChallengeName());
        challengeBlurbTextDtl.setText(challenge.getChallengeBlurb());
        challengeDescTextDtl.setText(challenge.getChallengeDesc());
    }

}
