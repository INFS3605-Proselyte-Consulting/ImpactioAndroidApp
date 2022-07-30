package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {
    private RatingBar ratingBar1,ratingBar2;
    int myRating1 = 0;
    int myRating2 = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        setTitle("Curation Ratings");

        ratingBar1 = findViewById(R.id.rbRating1);
        ratingBar2 = findViewById(R.id.rbRating2);


        //This is just a fancier way of introducing a button and listener, courtesty of beatrice.
        Button goBackMain = (Button) findViewById(R.id.bRatingBack);
        goBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RatingActivity.this,String.valueOf(myRating1),Toast.LENGTH_SHORT).show();
                Toast.makeText(RatingActivity.this,String.valueOf(myRating2),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RatingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //Rating 1 listener.
        ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                //understand that float v corresponds to the line above. We made it int cos idk i don't want half stars lol.
                int rating = (int) v;
                String message = "";
                //note: ratingBar is corresponding to the line 44 ratingBar.
                myRating1 = (int) ratingBar.getRating();
                //This switch serves no functional purpose other than to just show that we picked numbers lol.
                switch(rating){
                    case 1:
                        message = "You picked 1 stars";
                        break;
                    case 2:
                        message = "You picked 2 stars";
                        break;
                    case 3:
                        message = "You picked 3 stars";
                        break;
                    case 4:
                        message = "You picked 4 stars";
                        break;
                    case 5:
                        message = "You picked 5 stars";
                        break;
                }
            }
        });

        //Same as the rating bar above.
        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message = "";
                myRating2 = (int) ratingBar.getRating();
                switch(rating){
                    case 1:
                        message = "You picked 1 stars";
                        break;
                    case 2:
                        message = "You picked 2 stars";
                        break;
                    case 3:
                        message = "You picked 3 stars";
                        break;
                    case 4:
                        message = "You picked 4 stars";
                        break;
                    case 5:
                        message = "You picked 5 stars";
                        break;
                }
                Toast.makeText(RatingActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
