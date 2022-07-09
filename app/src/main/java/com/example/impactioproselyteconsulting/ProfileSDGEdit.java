package com.example.impactioproselyteconsulting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileSDGEdit extends AppCompatActivity {
    private static final String TAG = "ProfileSDGEdit";
    public static final String INTENT_MESSAGE = "intent_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdg_edit);

        Button profileSDGEditDoneButton = (Button) findViewById(R.id.btnSdgEdit);
        profileSDGEditDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileSDGEdit.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        // Get handle for view elements

    }
}
