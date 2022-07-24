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

        chipNoPoverty = findViewById(R.id.chipNoPoverty);
        chipNoPoverty.setChecked(Update("SDGSTATE_ONE"));

        chipZeroHunger = findViewById(R.id.chipZeroHunger);
        chipZeroHunger.setChecked(Update("SDGSTATE_TWO"));

        chipQuality = findViewById(R.id.chipQuality);
        chipQuality.setChecked(Update("SDGSTATE_THREE"));

        chipGender = findViewById(R.id.chipGender);
        chipGender.setChecked(Update("SDGSTATE_FOUR"));

        chipCleanWater = findViewById(R.id.chipCleanWater);
        chipCleanWater.setChecked(Update("SDGSTATE_FIVE"));

        chipAffordable = findViewById(R.id.chipAffordable);
        chipAffordable.setChecked(Update("SDGSTATE_SIX"));

        chipDecent = findViewById(R.id.chipDecent);
        chipDecent.setChecked(Update("SDGSTATE_SEVEN"));

        chipIndustry = findViewById(R.id.chipIndustry);
        chipIndustry.setChecked(Update("SDGSTATE_EIGHT"));

        chipReduced = findViewById(R.id.chipReduced);
        chipReduced.setChecked(Update("SDGSTATE_NINE"));

        chipSustainable = findViewById(R.id.chipSustainable);
        chipSustainable.setChecked(Update("SDGSTATE_TEN"));

        chipResponsible = findViewById(R.id.chipResponsible);
        chipResponsible.setChecked(Update("SDGSTATE_ELEVEN"));

        chipClimate = findViewById(R.id.chipClimate);
        chipClimate.setChecked(Update("SDGSTATE_TWELVE"));

        chipLifeBelow = findViewById(R.id.chipLifeBelow);
        chipLifeBelow.setChecked(Update("SDGSTATE_THIRTEEN"));

        chipLifeOn = findViewById(R.id.chipLifeOn);
        chipLifeOn.setChecked(Update("SDGSTATE_FOURTEEN"));

        chipPeace = findViewById(R.id.chipPeace);
        chipPeace.setChecked(Update("SDGSTATE_FIFTHTEEN"));

        chipPartnerShip = findViewById(R.id.chipPartnership);
        chipPartnerShip.setChecked(Update("SDGSTATE_SIXTEEN"));

        chipGoodHealth = findViewById(R.id.chipGoodHealth);
        chipGoodHealth.setChecked(Update("SDGSTATE_SEVENTEEN"));

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
                SaveIntoSharedPrefs("SDGSTATE_ONE", noPovertyChecked);
            }
        });

        chipZeroHunger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean zeroHungerChecked) {
                SaveIntoSharedPrefs("SDGSTATE_TWO", zeroHungerChecked);

            }
        });

        chipQuality.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean qualityChecked) {
                SaveIntoSharedPrefs("SDGSTATE_THREE", qualityChecked);

            }
        });

        chipGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean genderChecked) {
                SaveIntoSharedPrefs("SDGSTATE_FOUR", genderChecked);

            }
        });

        chipCleanWater.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean cleanWaterChecked) {
                SaveIntoSharedPrefs("SDGSTATE_FIVE", cleanWaterChecked);

            }
        });

        chipAffordable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean affordableChecked) {
                SaveIntoSharedPrefs("SDGSTATE_SIX", affordableChecked);

            }
        });

        chipDecent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean decentChecked) {
                SaveIntoSharedPrefs("SDGSTATE_SEVEN", decentChecked);

            }
        });

        chipIndustry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean industryChecked) {
                SaveIntoSharedPrefs("SDGSTATE_EIGHT", industryChecked);

            }
        });

        chipReduced.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean reducedChecked) {
                SaveIntoSharedPrefs("SDGSTATE_NINE", reducedChecked);

            }
        });

        chipSustainable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean sustainableChecked) {
                SaveIntoSharedPrefs("SDGSTATE_TEN", sustainableChecked);

            }
        });

        chipResponsible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean responsibleChecked) {
                SaveIntoSharedPrefs("SDGSTATE_ELEVEN", responsibleChecked);

            }
        });

        chipClimate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean climateChecked) {
                SaveIntoSharedPrefs("SDGSTATE_TWELVE", climateChecked);

            }
        });

        chipLifeBelow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean lifeBelowChecked) {
                SaveIntoSharedPrefs("SDGSTATE_THIRTEEN", lifeBelowChecked);

            }
        });

        chipLifeOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean lifeOnChecked) {
                SaveIntoSharedPrefs("SDGSTATE_FOURTEEN", lifeOnChecked);

            }
        });

        chipPeace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean peaceChecked) {
                SaveIntoSharedPrefs("SDGSTATE_FIFTHTEEN", peaceChecked);

            }
        });

        chipPartnerShip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean partnerShipChecked) {
                SaveIntoSharedPrefs("SDGSTATE_SIXTEEN", partnerShipChecked);

            }
        });

        chipGoodHealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean goodHealthChecked) {
                SaveIntoSharedPrefs("SDGSTATE_SEVENTEEN", goodHealthChecked);
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
    private void SaveIntoSharedPrefs(String SDGkey, boolean value){

        SharedPreferences sdgsp = getSharedPreferences("SDGSTATE", MODE_PRIVATE);
        SharedPreferences.Editor editor = sdgsp.edit();
        editor.putBoolean(SDGkey, value);
        editor.apply();
    }
    ///Update Selected SDGs
    private boolean Update(String SDGkey){

        SharedPreferences sdgsp = getSharedPreferences("SDGSTATE", MODE_PRIVATE);
        return sdgsp.getBoolean(SDGkey, false);
    }


}
