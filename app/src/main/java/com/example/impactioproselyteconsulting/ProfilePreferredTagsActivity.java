package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.google.android.material.chip.Chip;

public class ProfilePreferredTagsActivity extends AppCompatActivity {

    private Chip chipEnvironment, chipTechnologyTag, chipGlobalBusiness, chipGovernment, chipEconomy, chipFamily;

    private Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_preferred_tags);

        chipEnvironment = findViewById(R.id.chipEnvironment);
        chipEnvironment.setChecked(Update("STATE_ONE"));

        chipTechnologyTag = findViewById(R.id.chipTechnologyTag);
        chipTechnologyTag.setChecked(Update("STATE_TWO"));

        chipGlobalBusiness = findViewById(R.id.chipGlobalBusiness);
        chipGlobalBusiness.setChecked(Update("STATE_THREE"));

        chipGovernment = findViewById(R.id.chipGovernment);
        chipGovernment.setChecked(Update("STATE_FOUR"));

        chipEconomy = findViewById(R.id.chipEconomy);
        chipEconomy.setChecked(Update("STATE_THREE"));

        chipFamily = findViewById(R.id.chipFamily);
        chipFamily.setChecked(Update("STATE_FOUR"));

        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePreferredTagsActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        chipEnvironment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean noPovertyChecked) {
                SaveIntoSharedPrefs("STATE_ONE", noPovertyChecked);
            }
        });

        chipTechnologyTag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean zeroHungerChecked) {
                SaveIntoSharedPrefs("STATE_TWO", zeroHungerChecked);

            }
        });

        chipGlobalBusiness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean qualityChecked) {
                SaveIntoSharedPrefs("STATE_THREE", qualityChecked);

            }
        });

        chipEconomy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("STATE_FOUR", genderChecked);

            }
        });

        chipFamily.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("STATE_FIVE", genderChecked);

            }
        });

        chipGovernment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("STATE_SIX", genderChecked);

            }
        });
    }

    //Save Selected SDGs
    private void SaveIntoSharedPrefs(String key, boolean value){

        SharedPreferences sp = getSharedPreferences("STATE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    ///Update Selected SDGs
    private boolean Update(String key){

        SharedPreferences sp = getSharedPreferences("STATE", MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }
}