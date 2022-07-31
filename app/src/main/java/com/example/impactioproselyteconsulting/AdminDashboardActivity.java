package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        Button adminLogout = (Button) findViewById(R.id.bAdminLogout);
        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the Discover Challenges Activity
                Intent intent = new Intent(AdminDashboardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
