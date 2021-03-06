package com.example.impactioproselyteconsulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dashboard");

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


        Button inProgressBtn = (Button) findViewById(R.id.bView);
        inProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(MainActivity.this, ChallengesInProgressActivity.class);
                startActivity(intent);
            }
        });

        Button toDoBtn = (Button) findViewById(R.id.bView2);
        toDoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(MainActivity.this, ChallengesToDoActivity.class);
                startActivity(intent);
            }
        });

        Button completedBtn = (Button) findViewById(R.id.bView3);
        completedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(MainActivity.this, ChallengesCompletedActivity.class);
                startActivity(intent);
            }
        });

//        Button profileMainBtn = (Button) findViewById(R.id.bProfileMain);
//        profileMainBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //launch profile activity
//                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
//                startActivity(intent);
//            }
//        });


        }
    }