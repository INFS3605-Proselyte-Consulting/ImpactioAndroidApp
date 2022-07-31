package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AdminDashboardActivity extends AppCompatActivity {
    public Button viewProjects,viewCurators;
    Animation animSlideIn;

    TextView welcomeTV, InProgressTV, solutionstv1, ToDoTV, solutionstv2;
    Button bAdminViewProjects, bAdminViewCurators, bAdminLogout;
    CardView allProjectsCV, AllCuratorsCV;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        viewProjects = findViewById(R.id.bAdminViewProjects);
        viewCurators = findViewById(R.id.bAdminViewCurators);
        welcomeTV = findViewById(R.id.welcomeTV);
        InProgressTV = findViewById(R.id.InProgressTV);
        solutionstv1 = findViewById(R.id.solutionstv1);
        ToDoTV = findViewById(R.id.ToDoTV);
        solutionstv2 = findViewById(R.id.solutionstv2);
        bAdminViewProjects = findViewById(R.id.bAdminViewProjects);
        bAdminViewCurators = findViewById(R.id.bAdminViewCurators);
        bAdminLogout = findViewById(R.id.bAdminLogout);
        allProjectsCV = findViewById(R.id.allProjectsCV);
        AllCuratorsCV = findViewById(R.id.AllCuratorsCV);

        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);


        viewProjects.startAnimation(animSlideIn);
        viewCurators.startAnimation(animSlideIn);
        welcomeTV.startAnimation(animSlideIn);
        InProgressTV.startAnimation(animSlideIn);
        solutionstv1.startAnimation(animSlideIn);
        ToDoTV.startAnimation(animSlideIn);
        solutionstv2.startAnimation(animSlideIn);
        bAdminViewProjects.startAnimation(animSlideIn);
        bAdminViewCurators.startAnimation(animSlideIn);
        bAdminLogout.startAnimation(animSlideIn);
        allProjectsCV.startAnimation(animSlideIn);
        AllCuratorsCV.startAnimation(animSlideIn);




        viewProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboardActivity.this,AdminChallengeActivity.class);
                startActivity(intent);
            }
        });

        viewCurators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminDashboardActivity.this,AdminAllProfileActivity.class);
                startActivity(intent);
            }
        });

        Button adminLogout = (Button) findViewById(R.id.bAdminLogout);
        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(AdminDashboardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
