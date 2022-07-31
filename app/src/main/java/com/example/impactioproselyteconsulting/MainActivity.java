package com.example.impactioproselyteconsulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Animation animSlideIn;

    Button bViewInProgress, bViewToDo, bViewCompleted,bGoToRating;
    CardView SolutionsInProgressCardView, SolutionsToDoCardView, CompletedCardView;
    TextView ToDoTV, InProgressTV, CompletedTV, solutionstv1, solutionstv2, solutionstv3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dashboard");

        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);



        bViewInProgress = findViewById(R.id.bViewInProgress);
        bViewInProgress.startAnimation(animSlideIn);
        bViewToDo = findViewById(R.id.bViewToDo);
        bViewToDo.startAnimation(animSlideIn);
        bViewCompleted = findViewById(R.id.bViewCompleted);
        bViewCompleted.startAnimation(animSlideIn);
        bGoToRating = findViewById(R.id.bGoToRating);
        bGoToRating.startAnimation(animSlideIn);
        SolutionsInProgressCardView = findViewById(R.id.SolutionsInProgressCardView);
        SolutionsInProgressCardView.startAnimation(animSlideIn);
        SolutionsToDoCardView = findViewById(R.id.SolutionsToDoCardView);
        SolutionsToDoCardView.startAnimation(animSlideIn);
        CompletedCardView = findViewById(R.id.CompletedCardView);
        CompletedCardView.startAnimation(animSlideIn);
        ToDoTV = findViewById(R.id.ToDoTV);
        ToDoTV.startAnimation(animSlideIn);
        InProgressTV = findViewById(R.id.InProgressTV);
        InProgressTV.startAnimation(animSlideIn);
        CompletedTV = findViewById(R.id.CompletedTV);
        CompletedTV.startAnimation(animSlideIn);
        solutionstv1 = findViewById(R.id.solutionstv1);
        solutionstv1.startAnimation(animSlideIn);
        solutionstv2 = findViewById(R.id.solutionstv2);
        solutionstv2.startAnimation(animSlideIn);
        solutionstv3 = findViewById(R.id.solutionstv3);
        solutionstv3.startAnimation(animSlideIn);




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


        Button inProgressBtn = (Button) findViewById(R.id.bViewInProgress);
        inProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(MainActivity.this, SolutionsInProgressActivity.class);
                startActivity(intent);
            }
        });


        Button toDoBtn = (Button) findViewById(R.id.bViewToDo);
        toDoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(MainActivity.this, SolutionsToDoActivity.class);
                startActivity(intent);
            }
        });

        Button completedBtn = (Button) findViewById(R.id.bViewCompleted);
        completedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(MainActivity.this, SolutionsCompletedActivity.class);
                startActivity(intent);
            }
        });

        Button goRating = (Button) findViewById(R.id.bGoToRating);
        goRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RatingActivity.class);
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