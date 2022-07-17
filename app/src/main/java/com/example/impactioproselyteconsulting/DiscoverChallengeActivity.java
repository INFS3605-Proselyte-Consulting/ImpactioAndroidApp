package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DiscoverChallengeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_challenge);
        setTitle("Discover Challenges");

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.menuNav_Discover);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.menuNav_Dashboard:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuNav_Discover:
                        return true;
                    case R.id.menuNav_Profile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        RecyclerView challengeRecyclerView = findViewById(R.id.ChallengeRV);
        challengeRecyclerView.setHasFixedSize(true);

        challengeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Pass in the challenges list created, into the recycler view
        ChallengeAdapter.RecyclerViewClickListener listener = new ChallengeAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String challengeName) {
                launchDetailActivity(challengeName);
            }
        };

        // Create an adapter instance and supply the challenges data to be displayed
        challengeRecyclerView.setAdapter(new ChallengeAdapter(Challenge.getChallenges(), listener));

        //challengeRecyclerView.setAdapter(new ChallengeAdapter(getApplicationContext(), challenges));
    }

    protected void launchDetailActivity(String challengeName) {
        Intent intent = new Intent(DiscoverChallengeActivity.this, ChallengeDetailActivity.class);
        intent.putExtra(ChallengeDetailActivity.INTENT_MESSAGE, challengeName);
        startActivity(intent);

    }
}