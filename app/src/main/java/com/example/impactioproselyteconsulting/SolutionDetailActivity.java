package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SolutionDetailActivity extends AppCompatActivity {

    private ImageView SolutionImgViewDetail;
    private TextView SolutionNameTxtDetail, SolutionBlurbTxtDetail, descriptionLabel, SolutionDescTxtDetail;
    private ListView TagsListView;
    private Button applySolutionBtn, btnBackSolution;
    private CardView SolCV;


    Animation animSlideIn;



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

        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);


        SolutionImgViewDetail = findViewById(R.id.SolutionImgViewDetail);
        SolutionImgViewDetail.startAnimation(animSlideIn);
        SolutionNameTxtDetail = findViewById(R.id.SolutionNameTxtDetail);
        SolutionNameTxtDetail.startAnimation(animSlideIn);
        SolutionBlurbTxtDetail = findViewById(R.id.SolutionBlurbTxtDetail);
        SolutionBlurbTxtDetail.startAnimation(animSlideIn);
        descriptionLabel = findViewById(R.id.descriptionLabel);
        descriptionLabel.startAnimation(animSlideIn);
        SolutionDescTxtDetail = findViewById(R.id.SolutionDescTxtDetail);
        SolutionDescTxtDetail.startAnimation(animSlideIn);
        TagsListView = findViewById(R.id.tagsListView);
        applySolutionBtn = findViewById(R.id.applySolutionBtn);
        applySolutionBtn.startAnimation(animSlideIn);
        btnBackSolution = findViewById(R.id.btnBackSolution);
        btnBackSolution.startAnimation(animSlideIn);
        SolCV = findViewById(R.id.SolCV);
        SolCV.startAnimation(animSlideIn);


        Intent intent = getIntent();
        Solution solution = Solution.getSolutionFromDB(intent.getStringExtra("Name"));

        loadSolutionData(solution);


        // Button to apply for this solution
        //TODO
        // Implement apply functionality
        Button viewSolutionsBtn = (Button) findViewById(R.id.applySolutionBtn);
        viewSolutionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Apply for the solution
                // Backend wise: The solution name should be added to the database
                // via the path Customer Info / UserId / To-do
                // The solution should also be removed from
                // Frontend wise: The user is taken to Main Activity aka the Dashboard
                // They should see a Toast that says Successfully Applied

                // For Hardcoded:
                // The User is taken to the Main Activity aka the Dashboard
                // They should see a toast that says Successfully Applied
                // Backend: Take them to Curate Activity and pass in the intent
                Intent intent = new Intent(SolutionDetailActivity.this, RatingActivity.class);
                intent.putExtra("Name", solution.getSolutionName());
                startActivity(intent);
            }
        });


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

//        //Button to go back
//        Button btnBackDashboard = (Button) findViewById(R.id.btnBackDashboard);
//        btnBackDashboard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent backdIntent = new Intent(SolutionDetailActivity.this, MainActivity.class);
//                startActivity(backdIntent);
//                finish();
//            }
//        });







    }

    private void loadSolutionData(Solution solution) {
        SolutionImgViewDetail.setImageResource(solution.getSolutionImage());
        SolutionNameTxtDetail.setText(solution.getSolutionName());
        SolutionBlurbTxtDetail.setText(solution.getSolutionBlurb());
        SolutionDescTxtDetail.setText(solution.getSolutionDesc());
        ArrayAdapter<String> arr;
        arr
                = new ArrayAdapter<String>(
                this,
                com.airbnb.lottie.R.layout.support_simple_spinner_dropdown_item,
                solution.getSolutionTagsList());
        TagsListView.setAdapter(arr);
    }

}
