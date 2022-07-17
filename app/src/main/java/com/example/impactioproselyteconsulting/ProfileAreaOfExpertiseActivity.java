package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.chip.Chip;

public class ProfileAreaOfExpertiseActivity extends AppCompatActivity {

    private Button btnDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_area_of_expertise);

        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileAreaOfExpertiseActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}