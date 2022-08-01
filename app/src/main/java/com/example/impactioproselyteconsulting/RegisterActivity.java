package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = "RegisterActivity";
    public static final String INTENT_MESSAGE = "intent_message";
    private EditText et_Email, et_Password, et_Fullname,et_Biography;
    private Spinner sp_prefExpertise, sp_prefSDG;
    private Button btn_Register;
    public String valueFromSpinnerExpertise,valueFromSpinnerSDG;
    Animation animSlideIn, animFloatUp;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabaseRegister;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReferenceRegister;
    DatabaseReference databaseReferenceUserSolutionsOne;
    DatabaseReference databaseReferenceUserSolutionsTwo;
    DatabaseReference databaseReferenceUserSolutionsThree;
    DatabaseReference databaseReferenceUserSolutionsFour;

    // creating a variable for
    // our object class
    CustomerInfo customerInfoRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        // below line is used to get the instance of our FIrebase database.
        firebaseDatabaseRegister = FirebaseDatabase.getInstance();
        // initializing our object class variable.
        customerInfoRegister = new CustomerInfo();

        //Toasts just give a message on the screen
        Toast.makeText(RegisterActivity.this, "You can register now", Toast.LENGTH_LONG).show();


        //Animations
        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        animFloatUp = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.floating_up);

        //Edit Texts
        et_Email = findViewById(R.id.ptLoginEmail);
        et_Email.startAnimation(animSlideIn);
        et_Password = findViewById(R.id.ptPassword);
        et_Password.startAnimation(animSlideIn);
        et_Fullname = findViewById(R.id.ptFullname);
        et_Fullname.startAnimation(animSlideIn);
        et_Biography = findViewById(R.id.ptBiography);
        et_Biography.startAnimation(animSlideIn);
        //These are for the spinners
        sp_prefSDG = findViewById(R.id.ptSDGS);
        sp_prefSDG.startAnimation(animSlideIn);
        sp_prefExpertise = findViewById(R.id.ptExpertise);
        sp_prefExpertise.startAnimation(animSlideIn);
        //This determines something changed
        sp_prefSDG.setOnItemSelectedListener(this);
        sp_prefExpertise.setOnItemSelectedListener(this);

        //The Strings for all the spinners are stored in the layout/values/spinner_arrays.xml
        String[] allExpertise = getResources().getStringArray(R.array.all_expertise);
        String[] allSDG = getResources().getStringArray(R.array.all_sdg);

        //Gets and sets the spinner values
        ArrayAdapter adapterExpertise = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,allExpertise);
        adapterExpertise.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_prefExpertise.setAdapter(adapterExpertise);

        ArrayAdapter adapterSDG = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,allSDG);
        adapterSDG.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_prefSDG.setAdapter(adapterSDG);

        btn_Register = findViewById(R.id.bRegister);
        btn_Register.startAnimation(animSlideIn);

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEmail = et_Email.getText().toString();
                String textPassword = et_Password.getText().toString();
                String textName = et_Fullname.getText().toString();
                String textBio = et_Biography.getText().toString();
                String textSDG = valueFromSpinnerSDG;
                String textExpertise = valueFromSpinnerExpertise;
                if (TextUtils.isEmpty(textEmail) && TextUtils.isEmpty(textPassword) && TextUtils.isEmpty(textName)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(RegisterActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.

                    // Sean: When the user registers for a new account, an initial combined Tag will be
                    // created based on the Expertise and SDG
                    // This should go in the database

                    // Sean: but first, append the strings to make a combined tag string
                    ArrayList<String> combinedTagsList = new ArrayList<>();
                    combinedTagsList.add(textSDG);
                    combinedTagsList.add(textExpertise);
                    String userCombinedTagsString = getCombinedString(combinedTagsList);

                    // Write a method to return a string of words separated by a % symbol


                    // Now add the data to the db
                    registerUser(textName,textEmail,textPassword,textBio,textExpertise,textSDG, userCombinedTagsString);
                }



            }
        });

    }
    private void registerUser(String textName, String textEmail, String textPassword,
                              String textBio, String textExpertise, String textSDG, String userCombinedTagsString){
        customerInfoRegister.setCusName(textName);
        customerInfoRegister.setCusEmail(textEmail);
        customerInfoRegister.setCusPass(textPassword);
        customerInfoRegister.setCusBio(textBio);
        customerInfoRegister.setCusExpertise(textExpertise);
        customerInfoRegister.setCusSDG(textSDG);
        customerInfoRegister.setCusCombinedTagsString(userCombinedTagsString);
        //This is for authentication
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(textEmail,textPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //The user's unique ID generated upon registration
                    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

                    // below line is used to get reference for our database.
                    databaseReferenceRegister = firebaseDatabaseRegister.getReference("CustomerInfo/" + uid);


                    Toast.makeText(RegisterActivity.this,"User Registered",Toast.LENGTH_LONG).show();

                    databaseReferenceRegister.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReferenceRegister.setValue(customerInfoRegister);
                            // Sean: Try to add all the Solutions here:
                            // Loop through all the solutions in solution db
//                            for (Solution solution : Solution.solutionsAllDBList) {
//                                // and get the names
//                                // And add them as nodes
//                                databaseReferenceRegister.child("cusSolutions").child(solution.getSolutionName()).setValue(solution.getSolutionName());
//                            }

                            Toast.makeText(RegisterActivity.this,"data added",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(RegisterActivity.this,"Fail to add data " + error,Toast.LENGTH_LONG).show();
                        }
                    });

                    databaseReferenceUserSolutionsOne = firebaseDatabaseRegister.getReference("CustomerInfo/" + uid);

                    databaseReferenceUserSolutionsOne.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // Sean: Try to add all the Solutions here:
                            // Loop through all the solutions in solution db // doesnt seem to work
                            // so just hardcode it in
                            // Make an array list
