package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.airbnb.lottie.LottieAnimationView;



public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    //initialise our connection to the firebase authentication
    private FirebaseAuth mAuth;

    public EditText mEmail,mPassword;
    public ImageView mLogo;
    Animation animSlideIn, animFloatUp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");


        //Animations for login elements
        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);
        animFloatUp = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.floating_up);
        mEmail = findViewById(R.id.ptLoginEmail);
        mEmail.startAnimation(animSlideIn);
        mPassword = findViewById(R.id.ptLoginPassword);
        mPassword.startAnimation(animSlideIn);
        mLogo = findViewById(R.id.ptLoginImg);
        mLogo.startAnimation(animSlideIn);

        // Get handle to the button elements
        Button btnLogin = findViewById(R.id.bLoginLogin);
        btnLogin.startAnimation(animSlideIn);
        Button btnRegister = findViewById(R.id.bLoginRegister);
        btnRegister.startAnimation(animSlideIn);


        // Launch Register Activity when Register button is clicked
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnRegister clicked launch RegisterActivity");
                launchRegisterActivity("Message from main activity");
            }
        });

        //Fully instantiate the firestore authorization instance.
        mAuth = FirebaseAuth.getInstance();

        // Implement onClickListener for the login button
        //On click listener checks if the fields are filled and then authenticates the user before letting them login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                // Check-if-empty conditional statement.
                if(!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(password)){
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // This will either send them to the topic activity screen OR it will display an error on console. This is also the case for any Toasts below.
                            if(task.isSuccessful()){
                                Log.d(TAG, "Login button is clicked, launch Topic Activity.");
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "ERROR! Your details are invalid! Please try again. ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this,"You must enter the correct login details!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void launchRegisterActivity(String message) {
        // Explicit intent
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        intent.putExtra(RegisterActivity.INTENT_MESSAGE, message);
        // Start the intent
        startActivity(intent);
    }

}
