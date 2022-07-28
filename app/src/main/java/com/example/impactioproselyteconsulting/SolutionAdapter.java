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

public class SolutionAdapter extends RecyclerView.Adapter<SolutionAdapter.SolutionViewHolder> implements Filterable {
    private static final String TAG = "SolutionAdapterActivity";
    //Context context;
    List<Solution> mSolutions, mSolutionsFiltered;
    private RecyclerViewClickListener mListener;

    // Constants for sort method
    public static final int SORT_DESTINATION_NAME_ASCENDING = 1;
    public static final int SORT_DESTINATION_NAME_DESCENDING = 2;

    public SolutionAdapter(List<Solution> solutions, RecyclerViewClickListener listener) {
        //this.context = context;
        mSolutions = solutions;
        mSolutionsFiltered = solutions;
        mListener = listener;
    }

    @NonNull
    @Override
    public SolutionAdapter.SolutionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.solution_view, parent, false);
        return new SolutionViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SolutionAdapter.SolutionViewHolder holder, int position) {
        Solution solution = mSolutionsFiltered.get(position);

        holder.solutionNameText.setText(solution.getSolutionName());
        holder.solutionBlurbText.setText(solution.getSolutionBlurb());
        holder.solutionImageView.setImageResource(solution.getSolutionImage());
        holder.itemView.setTag(solution.getSolutionName());
    }

    @Override
    public int getItemCount() {
        return mSolutionsFiltered.size();
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
                    mSolutionsFiltered = mSolutions;
                } else {
                    ArrayList<Solution> filteredList = new ArrayList<>();
                    // Go through the entire list of destinations
                    for (Solution solution: mSolutions){
                        // Convert destination name and charString to lower case so the search function is not case sensitive
                        if(solution.getSolutionName().toLowerCase().contains(charString.toLowerCase())){
                            // If destination name contains charString, add the destination to filteredList
                            filteredList.add(solution);
                        }
                    }
                    // Set the filtered destination into filtered results
                    mSolutionsFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mSolutionsFiltered;
                return filterResults;
            }

            // Display the filtered results
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mSolutionsFiltered = (ArrayList<Solution>) filterResults.values;
                // Notify the adapter about the changes
                notifyDataSetChanged();
            }
        };
    }

    //ClickListener interface
    public interface RecyclerViewClickListener {
        void onClick(View view, String solutionName);
    }

    //Extend the signature of SolutionViewHolder to implement a click listener
    public static class SolutionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView solutionImageView;
        TextView solutionNameText, solutionBlurbText;
        public RecyclerViewClickListener mListener;

        // Constructor method for SolutionViewHolder class
        public SolutionViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            solutionImageView = itemView.findViewById(R.id.SolutionImgViewDetail);
            solutionNameText = itemView.findViewById(R.id.SolutionNameTxtDetail);
            solutionBlurbText = itemView.findViewById(R.id.SolutionBlurbTxtDetail);
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
        if(mSolutionsFiltered.size() > 0){
            // Pass the list to Collection.sort()
            Collections.sort(mSolutionsFiltered, new Comparator<Solution>() {
                @Override
                public int compare(Solution s1, Solution s2) {
                    if(sortMethod == SORT_DESTINATION_NAME_ASCENDING){
                        // Sort the list by Solution name in ascending order (from A to Z)
                        // Compare s1 with s2
                        return s1.getSolutionName().compareTo(s2.getSolutionName());
                    } else if(sortMethod == SORT_DESTINATION_NAME_DESCENDING) {
                        // Sort the list by Solution name in descending order (from Z to A)
                        // Compare s2 with s1
                        return s2.getSolutionName().compareTo(s1.getSolutionName());
                    }
                    return 0;
                }
            });
        }
        // Notify the adapter on changes to the list
        notifyDataSetChanged();
    }
}
