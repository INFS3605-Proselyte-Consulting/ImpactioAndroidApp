package com.example.impactioproselyteconsulting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ChallengeViewHolder> {

    //Context context;
    List<Challenge> challenges;
    private RecyclerViewClickListener mListener;

    public ChallengeAdapter(List<Challenge> challenges, RecyclerViewClickListener listener) {
        //this.context = context;
        this.challenges = challenges;
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
        Challenge challenge = challenges.get(position);

        holder.challengeNameText.setText(challenge.getChallengeName());
        holder.challengeBlurbText.setText(challenge.getChallengeBlurb());
        holder.challengeImageView.setImageResource(challenge.getChallengeImage());
        holder.itemView.setTag(challenge.getChallengeName());
    }

    @Override
    public int getItemCount() {
        return challenges.size();
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

}
