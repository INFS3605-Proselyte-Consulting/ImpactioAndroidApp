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

public class DatabaseEditSDG extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner ptEditSDG;
    private Button btnEditSDG, btnBackSDG;
    public String valueFromSpinnerSDG;


    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // Reference for Firebase.
    DatabaseReference databaseReference;

    // Our object class
    CustomerInfo customerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_edit_sdg);

        //Get the uId of user login in
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // below line is used to get the instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // initializing our object class variable.
        customerInfo = new CustomerInfo();

        //button
        btnEditSDG = findViewById(R.id.btnEditSDG);
        btnBackSDG = findViewById(R.id.btnBackSDG);

        //spinner
        ptEditSDG = findViewById(R.id.ptEditSDG);

        //on click spinner
        ptEditSDG.setOnItemSelectedListener(this);

        //The Strings for all the spinners are stored in the layout/values/spinner_arrays.xml
        String[] allSdg = getResources().getStringArray(R.array.all_sdg);

        //Gets and sets the spinner values
        ArrayAdapter adapterSDG = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,allSdg);
        adapterSDG.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ptEditSDG.setAdapter(adapterSDG);

        //Change Expertise on click

        btnEditSDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Create string for expertise change
                databaseReference = firebaseDatabase.getReference("CustomerInfo/" + uid + "/cusSDG");
                String sdgChange = valueFromSpinnerSDG;
                databaseReference.setValue(sdgChange);
                Toast.makeText(DatabaseEditSDG.this,"SDG Changed Successfully",Toast.LENGTH_SHORT).show();


            }
        });

        btnBackSDG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatabaseEditSDG.this,ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        valueFromSpinnerSDG = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}