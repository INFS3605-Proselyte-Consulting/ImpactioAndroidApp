package com.example.impactioproselyteconsulting;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeViewHolder> {

    Context context;
    List<Challenge> challenges;

    public ChallengeAdapter(Context context, List<Challenge> challenges) {
        this.context = context;
        this.challenges = challenges;
    }

    @NonNull
    @Override
    public ChallengeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChallengeViewHolder(LayoutInflater.from(context).inflate(R.layout.challenge_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeViewHolder holder, int position) {
        holder.challengeNameText.setText(challenges.get(position).getChallengeName());
        holder.challengeBlurbText.setText(challenges.get(position).getChallengeBlurb());
        holder.challengeImageView.setImageResource(challenges.get(position).getChallengeImage());
    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }
}
