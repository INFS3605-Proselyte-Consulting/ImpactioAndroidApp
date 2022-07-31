package com.example.impactioproselyteconsulting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseEditProfile extends AppCompatActivity {

    private TextView tvUid;
    private EditText tvChangeBio, tvChangeName;
    private Button btnChangeBio, btnChangeName;

    //FireBase Database
    FirebaseDatabase firebaseDatabaseBio;

    //Reference for firebase

    DatabaseReference databaseReferenceBio;
    DatabaseReference databaseReferenceName;


    //Create variable customerInfo

    CustomerInfo customerInfoBio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_edit_profile);



        tvChangeName = findViewById(R.id.tvChangeName);;
        btnChangeName = findViewById(R.id.btnChangeName);



        tvChangeBio = findViewById(R.id.tvChangeBio);;
        btnChangeBio = findViewById(R.id.btnChangeBio);



        firebaseDatabaseBio = FirebaseDatabase.getInstance();

        // initializing our object class variable.
        customerInfoBio = new CustomerInfo();

//        //This is for authentication
//        FirebaseAuth auth = FirebaseAuth.getInstance();

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();



        //Create button to submit Bio Change

        btnChangeBio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //      Create string for bio change
                    databaseReferenceBio = firebaseDatabaseBio.getReference("CustomerInfo/" + uid + "/cusBio");
                    String bioChange = tvChangeBio.getText().toString();;
                    databaseReferenceBio.setValue(bioChange);

                }
        });

        //Create button to submit Name Change

        btnChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Create string for bio change
                databaseReferenceName = firebaseDatabaseBio.getReference("CustomerInfo/" + uid + "/cusName");
                String nameChange = tvChangeName.getText().toString();;
                databaseReferenceName.setValue(nameChange);

            }
        });






    }
}