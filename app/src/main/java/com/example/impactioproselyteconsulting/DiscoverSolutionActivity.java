package com.example.impactioproselyteconsulting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscoverSolutionActivity extends AppCompatActivity {
    private static final String TAG = "DiscoverSolutionActivity";
    private SolutionAdapter mAdapter;
    Animation animSlideIn;

    //FireBase Database
    FirebaseDatabase firebaseDatabase;

    //CustomerInfo Instance

    CustomerInfo customerInfo;

    //DataBase Reference

    DatabaseReference referenceGetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_solution);
        setTitle("Discover Solutions");


        //Recognise the firebase database user
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // initializing our object class variable.
        customerInfo = new CustomerInfo();

        //Reference Database
        firebaseDatabase = FirebaseDatabase.getInstance();
        referenceGetName =  firebaseDatabase.getReference().child("CustomerInfo").child(uid);


        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.menuNav_Discover);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.menuNav_Dashboard:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menuNav_Discover:
                        return true;
                    case R.id.menuNav_Profile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        // This gets the challenge object based on the challenge name passed in
        // from the Intent passed in from the Challenge Detail Activity
        // Then gets the list of Solutions based on the Challenge later
        Intent intent = getIntent();
        Challenge challenge = Challenge.getChallenge(intent.getStringExtra("Name"));


        RecyclerView solutionRecyclerView = findViewById(R.id.SolutionRV);
        solutionRecyclerView.setHasFixedSize(true);

        solutionRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Pass in the solutions list created, into the recycler view
        SolutionAdapter.RecyclerViewClickListener listener = new SolutionAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String solutionName) {
                launchDetailActivity(solutionName);
            }
        };

        // Supply the solution data to be displayed on this page
        loadSolutions(challenge, solutionRecyclerView, listener);


//        // Create an adapter instance and supply the solution data to be displayed
//        mAdapter = new SolutionAdapter(Solution.getSolutions(), listener);
//        solutionRecyclerView.setAdapter(mAdapter);

        //solutionRecyclerView.setAdapter(new SolutionAdapter(getApplicationContext(), solutions));
    }

    protected void launchDetailActivity(String solutionName) {
        Intent intent = new Intent(this, SolutionDetailActivity.class);
        intent.putExtra("Name", solutionName);
        startActivity(intent);
        // Delay to fix bug where data wont display unless lock and unlock screen
        // So just restart the activity after the delay
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //startActivity(intent);;
            }
        }, 2000);

    }

    // Show message when user clicks to like project
//    public void onCustomToggleClick (View view) {
//        Toast.makeText(this, "Favourited!", Toast.LENGTH_SHORT).show();
//    }

    // Instantiate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_solution, menu);
        // Get the search item from the menu
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Call Filterable method from the adapter class to perform filtering
                // Pass the string query into the method
                mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Call Filterable method from the adapter class to perform filtering
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    // React to user interaction with the menu
    @SuppressLint("LongLogTag")
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.sortNameAscending:
                // Sort the list by name from A to Z
                Log.d(TAG, "Sort by destination name ascending was selected");
                mAdapter.sort(SolutionAdapter.SORT_DESTINATION_NAME_ASCENDING);
                return true;
            case R.id.sortNameDescending:
                // Sort the list by name from Z to A
                Log.d(TAG, "Sort by destination name descending was selected");
                mAdapter.sort(SolutionAdapter.SORT_DESTINATION_NAME_DESCENDING);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadSolutions(Challenge challenge, RecyclerView recyclerView, SolutionAdapter.RecyclerViewClickListener listener) {


        // Create an adapter instance and supply the solution data to be displayed
        // Pass in the challenge name from the challenge object and get the list
        //mAdapter = new SolutionAdapter(Solution.getAllSolutionsFromChallenge(challenge.challengeName), listener);
        // Test data for Tags
        ArrayList<String> testTagList = new ArrayList<>();
        testTagList.add("Technology");
        testTagList.add("Responsible Consumption And Production");
        testTagList.add("Maths");
        testTagList.add("Astrology");
        // Should give me in this exact order
        // Wayfairer, Pining For You, Sweater Wearer, Up-Rooted, New Life

        // For the Fashion Challenge it should have: Sweater Wearer
        // For the Innovate to Regenerate it should have: Wayfairer, Pining For You, Up-Rooted, New Life
//        SolutionTagMatchValue matchingSolutions = SolutionTagMatchValue.getSolutionTagMatchValue(testTagList);
//        mAdapter = new SolutionAdapter(matchingSolutions.getSolutionList(), listener);
        //mAdapter = new SolutionAdapter(Solution.getPrioritizedSolutionListFromTagList(testTagList), listener);

        // ***** This is the line to uncomment for hardcoding
        //mAdapter = new SolutionAdapter(Solution.getPrioritizedSolutionListFromTagListAndChallengeName(testTagList, challenge.challengeName), listener);

        // This will test the database:



        // TODO: Instead of passing in testTagList, pass in the user's specific tags from a database
        // Initialize the Firebase stuff again to get the UID and get the aggregated tags

        referenceGetName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Get the cusCombinedTagsString from the db and then convert it to a array list string
                String tempLongString = snapshot.child("cusCombinedTagsString").getValue().toString();
                System.out.println("TempLongString: " + tempLongString);
                String tempString = "Green";
                System.out.println("TempString: " + tempString);
                System.out.println("Sout: " + convertLongStringToList(tempLongString));
                ArrayList<String> userTagsList = convertLongStringToList(tempLongString);

                System.out.println("User Tags: " + userTagsList);

                System.out.println("Challenge Origin: " + challenge.getChallengeName());

                //mAdapter = new SolutionAdapter(Solution.getPrioritizedDBDiscoverSolutionListFromTagListAndChallengeName(userTagsList, challenge.getChallengeName()), listener);
                // Swap with
                mAdapter = new SolutionAdapter(Solution.getPrioritizedSolutionListFromTagListAndChallengeName(userTagsList, challenge.getChallengeName()), listener);
                recyclerView.setAdapter(mAdapter);
                //System.out.println("Final Solution passed in: " + Solution.getPrioritizedDBDiscoverSolutionListFromTagListAndChallengeName(userTagsList, challenge.getChallengeName()));

                customerInfo.setCusCombinedTagList(userTagsList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //mAdapter = new SolutionAdapter(Solution.getPrioritizedDBDiscoverSolutionListFromTagListAndChallengeName(userTagsList, challenge.getChallengeName()), listener);

        recyclerView.setAdapter(mAdapter);
        System.out.println("Success");
    }

    public static ArrayList<String> convertLongStringToList(String longStr) {
        System.out.println("Long String: " + longStr);

        // Make a new empty Array List of strings
        ArrayList<String> resultingStringList;

        String[] list = longStr.split("%");
        System.out.println("List" + list.toString());

        resultingStringList = new ArrayList<>(Arrays.asList(list));

        return resultingStringList;
    }

}