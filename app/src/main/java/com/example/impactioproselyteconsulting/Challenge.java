package com.example.impactioproselyteconsulting;

import java.util.ArrayList;

public class Challenge {

    String challengeName;
    String challengeBlurb;
    String challengeDesc;
    int challengeImage;

    public Challenge(String challengeName, String challengeBlurb, String challengeDesc, int challengeImage) {
        this.challengeName = challengeName;
        this.challengeBlurb = challengeBlurb;
        this.challengeImage = challengeImage;
        this.challengeDesc = challengeDesc;
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

    public String getChallengeDesc() {
        return challengeDesc;
    }

    public void setChallengeDesc(String challengeDesc) {
        this.challengeDesc = challengeDesc;
    }

    public int getChallengeImage() {
        return challengeImage;
    }

    public void setChallengeImage(int challengeImage) {
        this.challengeImage = challengeImage;
    }


    public static ArrayList<Challenge> getChallenges() {
        // Create a list of challenges here
        ArrayList<Challenge> challenges = new ArrayList<>();
        challenges.add(new Challenge("The Great Fashion Decarbonisation",
                "Do you have expertise, networks or ideas that could transform fashion to a sustainable industry?",
                "Accelerating sustainable and low carbon fashion solutions is essential to help combat climate change and encourage sustainable behaviour. The global fashion industry is a multi-trillion dollar industry, producing over 100 billion garments annually. Given its size and nature, the industry faces a number of social and environmental challenges. Join us as we work with the fashion and textiles sectors to reduce carbon emissions.",
                R.drawable.fashion));
        challenges.add(new Challenge("Innovate to Regenerate",
                "Innovate to Regenerate seeks to support and amplify community-led regeneration. We’re working together to make sure communities are supported and have the capability and agency to lead their own local regeneration",
                "If you have ideas, expertise and support to empower Australian communities, drive regeneration and create a healthy future for people and nature, get involved!",
                R.drawable.regenerate));
        challenges.add(new Challenge("Cities of Tomorrow",
                "How can we decarbonise materials used in building, construction and infrastructure?",
                "Disrupting the built environment and surrounding infrastructure through impactful and equitable ventures.",
                R.drawable.cities));
        challenges.add(new Challenge("Bushfire Regeneration Challenge",
                "Delivering innovative solutions for bushfire recovery and resilience.",
                "In 2019-20 Australia experienced the most catastrophic bushfire season in the country’s history, and the impacts will be felt for years to come.\n" +
                        "\n" +
                        "Up to 19 million hectares were burnt, with 12.6 million hectares primarily forest and bushland. 1 billion animals perished, 34 human lives were lost and around 2,700 homes destroyed.\n" +
                        "\n" +
                        "Now, we aim to uncover innovative nature-based solutions to enhance the recovery, regeneration and resilience of landscapes and threatened species.\n" +
                        "\n" +
                        "We look for solutions that enable and incentivise landholders and communities to own and drive regeneration outcomes. Solutions should cover at least one of these areas: fire risk management, regenerative land use, species recovery and building ecological, economic and social resilience to climate change.",
                R.drawable.bushfire));
        challenges.add(new Challenge("Sustainability Advantage Impact Challenge",
                "We are seeking projects that offer smarter, faster ways to make real progress on the United Nations Sustainable Development Goals and transform the way we do business in NSW.",
                "Our mission is to solve wicked sustainability problems to: \n" +
                        "\n" +
                        "\t• Advance the circular economy\n" +
                        "\t• Speed transition to net zero\n" +
                        "\t• Benefit nature",
                R.drawable.sustainability));
        challenges.add(new Challenge("Innovate for Wildlife & People Challenge",
                "The ‘Innovate for Wildlife and People: Incentivising and rewarding community-based wildlife conservation’ Challenge focuses on one of the most pressing topics in conservation today.",
                "There is an increasing realization that wildlife conservation needs to be inclusive. For communities to choose wildlife management on their land, they need to be actively involved, and directly or indirectly obtain social, economic and/or cultural benefits from that wildlife. A need exists for innovative, integrated yet practical approaches and solutions with potential to go to scale.\n" +
                        "\n" +
                        " The challenge: How can benefits for local people be increased, strengthened, diversified, and have longer term economic viability to incentivise and reward wildlife conservation?\n" +
                        "\n" +
                        " The experiment involved fifty-five highly skilled subject matter experts from around the world working together virtually to co-curate the portfolio and ensuring the projects were the best they could be before being presented for funding.",
                R.drawable.wildlife));
        return challenges;
    }

    // To-do: Create a method to return the correct challenge from the test data ArrayList based on a received String value
    public static Challenge getChallenge(String name) {
        for (Challenge challenge : getChallenges()) {
            if (challenge.getChallengeName().equals(name)) {
                return challenge;
            }
        }
        return null;
    }

}
