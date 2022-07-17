package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

public class ProfileEditActivity extends AppCompatActivity {
    private static final String TAG = "ProfileSDGEdit";
    public static final String INTENT_MESSAGE = "intent_message";
    private Chip chipNoPoverty, chipZeroHunger, chipGoodHealth, chipQuality, chipGender, chipCleanWater,
            chipAffordable, chipDecent, chipIndustry, chipReduced, chipSustainable, chipResponsible,
            chipClimate, chipLifeBelow, chipLifeOn, chipPeace, chipPartnerShip;
    private Button btnDone;
//    private ArrayList<String> selectedChipDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdg_edit);

        chipNoPoverty = findViewById(R.id.chipScience);
        chipNoPoverty.setChecked(Update("STATE_ONE"));

        chipZeroHunger = findViewById(R.id.chipTechnology);
        chipZeroHunger.setChecked(Update("STATE_TWO"));

        chipQuality = findViewById(R.id.chipGovernment);
        chipQuality.setChecked(Update("STATE_THREE"));

        chipGender = findViewById(R.id.chipGender);
        chipGender.setChecked(Update("STATE_FOUR"));

        chipCleanWater = findViewById(R.id.chipCleanWater);
        chipCleanWater.setChecked(Update("STATE_FIVE"));

        chipAffordable = findViewById(R.id.chipAffordable);
        chipAffordable.setChecked(Update("STATE_SIX"));

        chipDecent = findViewById(R.id.chipDecent);
        chipDecent.setChecked(Update("STATE_SEVEN"));

        chipIndustry = findViewById(R.id.chipIndustry);
        chipIndustry.setChecked(Update("STATE_EIGHT"));

        chipReduced = findViewById(R.id.chipReduced);
        chipReduced.setChecked(Update("STATE_NINE"));

        chipSustainable = findViewById(R.id.chipSustainable);
        chipSustainable.setChecked(Update("STATE_TEN"));

        chipResponsible = findViewById(R.id.chipResponsible);
        chipResponsible.setChecked(Update("STATE_ELEVEN"));

        chipClimate = findViewById(R.id.chipClimate);
        chipClimate.setChecked(Update("STATE_TWELVE"));

        chipLifeBelow = findViewById(R.id.chipLifeBelow);
        chipLifeBelow.setChecked(Update("STATE_THIRTEEN"));

        chipLifeOn = findViewById(R.id.chipLifeOn);
        chipLifeOn.setChecked(Update("STATE_FOURTEEN"));

        chipPeace = findViewById(R.id.chipPeace);
        chipPeace.setChecked(Update("STATE_FIFTHTEEN"));

        chipPartnerShip = findViewById(R.id.chipPartnership);
        chipPartnerShip.setChecked(Update("STATE_SIXTEEN"));

        chipGoodHealth = findViewById(R.id.chipBusiness);
        chipGoodHealth.setChecked(Update("STATE_SEVENTEEN"));

        Button btnDone = findViewById(R.id.btnDone);
            btnDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ProfileEditActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
            });


        chipNoPoverty.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean noPovertyChecked) {
                SaveIntoSharedPrefs("STATE_ONE", noPovertyChecked);
            }
        });

        chipZeroHunger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean zeroHungerChecked) {
                SaveIntoSharedPrefs("STATE_TWO", zeroHungerChecked);

            }
        });

        chipQuality.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean qualityChecked) {
                SaveIntoSharedPrefs("STATE_THREE", qualityChecked);

            }
        });

        chipGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("STATE_FOUR", genderChecked);

            }
        });

        chipCleanWater.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean cleanWaterChecked) {
                SaveIntoSharedPrefs("STATE_FIVE", cleanWaterChecked);

            }
        });

        chipAffordable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean affordableChecked) {
                SaveIntoSharedPrefs("STATE_SIX", affordableChecked);

            }
        });

        chipDecent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean decentChecked) {
                SaveIntoSharedPrefs("STATE_SEVEN", decentChecked);

            }
        });

        chipIndustry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean industryChecked) {
                SaveIntoSharedPrefs("STATE_EIGHT", industryChecked);

            }
        });

        chipReduced.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean reducedChecked) {
                SaveIntoSharedPrefs("STATE_NINE", reducedChecked);

            }
        });

        chipSustainable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean sustainableChecked) {
                SaveIntoSharedPrefs("STATE_TEN", sustainableChecked);

            }
        });

        chipResponsible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean responsibleChecked) {
                SaveIntoSharedPrefs("STATE_ELEVEN", responsibleChecked);

            }
        });

        chipClimate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean climateChecked) {
                SaveIntoSharedPrefs("STATE_TWELVE", climateChecked);

            }
        });

        chipLifeBelow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean lifeBelowChecked) {
                SaveIntoSharedPrefs("STATE_THIRTEEN", lifeBelowChecked);

            }
        });

        chipLifeOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean lifeOnChecked) {
                SaveIntoSharedPrefs("STATE_FOURTEEN", lifeOnChecked);

            }
        });

        chipPeace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean peaceChecked) {
                SaveIntoSharedPrefs("STATE_FIFTHTEEN", peaceChecked);

            }
        });

        chipPartnerShip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean partnerShipChecked) {
                SaveIntoSharedPrefs("STATE_SIXTEEN", partnerShipChecked);

            }
        });

        chipGoodHealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean goodHealthChecked) {
                SaveIntoSharedPrefs("STATE_SEVENTEEN", goodHealthChecked);
            }
        });




//        selectedChipDate = new ArrayList<>();
//
//
//        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b)
//                {
//                    selectedChipDate.add(compoundButton.getText().toString());
//
//                }
//                else
//                {
//                    selectedChipDate.remove(compoundButton.getText().toString());
//                }
//            }
//        };
//
//        chipNoPoverty.setOnCheckedChangeListener(checkedChangeListener);
//        chipZeroHunger.setOnCheckedChangeListener(checkedChangeListener);
//        chipQuality.setOnCheckedChangeListener(checkedChangeListener);
//        chipGender.setOnCheckedChangeListener(checkedChangeListener);
//        chipCleanWater.setOnCheckedChangeListener(checkedChangeListener);
//        chipAffordable.setOnCheckedChangeListener(checkedChangeListener);
//        chipDecent.setOnCheckedChangeListener(checkedChangeListener);
//        chipIndustry.setOnCheckedChangeListener(checkedChangeListener);
//        chipReduced.setOnCheckedChangeListener(checkedChangeListener);
//        chipSustainable.setOnCheckedChangeListener(checkedChangeListener);
//        chipResponsible.setOnCheckedChangeListener(checkedChangeListener);
//        chipClimate.setOnCheckedChangeListener(checkedChangeListener);
//        chipLifeBelow.setOnCheckedChangeListener(checkedChangeListener);
//        chipLifeOn.setOnCheckedChangeListener(checkedChangeListener);
//        chipPeace.setOnCheckedChangeListener(checkedChangeListener);
//        chipPartnerShip.setOnCheckedChangeListener(checkedChangeListener);





        ///Filter Method

//        btnDone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("data", selectedChipDate.toString());
//                setResult(101, resultIntent);
//                finish();
//
//
//
//            }
//        });
        // Get handle for view elements



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