//                            ArrayList<String> allSolutions = new ArrayList<>();
//                            allSolutions.add("Bewildered");
//                            allSolutions.add("Blazing Beauty");
//                            allSolutions.add("Contemporary Clothing");
//                            allSolutions.add("Decarbonated Style");
//                            allSolutions.add("Faster Fashion");
//                            allSolutions.add("Foundation");
//                            allSolutions.add("Metropolitic");
//                            allSolutions.add("New Life");
//                            allSolutions.add("Pining For You");
//                            allSolutions.add("Regrowth");
//                            allSolutions.add("Sweater Wearer");
//                            allSolutions.add("United Future");
//                            allSolutions.add("Up-Rooted");
//                            allSolutions.add("Voice Of Nature");
//                            allSolutions.add("Wayfairer");
//                            allSolutions.add("Wildlife First");
//
//                            // Now loop through
//                            for (String name : allSolutions) {
//                                databaseReferenceUserSolutions.child("cusSolutions").child(name).child("solutionName").setValue(name);
//                                databaseReferenceUserSolutions.child("cusSolutions").child(name).child("solutionStatus").setValue("discover");
//                            }
//                            databaseReferenceUserSolutions.child("cusSolutions").child("solnName1").child("solutionName").setValue("solnName1");
//                            databaseReferenceUserSolutions.child("cusSolutions").child("solnName1").child("solutionStatus").setValue("discover");
//                            for (Solution solution : Solution.solutionsAllDBList) {
//                                // and get the names
//                                // And add them as nodes
//                                databaseReferenceUserSolutions.child("cusSolutions").child(solution.getSolutionName()).setValue(solution.getSolutionName());
//                            }

                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Bewildered").child("solutionName").setValue("Bewildered");
                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Bewildered").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Blazing Beauty").child("solutionName").setValue("Blazing Beauty");
                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Blazing Beauty").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Contemporary Clothing").child("solutionName").setValue("Contemporary Clothing");
                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Contemporary Clothing").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Decarbonated Style").child("solutionName").setValue("Decarbonated Style");
                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Decarbonated Style").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Faster Fashion").child("solutionName").setValue("Faster Fashion");
                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Faster Fashion").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Foundation").child("solutionName").setValue("Foundation");
                            databaseReferenceUserSolutionsOne.child("cusSolutions").child("Foundation").child("solutionStatus").setValue("discover");

                            Toast.makeText(RegisterActivity.this,"Solutions generated 1",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    databaseReferenceUserSolutionsTwo = firebaseDatabaseRegister.getReference("CustomerInfo/" + uid);

                    databaseReferenceUserSolutionsTwo.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("Metropolitic").child("solutionName").setValue("Metropolitic");
                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("Metropolitic").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("New Life").child("solutionName").setValue("New Life");
                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("New Life").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("Pining For You").child("solutionName").setValue("Pining For You");
                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("Pining For You").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("Regrowth").child("solutionName").setValue("Regrowth");
                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("Regrowth").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("Sweater Wearer").child("solutionName").setValue("Sweater Wearer");
                            databaseReferenceUserSolutionsTwo.child("cusSolutions").child("Sweater Wearer").child("solutionStatus").setValue("discover");

                            Toast.makeText(RegisterActivity.this,"Solutions generated 2",Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    databaseReferenceUserSolutionsThree = firebaseDatabaseRegister.getReference("CustomerInfo/" + uid);

                    databaseReferenceUserSolutionsThree.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReferenceUserSolutionsThree.child("cusSolutions").child("United Future").child("solutionName").setValue("United Future");
                            databaseReferenceUserSolutionsThree.child("cusSolutions").child("United Future").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsThree.child("cusSolutions").child("Up-Rooted").child("solutionName").setValue("Up-Rooted");
                            databaseReferenceUserSolutionsThree.child("cusSolutions").child("Up-Rooted").child("solutionStatus").setValue("discover");

                            Toast.makeText(RegisterActivity.this,"Solutions generated 3",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                    databaseReferenceUserSolutionsFour = firebaseDatabaseRegister.getReference("CustomerInfo/" + uid);

                    databaseReferenceUserSolutionsFour.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReferenceUserSolutionsFour.child("cusSolutions").child("Voice Of Nature").child("solutionName").setValue("Voice Of Nature");
                            databaseReferenceUserSolutionsFour.child("cusSolutions").child("Voice Of Nature").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsFour.child("cusSolutions").child("Wayfairer").child("solutionName").setValue("Wayfairer");
                            databaseReferenceUserSolutionsFour.child("cusSolutions").child("Wayfairer").child("solutionStatus").setValue("discover");

                            databaseReferenceUserSolutionsFour.child("cusSolutions").child("Wildlife First").child("solutionName").setValue("Wildlife First");
                            databaseReferenceUserSolutionsFour.child("cusSolutions").child("Wildlife First").child("solutionStatus").setValue("discover");
                            Toast.makeText(RegisterActivity.this,"Solutions generated 4",Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                    //Open user Profile
                    Intent intent = new Intent(RegisterActivity.this,ProfileActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this,"Registration Failed Lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()){
            case R.id.ptExpertise:
            {
                valueFromSpinnerExpertise = adapterView.getItemAtPosition(i).toString();
            }
            case R.id.ptSDGS:
            {
                valueFromSpinnerSDG = adapterView.getItemAtPosition(i).toString();
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // Sean: Write a method to return a string of words separated by a % symbol

    public static String getCombinedString(ArrayList<String> inputList) {
        return TextUtils.join("%", inputList);
    }
}
