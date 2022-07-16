package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

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

        // Create a list of challenges here
        List<Challenge> challenges = new ArrayList<Challenge>();
        challenges.add(new Challenge("The Great Fashion Decarbonisation",
                "Do you have expertise, networks or ideas that could transform fashion to a sustainable industry?",
                R.drawable.fashion));
        challenges.add(new Challenge("Innovate to Regenerate",
                "Innovate to Regenerate seeks to support and amplify community-led regeneration. We’re working together to make sure communities are supported and have the capability and agency to lead their own local regeneration",
                R.drawable.regenerate));
        challenges.add(new Challenge("Cities of Tomorrow",
                "How can we decarbonise materials used in building, construction and infrastructure?",
                R.drawable.cities));
        challenges.add(new Challenge("Bushfire Regeneration Challenge",
                "Delivering innovative solutions for bushfire recovery and resilience.",
                R.drawable.bushfire));
        challenges.add(new Challenge("Sustainability Advantage Impact Challenge",
                "We are seeking projects that offer smarter, faster ways to make real progress on the United Nations Sustainable Development Goals and transform the way we do business in NSW.",
                R.drawable.sustainability));
        challenges.add(new Challenge("Innovate for Wildlife & People Challenge",
                "The ‘Innovate for Wildlife and People: Incentivising and rewarding community-based wildlife conservation’ Challenge focuses on one of the most pressing topics in conservation today.",
                R.drawable.wildlife));


        challengeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Pass in the challenges list created, into the recycler view
        challengeRecyclerView.setAdapter(new ChallengeAdapter(getApplicationContext(), challenges));
    }
}