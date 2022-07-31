package com.example.impactioproselyteconsulting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdminChallengeActivity extends AppCompatActivity {
    private static final String TAG = "AdminChallengeActivity";
    private ChallengeAdapter mAdapter;
    Animation animSlideIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_challenge);
        setTitle("All Challenges");

        animSlideIn = android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_in_bottom);



        RecyclerView challengeRecyclerView = findViewById(R.id.adminChallengeRV);
        challengeRecyclerView.setHasFixedSize(true);

        challengeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Pass in the challenges list created, into the recycler view
        ChallengeAdapter.RecyclerViewClickListener listener = new ChallengeAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String challengeName) {
                launchDetailActivity(challengeName);
            }
        };

        // Create an adapter instance and supply the challenges data to be displayed
        mAdapter = new ChallengeAdapter(Challenge.getChallenges(), listener);
        challengeRecyclerView.setAdapter(mAdapter);


        //challengeRecyclerView.setAdapter(new ChallengeAdapter(getApplicationContext(), challenges));
    }

    protected void launchDetailActivity(String challengeName) {
        Intent intent = new Intent(this, ChallengeDetailActivity.class);
        intent.putExtra("Name", challengeName);
        startActivity(intent);

    }

    // Instantiate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_challenge, menu);
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
                mAdapter.sort(ChallengeAdapter.SORT_DESTINATION_NAME_ASCENDING);
                return true;
            case R.id.sortNameDescending:
                // Sort the list by name from Z to A
                Log.d(TAG, "Sort by destination name descending was selected");
                mAdapter.sort(ChallengeAdapter.SORT_DESTINATION_NAME_DESCENDING);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
