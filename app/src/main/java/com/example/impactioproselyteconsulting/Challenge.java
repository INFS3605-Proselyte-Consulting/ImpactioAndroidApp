package com.example.impactioproselyteconsulting;

import android.widget.ImageView;

public class Challenge {

    String challengeName;
    String challengeBlurb;
    int challengeImage;

    public Challenge(String challengeName, String challengeBlurb, int challengeImage) {
        this.challengeName = challengeName;
        this.challengeBlurb = challengeBlurb;
        this.challengeImage = challengeImage;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

    public String getChallengeBlurb() {
        return challengeBlurb;
    }

    public void setChallengeBlurb(String challengeBlurb) {
        this.challengeBlurb = challengeBlurb;
    }

    public int getChallengeImage() {
        return challengeImage;
    }

    public void setChallengeImage(int challengeImage) {
        this.challengeImage = challengeImage;
    }
}
