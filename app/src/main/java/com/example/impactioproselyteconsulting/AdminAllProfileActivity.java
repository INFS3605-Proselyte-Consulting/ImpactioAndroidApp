package com.example.impactioproselyteconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class AdminAllProfileActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    public String cusName, cusPass, cusEmail, cusBio, cusExpertise, cusSDG;
    Animation animSlideIn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        if(!(uid.equals("On3A3lyM8gh9XfDSjP5iypbVcwp1"))){
            setContentView(R.layout.activity_profile);
            startActivity(new Intent(AdminAllProfileActivity.this,ProfileActivity.class));
            finish();
        }
        setContentView(R.layout.activity_admin_all_profile);
        setTitle("All Profiles");

//        databaseReference = FirebaseDatabase.getInstance().getReference("CustomerInfo");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("CustomerInfo");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    listView = (ListView)findViewById(R.id.profilesListView);
                    ArrayAdapter<String> arr;
                    arr = new ArrayAdapter<String>(
                            AdminAllProfileActivity.this,
                            com.airbnb.lottie.R.layout.support_simple_spinner_dropdown_item,
                            Collections.singletonList(ds.getValue().toString()));
                    listView.setAdapter(arr);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(AdminAllProfileActivity.this,
//                android.R.layout.simple_list_item_1,arrayList);
//
//        profileListView = (ListView) findViewById(R.id.adminAllProfileRV);
//        profileListView.setAdapter(myArrayAdapter);

//        databaseReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                final String allInfo = snapshot.getValue(CustomerInfo.class).toString();
//                //cusName(0), cusEmail(1), cusPass, cusBio, cusExpertise, cusSDG(5)
//                List<String> allInfoList = new ArrayList<String>(Arrays.asList(allInfo.split(",")));
//
//                cusName = allInfoList.get(0);
//                cusEmail = allInfoList.get(1);
//                cusPass = allInfoList.get(2);
//                cusBio = allInfoList.get(3);
//                cusExpertise = allInfoList.get(4);
//                cusSDG = allInfoList.get(5);
//
//                arrayList.add(cusName + "|" + cusEmail+ "|" + cusPass);
//

                //arrayAdapter.notifyDataSetChanged();

//                String name = snapshot.child("cusName").getValue().toString();
//                String email = snapshot.child("cusEmail").getValue().toString();
//                String pass = snapshot.child("cusPass").getValue().toString();
//                String bio = snapshot.child("cusBio").getValue().toString();
//                String expertise = snapshot.child("cusExpertise").getValue().toString();
//                String sdg = snapshot.child("cusSDG").getValue().toString();

//                arrayList.add(name);
//                arrayAdapter.notifyDataSetChanged();

//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        cusName = allInfoList.get(0);
//                        cusEmail = allInfoList.get(1);
//                        cusPass = allInfoList.get(2);
//                        cusBio = allInfoList.get(3);
//                        cusExpertise = allInfoList.get(4);
//                        cusSDG = allInfoList.get(5);
//
//                        AlertDialog.Builder alertDialogueBuilder = new AlertDialog.Builder(AdminAllProfileActivity.this)
//                                .setCancelable(true)
//                                .setTitle("Customer Details")
//                                .setMessage(allInfo);
//                        AlertDialog alertDialog = alertDialogueBuilder.show();
//
//                    }
//                });
//            }

//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//
//        });

    }
}
