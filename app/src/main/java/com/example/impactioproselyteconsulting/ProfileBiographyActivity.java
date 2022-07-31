package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileBiographyActivity extends AppCompatActivity {

    Animation animSlideIn;

    private Button btnDone, btnBiography, btnRole, btnCompany, btnPosition, btnEmail, btnPhone, btnLinkdIn, btnTwitter;
    private TextView tvBiographyTitle, tvRoleTitle, tvCompanyTitle, tvPositionTitle, tvEmailTitle, tvPhoneTitle, tvLinkdInTitle, tvTwitterTitle;
    private EditText tvBiographyDescription, tvRole, tvCompany, tvPosition, tvEmail, tvPhone, tvLinkdIn, tvTwitter;
    private String getStringBiography, getStringRole, getStringCompany, getStringPosition, getStringEmail, getStringPhone, getStringLinkdIn, getStringTwitter;
    private static final String SHARED_PREFBIOGRAPHY = "sharedBiography", SHARED_PREFROLE = "sharedRole", SHARED_PREFCOMPANY = "sharedCompany", SHARED_PREFPOSITION = "sharedPosition", SHARED_PREFEMAIL = "sharedEmail", SHARED_PREFPHONE = "sharedPhone", SHARED_PREFLINKDIN = "sharedLinkdIn", SHARED_PREFTWITTER = "sharedTwitter";
    private static final String TEXTBIOGRAPHY = "textBiography", TEXTROLE = "textRole", TEXTCOMPANY = "textCompany", TEXTPOSITION = "textPosition", TEXTEMAIL = "textEmail", TEXTPHONE = "textPhone", TEXTLINKDIN = "textLinkdIn", TEXTTWITTER = "textTwitter";
    private String textBiography, textRole, textCompany, textPostion, textEmail, textPhone, textLinkdIn, textTwitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_biography);

        tvBiographyDescription = findViewById(R.id.tvBiographyDescription);
        tvRole = findViewById(R.id.tvRole);
        tvCompany = findViewById(R.id.tvCompany);
        tvPosition = findViewById(R.id.tvPosition);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvLinkdIn = findViewById(R.id.tvLinkdIn);
        tvTwitter = findViewById(R.id.tvTwitter);

        tvBiographyTitle = findViewById(R.id.tvBiographyTitle);
        tvRoleTitle = findViewById(R.id.tvRoleTitle);
        tvCompanyTitle = findViewById(R.id.tvCompanyTitle);
        tvPositionTitle = findViewById(R.id.tvPositionTitle);
        tvEmailTitle = findViewById(R.id.tvEmailTitle);
        tvPhoneTitle = findViewById(R.id.tvPhoneTitle);
        tvLinkdInTitle = findViewById(R.id.tvLinkdInTitle);
        tvTwitterTitle = findViewById(R.id.tvTwitterTitle);

        Button btnBiography = findViewById(R.id.btnBiography);
        btnBiography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringBiography = tvBiographyDescription.getText().toString();
                tvBiographyTitle.setText(getStringBiography);
                SharedPreferences sharedPreferencesBiography = getSharedPreferences(SHARED_PREFBIOGRAPHY,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesBiography.edit();
                editor.putString(TEXTBIOGRAPHY,tvBiographyTitle.getText().toString());
                editor.apply();
            }
        });

        Button btnRole = findViewById(R.id.btnRole);
        btnRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringRole = tvRole.getText().toString();
                tvRoleTitle.setText(getStringRole);
                SharedPreferences sharedPreferencesRole = getSharedPreferences(SHARED_PREFROLE,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesRole.edit();
                editor.putString(TEXTROLE,tvRoleTitle.getText().toString());
                editor.apply();

            }
        });

        Button btnCompany = findViewById(R.id.btnCompany);
        btnCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringCompany = tvCompany.getText().toString();
                tvCompanyTitle.setText(getStringCompany);
                SharedPreferences sharedPreferencesCompany = getSharedPreferences(SHARED_PREFCOMPANY,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesCompany.edit();
                editor.putString(TEXTCOMPANY,tvCompanyTitle.getText().toString());
                editor.apply();
            }
        });
        Button btnPosition = findViewById(R.id.btnPosition);
        btnPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringPosition = tvPosition.getText().toString();
                tvPositionTitle.setText(getStringPosition);
                SharedPreferences sharedPreferencesPosition = getSharedPreferences(SHARED_PREFPOSITION,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesPosition.edit();
                editor.putString(TEXTPOSITION,tvPositionTitle.getText().toString());
                editor.apply();
            }
        });

        Button btnEmail = findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringEmail = tvEmail.getText().toString();
                tvEmailTitle.setText(getStringEmail);
                SharedPreferences sharedPreferencesEmail = getSharedPreferences(SHARED_PREFEMAIL,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesEmail.edit();
                editor.putString(TEXTEMAIL,tvEmailTitle.getText().toString());
                editor.apply();
            }
        });

        Button btnPhone = findViewById(R.id.btnPhone);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringPhone = tvPhone.getText().toString();
                tvPhoneTitle.setText(getStringPhone);
                SharedPreferences sharedPreferencesPhone = getSharedPreferences(SHARED_PREFPHONE,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesPhone.edit();
                editor.putString(TEXTPHONE,tvPhoneTitle.getText().toString());
                editor.apply();
            }
        });

        Button btnLinkdIn = findViewById(R.id.btnLinkdIn);
        btnLinkdIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringLinkdIn = tvLinkdIn.getText().toString();
                tvLinkdInTitle.setText(getStringLinkdIn);
                SharedPreferences sharedPreferencesLinkdIn = getSharedPreferences(SHARED_PREFLINKDIN,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesLinkdIn.edit();
                editor.putString(TEXTLINKDIN,tvLinkdInTitle.getText().toString());
                editor.apply();
            }
        });

        Button btnTwitter = findViewById(R.id.btnTwitter);
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStringTwitter = tvTwitter.getText().toString();
                tvTwitterTitle.setText(getStringTwitter);
                SharedPreferences sharedPreferencesTwitter = getSharedPreferences(SHARED_PREFTWITTER,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesTwitter.edit();
                editor.putString(TEXTTWITTER,tvTwitterTitle.getText().toString());
                editor.apply();
            }
        });


        Button btnDone = findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileBiographyActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        updateBiography();
        updateRole();
        updateCompany();
        updatePosition();
        updateEmail();
        updatePhone();
        updateLinkdIn();
        updateTwitter();
    }


    private void updateBiography() {
        SharedPreferences sharedPreferencesBiography = getSharedPreferences(SHARED_PREFBIOGRAPHY, MODE_PRIVATE);
        textBiography = sharedPreferencesBiography.getString(TEXTBIOGRAPHY, "");
        tvBiographyTitle.setText(textBiography);
    }

    private void updateRole() {
        SharedPreferences sharedPreferencesRole = getSharedPreferences(SHARED_PREFROLE,MODE_PRIVATE);
        textRole = sharedPreferencesRole.getString(TEXTROLE, "");
        tvRoleTitle.setText(textRole);
    }

    private void updateCompany() {
        SharedPreferences sharedPreferencesCompany = getSharedPreferences(SHARED_PREFCOMPANY,MODE_PRIVATE);
        textCompany = sharedPreferencesCompany.getString(TEXTCOMPANY, "");
        tvCompanyTitle.setText(textCompany);
    }

    private void updatePosition() {
        SharedPreferences sharedPreferencesPosition = getSharedPreferences(SHARED_PREFPOSITION,MODE_PRIVATE);
        textPostion = sharedPreferencesPosition.getString(TEXTPOSITION, "");
        tvPositionTitle.setText(textPostion);
    }

    private void updateEmail() {
        SharedPreferences sharedPreferencesEmail = getSharedPreferences(SHARED_PREFEMAIL,MODE_PRIVATE);
        textEmail = sharedPreferencesEmail.getString(TEXTEMAIL, "");
        tvEmailTitle.setText(textEmail);
    }

    private void updatePhone() {
        SharedPreferences sharedPreferencesPhone = getSharedPreferences(SHARED_PREFPHONE,MODE_PRIVATE);
        textPhone = sharedPreferencesPhone.getString(TEXTPHONE, "");
        tvPhoneTitle.setText(textPhone);
    }

    private void updateLinkdIn() {
        SharedPreferences sharedPreferencesLinkdIn = getSharedPreferences(SHARED_PREFLINKDIN,MODE_PRIVATE);
        textLinkdIn = sharedPreferencesLinkdIn.getString(TEXTLINKDIN, "");
        tvLinkdInTitle.setText(textLinkdIn);
    }

    private void updateTwitter() {
        SharedPreferences sharedPreferencesTwitter = getSharedPreferences(SHARED_PREFTWITTER,MODE_PRIVATE);
        textTwitter = sharedPreferencesTwitter.getString(TEXTTWITTER, "");
        tvTwitterTitle.setText(textTwitter);
    }



}