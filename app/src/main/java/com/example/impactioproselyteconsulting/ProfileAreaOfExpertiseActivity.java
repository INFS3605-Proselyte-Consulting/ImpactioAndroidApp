package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CompoundButton;

import com.google.android.material.chip.Chip;

public class ProfileAreaOfExpertiseActivity extends AppCompatActivity {

    private Chip chipScience, chipTechnology, chipEngineering, chipEducation;
    Animation animSlideIn;

    private Button btnDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_area_of_expertise);

        chipScience = findViewById(R.id.chipScience);
        chipScience.setChecked(Update("AREAOFEXPERTISESTATE_ONE"));

        chipTechnology = findViewById(R.id.chipTechnology);
        chipTechnology.setChecked(Update("AREAOFEXPERTISESTATE_TWO"));

        chipEngineering = findViewById(R.id.chipEngineering);
        chipEngineering.setChecked(Update("AREAOFEXPERTISESTATE_THREE"));

        chipEducation = findViewById(R.id.chipEducation);
        chipEducation.setChecked(Update("AREAOFEXPERTISESTATE_FOUR"));


        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileAreaOfExpertiseActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });


        chipScience.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean noPovertyChecked) {
                SaveIntoSharedPrefs("AREAOFEXPERTISESTATE_ONE", noPovertyChecked);
            }
        });

        chipTechnology.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean zeroHungerChecked) {
                SaveIntoSharedPrefs("AREAOFEXPERTISESTATE_TWO", zeroHungerChecked);

            }
        });

        chipEngineering.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean qualityChecked) {
                SaveIntoSharedPrefs("AREAOFEXPERTISESTATE_THREE", qualityChecked);

            }
        });

        chipEducation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("AREAOFEXPERTISESTATE_FOUR", genderChecked);

            }
        });

    }

        //Save Selected SDGs
        private void SaveIntoSharedPrefs(String AreaOfExpertiseKey, boolean value){

            SharedPreferences areasp = getSharedPreferences("AREAOFEXPERTISESTATE", MODE_PRIVATE);
            SharedPreferences.Editor editor = areasp.edit();
            editor.putBoolean(AreaOfExpertiseKey, value);
            editor.apply();
        }
        ///Update Selected SDGs
        private boolean Update(String AreaOfExpertiseKey){

            SharedPreferences areasp = getSharedPreferences("AREAOFEXPERTISESTATE", MODE_PRIVATE);
            return areasp.getBoolean(AreaOfExpertiseKey, false);
        }



    }
