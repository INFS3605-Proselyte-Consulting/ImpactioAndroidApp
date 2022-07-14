package com.example.impactioproselyteconsulting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.chip.Chip;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    public static final String INTENT_MESSAGE = "intent_message";
    private TextView tvName, tvBiography, tvImpactioRole, tvCompany, tvPosition, tvEmail, tvLinkedIn;
    private ImageView ivProfilePic;
    private Button btnEdit, btnLogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Get handle for view elements
        ivProfilePic = findViewById(R.id.ivProfilePic);
        tvName = findViewById(R.id.profileName);
        tvBiography = findViewById(R.id.tvBiography);
        tvImpactioRole = findViewById(R.id.tvImpactioRole);
        tvCompany = findViewById(R.id.tvCompany);
        tvPosition = findViewById(R.id.tvPosition);
        tvEmail = findViewById(R.id.tvEmail);
        tvLinkedIn = findViewById(R.id.tvLinkedin);
        btnLogOut = findViewById(R.id.btnLogOut);





        btnEdit = findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(ProfileActivity.this, ProfileEditActivity.class);
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){
            TextView textView = findViewById(R.id.tvResult);
            textView.setText(data.getStringExtra("data"));

        }
    }
}