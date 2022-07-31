package com.example.impactioproselyteconsulting;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ChallengeViewHolder> implements Filterable {
    private static final String TAG = "ChallengeAdapterActivity";
    //Context context;
    List<Challenge> mChallenges, mChallengesFiltered;
    private RecyclerViewClickListener mListener;

    // Constants for sort method
    public static final int SORT_DESTINATION_NAME_ASCENDING = 1;
    public static final int SORT_DESTINATION_NAME_DESCENDING = 2;

    public ChallengeAdapter(List<Challenge> challenges, RecyclerViewClickListener listener) {
        //this.context = context;
        mChallenges = challenges;
        mChallengesFiltered = challenges;
        mListener = listener;
    }


    @NonNull
    @Override
    public ChallengeAdapter.ChallengeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.challenge_view, parent, false);
        return new ChallengeViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeAdapter.ChallengeViewHolder holder, int position) {
        Challenge challenge = mChallengesFiltered.get(position);

        holder.challengeNameText.setText(challenge.getChallengeName());
        holder.challengeBlurbText.setText(challenge.getChallengeBlurb());
        holder.challengeImageView.setImageResource(challenge.getChallengeImage());
        holder.itemView.setTag(challenge.getChallengeName());
    }

    @Override
    public int getItemCount() {
        return mChallengesFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            // Perform the search to get filtered results and send to publishResults method
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                // Compare charString to charSequence
                String charString = charSequence.toString();
                // if search bar is empty
                if (charString.isEmpty()){
                    mChallengesFiltered = mChallenges;
                } else {
                    ArrayList<Challenge> filteredList = new ArrayList<>();
                    // Go through the entire list of destinations
                    for (Challenge challenge: mChallenges){
                        // Convert destination name and charString to lower case so the search function is not case sensitive
                        if(challenge.getChallengeName().toLowerCase().contains(charString.toLowerCase())){
                            // If destination name contains charString, add the destination to filteredList
                            filteredList.add(challenge);
                        }
                    }
                    // Set the filtered destination into filtered results
                    mChallengesFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mChallengesFiltered;
                return filterResults;
            }

            // Display the filtered results
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mChallengesFiltered = (ArrayList<Challenge>) filterResults.values;
                // Notify the adapter about the changes
                notifyDataSetChanged();
            }
        };
    }

    //ClickListener interface
    public interface RecyclerViewClickListener {
        void onClick(View view, String challengeName);
    }

    //Extend the signature of ChallengeViewHolder to implement a click listener
    public static class ChallengeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView challengeImageView;
        TextView challengeNameText, challengeBlurbText;
        public RecyclerViewClickListener mListener;

        // Constructor method for ChallengeViewHolder class
        public ChallengeViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            challengeImageView = itemView.findViewById(R.id.ChallengeImgViewDetail);
            challengeNameText = itemView.findViewById(R.id.ChallengeNameTxtDetail);
            challengeBlurbText = itemView.findViewById(R.id.ChallengeBlurbTxtDetail);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, (String) view.getTag());
        }
    }

    // Use the Java Collections.sort() and Comparator methods to sort the list
    public void sort(final int sortMethod){
        // Only sort the list if the list has 1 or more items
        if(mChallengesFiltered.size() > 0){
            // Pass the list to Collection.sort()
            Collections.sort(mChallengesFiltered, new Comparator<Challenge>() {
                @Override
                public int compare(Challenge c1, Challenge c2) {
                    if(sortMethod == SORT_DESTINATION_NAME_ASCENDING){
                        // Sort the list by Challenge name in ascending order (from A to Z)
                        // Compare c1 with c2
                        return c1.getChallengeName().compareTo(c2.getChallengeName());
                    } else if(sortMethod == SORT_DESTINATION_NAME_DESCENDING) {
                        // Sort the list by Challenge name in descending order (from Z to A)
                        // Compare c2 with c1
                        return c2.getChallengeName().compareTo(c1.getChallengeName());
                    }
                    return 0;
                }
            });
        }
        // Notify the adapter on changes to the list
        notifyDataSetChanged();
    }
}
