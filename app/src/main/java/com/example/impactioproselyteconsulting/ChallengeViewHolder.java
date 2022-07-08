package com.example.impactioproselyteconsulting;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChallengeViewHolder extends RecyclerView.ViewHolder {

    ImageView challengeImageView;
    TextView challengeNameText, challengeBlurbText;

    public ChallengeViewHolder(@NonNull View itemView) {
        super(itemView);
        challengeImageView = itemView.findViewById(R.id.ChallengeImgView);
        challengeNameText = itemView.findViewById(R.id.ChallengeNameTxt);
        challengeBlurbText = itemView.findViewById(R.id.ChallengeBlurbTxt);
    }
}
