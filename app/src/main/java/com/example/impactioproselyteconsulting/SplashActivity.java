package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    TextView welcomeMsg;
    ImageView ImpactioImg;
    Animation animSlideIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Animation Snippet
        ImpactioImg = findViewById(R.id.ptLoginImg);
        welcomeMsg = findViewById(R.id.welcomeMsg);
        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        ImpactioImg.startAnimation(animSlideIn);
        welcomeMsg.setVisibility(View.VISIBLE);
        welcomeMsg.startAnimation(animSlideIn);
        //Animation Snippet

        handler = new Handler();
        handler.postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
            {
            }
        }, 3000);
    }


}