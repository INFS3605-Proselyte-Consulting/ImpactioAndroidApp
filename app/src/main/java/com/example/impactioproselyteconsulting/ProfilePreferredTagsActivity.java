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

public class ProfilePreferredTagsActivity extends AppCompatActivity {

    private Chip chipEnvironment, chipTechnologyTag, chipGlobalBusiness, chipGovernment, chipEconomy, chipFamily;

    private Button btnDone;
    Animation animSlideIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_preferred_tags);

        chipEnvironment = findViewById(R.id.chipEnvironment);
        chipEnvironment.setChecked(Update("TAGSTATE_ONE"));

        chipTechnologyTag = findViewById(R.id.chipTechnologyTag);
        chipTechnologyTag.setChecked(Update("TAGSTATE_TWO"));

        chipGlobalBusiness = findViewById(R.id.chipGlobalBusiness);
        chipGlobalBusiness.setChecked(Update("TAGSTATE_THREE"));

        chipGovernment = findViewById(R.id.chipGovernment);
        chipGovernment.setChecked(Update("TAGSTATE_FOUR"));

        chipEconomy = findViewById(R.id.chipEconomy);
        chipEconomy.setChecked(Update("TAGSTATE_THREE"));

        chipFamily = findViewById(R.id.chipFamily);
        chipFamily.setChecked(Update("TAGSTATE_FOUR"));

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
                SaveIntoSharedPrefs("TAGSTATE_ONE", noPovertyChecked);
            }
        });

        chipTechnologyTag.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean zeroHungerChecked) {
                SaveIntoSharedPrefs("TAGSTATE_TWO", zeroHungerChecked);

            }
        });

        chipGlobalBusiness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean qualityChecked) {
                SaveIntoSharedPrefs("TAGSTATE_THREE", qualityChecked);

            }
        });

        chipEconomy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("TAGSTATE_FOUR", genderChecked);

            }
        });

        chipFamily.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("TAGSTATE_FIVE", genderChecked);

            }
        });

        chipGovernment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("TAGSTATE_SIX", genderChecked);

            }
        });
    }

    //Save Selected SDGs
    private void SaveIntoSharedPrefs(String Tagkey, boolean value){

        SharedPreferences Tagsp = getSharedPreferences("TAGSTATE", MODE_PRIVATE);
        SharedPreferences.Editor editor = Tagsp.edit();
        editor.putBoolean(Tagkey, value);
        editor.apply();
    }
    ///Update Selected SDGs
    private boolean Update(String Tagkey){

        SharedPreferences Tagsp = getSharedPreferences("TAGSTATE", MODE_PRIVATE);
        return Tagsp.getBoolean(Tagkey, false);
    }
}