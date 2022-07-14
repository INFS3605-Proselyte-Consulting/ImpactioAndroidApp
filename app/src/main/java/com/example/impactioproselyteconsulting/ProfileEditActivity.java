package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class ProfileEditActivity extends AppCompatActivity {
    private static final String TAG = "ProfileSDGEdit";
    public static final String INTENT_MESSAGE = "intent_message";
    private Chip chipNoPoverty, chipZeroHunger, chipQuality, chipGender, chipCleanWater,
            chipAffordable, chipDecent, chipIndustry, chipReduced, chipSustainable, chipResponsible,
            chipClimate, chipLifeBelow, chipLifeOn, chipPeace, chipPartnerShip;
    private Button btnDone;
    private ArrayList<String> selectedChipDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdg_edit);

        chipNoPoverty = findViewById(R.id.chipNoPoverty);
        chipZeroHunger = findViewById(R.id.chipZeroHunger);
        chipQuality = findViewById(R.id.chipQuality);
        chipGender = findViewById(R.id.chipGender);
        chipCleanWater = findViewById(R.id.chipCleanWater);
        chipAffordable = findViewById(R.id.chipAffordable);
        chipDecent = findViewById(R.id.chipDecent);
        chipIndustry = findViewById(R.id.chipIndustry);
        chipReduced = findViewById(R.id.chipReduced);
        chipSustainable = findViewById(R.id.chipSustainable);
        chipResponsible = findViewById(R.id.chipResponsible);
        chipClimate = findViewById(R.id.chipClimate);
        chipLifeBelow = findViewById(R.id.chipLifeBelow);
        chipLifeOn = findViewById(R.id.chipLifeOn);
        chipPeace = findViewById(R.id.chipPeace);
        chipPartnerShip = findViewById(R.id.chipPartnership);

        selectedChipDate = new ArrayList<>();

        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    selectedChipDate.add(compoundButton.getText().toString());
                }
                else
                {
                    selectedChipDate.remove(compoundButton.getText().toString());
                }
            }
        };

        chipNoPoverty.setOnCheckedChangeListener(checkedChangeListener);
        chipZeroHunger.setOnCheckedChangeListener(checkedChangeListener);
        chipQuality.setOnCheckedChangeListener(checkedChangeListener);
        chipGender.setOnCheckedChangeListener(checkedChangeListener);
        chipCleanWater.setOnCheckedChangeListener(checkedChangeListener);
        chipAffordable.setOnCheckedChangeListener(checkedChangeListener);
        chipDecent.setOnCheckedChangeListener(checkedChangeListener);
        chipIndustry.setOnCheckedChangeListener(checkedChangeListener);
        chipReduced.setOnCheckedChangeListener(checkedChangeListener);
        chipSustainable.setOnCheckedChangeListener(checkedChangeListener);
        chipResponsible.setOnCheckedChangeListener(checkedChangeListener);
        chipClimate.setOnCheckedChangeListener(checkedChangeListener);
        chipLifeBelow.setOnCheckedChangeListener(checkedChangeListener);
        chipLifeOn.setOnCheckedChangeListener(checkedChangeListener);
        chipPeace.setOnCheckedChangeListener(checkedChangeListener);
        chipPartnerShip.setOnCheckedChangeListener(checkedChangeListener);



        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("data", selectedChipDate.toString());
                setResult(101, resultIntent);
                finish();


                //Intent intent = new Intent(ProfileEditActivity.this, ProfileActivity.class);
                //startActivity(intent);
            }
        });
        // Get handle for view elements



    }


}
