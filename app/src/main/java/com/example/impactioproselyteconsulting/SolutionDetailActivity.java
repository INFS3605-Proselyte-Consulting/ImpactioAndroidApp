package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SolutionDetailActivity extends AppCompatActivity {

    private ImageView solutionImageViewDtl;
    private TextView solutionNameTextDtl, solutionBlurbTextDtl, solutionDescTextDtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_solution);
        setTitle("Solution Details");

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

        solutionImageViewDtl = findViewById(R.id.SolutionImgViewDetail);
        solutionNameTextDtl = findViewById(R.id.SolutionNameTxtDetail);
        solutionBlurbTextDtl = findViewById(R.id.SolutionBlurbTxtDetail);
        solutionDescTextDtl = findViewById(R.id.SolutionDescTxtDetail);

        Intent intent = getIntent();
        Solution solution = Solution.getSolution(intent.getStringExtra("Name"));

        loadSolutionData(solution);


        // Button to apply for this solution
        //TODO
        // Implement apply functionality
//        Button viewSolutionsBtn = (Button) findViewById(R.id.applySolutionBtn);
//        viewSolutionsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Apply for the solution
//                Intent intent = new Intent(SolutionDetailActivity.this, .class);
//                startActivity(intent);
//            }
//        });


        //Button to go back
        Button btnBack = (Button) findViewById(R.id.btnBackSolution);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(SolutionDetailActivity.this, DiscoverChallengeActivity.class);
                startActivity(backIntent);
                finish();
            }
        });

        //Button to go back
        Button btnBackDashboard = (Button) findViewById(R.id.btnBackDashboard);
        btnBackDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backdIntent = new Intent(SolutionDetailActivity.this, MainActivity.class);
                startActivity(backdIntent);
                finish();
            }
        });







    }

    private void loadSolutionData(Solution solution) {
        solutionImageViewDtl.setImageResource(solution.getSolutionImage());
        solutionNameTextDtl.setText(solution.getSolutionName());
        solutionBlurbTextDtl.setText(solution.getSolutionBlurb());
        solutionDescTextDtl.setText(solution.getSolutionDesc());
    }

}
