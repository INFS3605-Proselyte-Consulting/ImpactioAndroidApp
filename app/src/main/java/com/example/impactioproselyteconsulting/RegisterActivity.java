package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    public static final String INTENT_MESSAGE = "intent_message";
    private EditText et_Email, et_Password, et_Fullname;
    private Button btn_Register;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    CustomerInfo customerInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("CustomerInfo/" + uid);

        // initializing our object
        // class variable.
        customerInfo = new CustomerInfo();

        Toast.makeText(RegisterActivity.this, "You can register now", Toast.LENGTH_LONG).show();

        et_Email = findViewById(R.id.ptEmail);
        et_Password = findViewById(R.id.ptPassword);
        et_Fullname = findViewById(R.id.ptFullname);



        btn_Register = findViewById(R.id.bRegister);
        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEmail = et_Email.getText().toString();
                String textPassword = et_Password.getText().toString();
                String textName = et_Fullname.getText().toString();
                if (TextUtils.isEmpty(textEmail) && TextUtils.isEmpty(textPassword) && TextUtils.isEmpty(textName)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(RegisterActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    registerUser(textName,textEmail,textPassword);
                }
            }
        });

    }
    private void registerUser(String textName, String textEmail, String textPassword){
        customerInfo.setCusName(textName);
        customerInfo.setCusEmail(textEmail);
        customerInfo.setCusPass(textPassword);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(textEmail,textPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"User Registered",Toast.LENGTH_LONG).show();

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.setValue(customerInfo);
                            Toast.makeText(RegisterActivity.this,"data added",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(RegisterActivity.this,"Fail to add data " + error,Toast.LENGTH_LONG).show();
                        }
                    });

                    //Open user Profile
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this,"Registration Failed Lol",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
