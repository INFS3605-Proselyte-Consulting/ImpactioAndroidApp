package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseEditExpertise extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner ptEditExpertise;
    private Button btnEditExpertise;
    public String valueFromSpinnerExpertise;


    // Firebase Database.
    FirebaseDatabase firebaseDatabaseExpertise;

    // Reference for Firebase.
    DatabaseReference databaseReferenceExpertise;

    // Our object class
    CustomerInfo customerInfoExpertise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_edit_expertise);

        //Get the uId of user login in
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // below line is used to get the instance of our FIrebase database.
        firebaseDatabaseExpertise = FirebaseDatabase.getInstance();

        // initializing our object class variable.
        customerInfoExpertise = new CustomerInfo();

        //button
        btnEditExpertise = findViewById(R.id.btnEditExpertise);

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
                databaseReferenceExpertise = firebaseDatabaseExpertise.getReference("CustomerInfo/" + uid + "/cusExpertise");
                String expertiseChange = valueFromSpinnerExpertise;
                databaseReferenceExpertise.setValue(expertiseChange);

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