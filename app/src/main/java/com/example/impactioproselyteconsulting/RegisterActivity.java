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
                    registerUser(textName,textEmail,textPassword,textBio,textExpertise,textSDG);
                }
            }
        });

    }
    private void registerUser(String textName, String textEmail, String textPassword,
                              String textBio, String textExpertise, String textSDG){
        customerInfoRegister.setCusName(textName);
        customerInfoRegister.setCusEmail(textEmail);
        customerInfoRegister.setCusPass(textPassword);
        customerInfoRegister.setCusBio(textBio);
        customerInfoRegister.setCusExpertise(textExpertise);
        customerInfoRegister.setCusSDG(textSDG);
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
                            Toast.makeText(RegisterActivity.this,"data added",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(RegisterActivity.this,"Fail to add data " + error,Toast.LENGTH_LONG).show();
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
}
