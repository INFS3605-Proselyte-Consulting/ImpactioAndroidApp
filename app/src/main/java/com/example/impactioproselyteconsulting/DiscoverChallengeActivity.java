package com.example.impactioproselyteconsulting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DiscoverChallengeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_challenge);

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