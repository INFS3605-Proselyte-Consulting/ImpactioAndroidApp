package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseEditExpertise extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner ptEditExpertise;
    private Button btnEditExpertise, btnBackExpertise;
    public String valueFromSpinnerExpertise;


    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // Reference for Firebase.
    DatabaseReference databaseReference;

    // Our object class
    CustomerInfo customerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_edit_expertise);

        //Get the uId of user login in
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // below line is used to get the instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // initializing our object class variable.
        customerInfo = new CustomerInfo();

        //button
        btnEditExpertise = findViewById(R.id.btnEditExpertise);
        btnBackExpertise = findViewById(R.id.btnBackExpertise);

        //spinner
        ptEditExpertise = findViewById(R.id.ptEditExpertise);

        //on click spinner
        ptEditExpertise.setOnItemSelectedListener(this);

        //The Strings for all the spinners are stored in the layout/values/spinner_arrays.xml
        String[] allExpertise = getResources().getStringArray(R.array.all_expertise);

        //Gets and sets the spinner values
        ArrayAdapter adapterExpertise = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,allExpertise);
        adapterExpertise.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ptEditExpertise.setAdapter(adapterExpertise);

        //Change Expertise on click

        btnEditExpertise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Create string for expertise change
                databaseReference = firebaseDatabase.getReference("CustomerInfo/" + uid + "/cusExpertise");
                String expertiseChange = valueFromSpinnerExpertise;
                databaseReference.setValue(expertiseChange);
                Toast.makeText(DatabaseEditExpertise.this,"Expertise Changed Successfully",Toast.LENGTH_SHORT).show();

            }
        });

        //Create button to go back to Profile page

        btnBackExpertise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatabaseEditExpertise.this,ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        valueFromSpinnerExpertise = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}