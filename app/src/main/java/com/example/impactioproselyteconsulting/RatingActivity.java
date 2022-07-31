package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RatingActivity extends AppCompatActivity {
    private RatingBar ratingBar1,ratingBar2;
    private TextView tvRatingProjectTitle, tvRatingDesc;
    private Button goBackMain, btnSave;
    private EditText tvComment;
    int myRating1;
    int myRating2;
    Animation animSlideIn;

    //FireBase Database
    FirebaseDatabase firebaseDatabaseRating;

    //Reference for firebase

    DatabaseReference databaseReferenceSolutionNameAndDetails;
    DatabaseReference databaseReferenceGetRatingCount;
    DatabaseReference databaseReferenceCustomerInfo;
    DatabaseReference databaseReferenceRating1;
    DatabaseReference databaseReferenceRating2;
    DatabaseReference databaseReferenceRatingTotal;
    DatabaseReference databaseReferenceComment;


    //Create variable customerInfo

    CustomerInfo customerInfoRating;

    //Create variable solution

    Solution solutionRating;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        setTitle("Curation Ratings");

        tvRatingProjectTitle = findViewById(R.id.tvRatingProjectTitle);
        tvRatingDesc = findViewById(R.id.tvRatingDesc);

        ratingBar1 = findViewById(R.id.rbRating1);
        ratingBar2 = findViewById(R.id.rbRating2);

        tvComment = findViewById(R.id.tvComment);

        // initializing our object class variables

        customerInfoRating = new CustomerInfo();
        solutionRating = new Solution();

//        //This is for authentication
//        FirebaseAuth auth = FirebaseAuth.getInstance();

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

//      Locate the selected solution (to be changed when intention message is received when user clicks on curate button)

        String intention = "Blazing Beauty";
        int ratingCount = 2 + 1;

//      Retrieve solution name and description by creating an database instance and then reference

        firebaseDatabaseRating = FirebaseDatabase.getInstance();
        databaseReferenceSolutionNameAndDetails =  firebaseDatabaseRating.getReference().child("Solution").child(intention);

//        Produce solution name and description

        databaseReferenceSolutionNameAndDetails.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String name = dataSnapshot.child("solutionName").getValue().toString();
                tvRatingProjectTitle.setText(name);
                String desc = dataSnapshot.child("solutionDesc").getValue().toString();
                tvRatingDesc.setText(desc);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
                Toast.makeText(RatingActivity.this,message,Toast.LENGTH_SHORT).show();
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

//                        //Get the int value of ratingCount
//
//                databaseReferenceGetRatingCount = firebaseDatabaseRating.getReference("Solution/" + intention + "/" + "customerRating/");
//                databaseReferenceGetRatingCount.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        String number = dataSnapshot.child("ratingCount").getValue().toString();
//                        String add = "1";
//                        int count = Integer.parseInt(number) + Integer.parseInt(add);
//                        String ratingCount = "rating" + count;
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

        //Create the select ratingnode  to be used in databasereference path
        String rating = "rating" + ratingCount;


        //Create save button to add ratings to appropiate nodes in the database
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        databaseReferenceCustomerInfo=  firebaseDatabaseRating.getReference("Solution/" + intention +"/" + "customerRating/" + rating + "/" + "/uid");
                        databaseReferenceCustomerInfo.setValue(uid);

                        //Add rating values

                        databaseReferenceRating1 = firebaseDatabaseRating.getReference("Solution/" + intention +"/" + "customerRating/" + rating + "/" + "/impactRating");
                        databaseReferenceRating1.setValue(myRating1);

                        databaseReferenceRating2 = firebaseDatabaseRating.getReference("Solution/" + intention +"/" + "customerRating/" + rating + "/" + "/feasibilityRating");
                        databaseReferenceRating2.setValue(myRating2);

                        //Add comment values

                        databaseReferenceComment = firebaseDatabaseRating.getReference("Solution/" + intention + "/" + "customerRating/" + rating + "/" + "/comment");
                        String comment = tvComment.getText().toString();
                        databaseReferenceComment.setValue(comment);

                        //Add sum of rating values

                        databaseReferenceRatingTotal = firebaseDatabaseRating.getReference("Solution/" + intention + "/" + "customerRating/" + rating + "/" + "/totalRating");
                        databaseReferenceRatingTotal.setValue(myRating1 + myRating2);
                Toast.makeText(RatingActivity.this,"Saved successfully",Toast.LENGTH_SHORT).show();
                    }
        });





        //This is just a fancier way of introducing a button and listener, courtesty of beatrice.
        goBackMain = findViewById(R.id.bRatingBack);

        goBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RatingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
