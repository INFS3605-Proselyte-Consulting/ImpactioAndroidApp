package com.example.impactioproselyteconsulting;

import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;

public class Solution {

    String solutionName;
    String solutionBlurb;
    String solutionDesc;
    String solutionStatus;
    String solutionChallengeOrigin;
    // TODO
    // Add tags and SDGs
    ArrayList<String> solutionTagsList = new ArrayList<String>();
    int solutionImage;

    public Solution() {
        // Empty constructor
        solutionName = "solutionName";
        solutionBlurb = "solutionBlurb";
        solutionDesc = "solutionDesc";
        solutionStatus = "solutionStatus";
        solutionChallengeOrigin = "solutionChallengeOrigin";
        solutionTagsList.add("solution Tag 1");
        solutionTagsList.add("solution Tag 2");
        solutionTagsList.add("solution Tag 3");
        solutionImage = R.drawable.sweater;

    }

    public Solution(String solutionName, String solutionBlurb, String solutionDesc, String solutionStatus,String solutionChallengeOrigin, ArrayList<String> solutionTagsList, int solutionImage) {
        this.solutionName = solutionName;
        this.solutionBlurb = solutionBlurb;
        this.solutionDesc = solutionDesc;
        this.solutionStatus = solutionStatus;
        this.solutionChallengeOrigin = solutionChallengeOrigin;
        this.solutionTagsList = solutionTagsList;
        this.solutionImage = solutionImage;

    }

    public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

    public String getSolutionBlurb() {
        return solutionBlurb;
    }

    public void setSolutionBlurb(String solutionBlurb) {
        this.solutionBlurb = solutionBlurb;
    }

    public String getSolutionDesc() {
        return solutionDesc;
    }

    public void setSolutionDesc(String solutionDesc) {
        this.solutionDesc = solutionDesc;
    }

    public int getSolutionImage() {
        return solutionImage;
    }

    public void setSolutionImage(int solutionImage) {
        this.solutionImage = solutionImage;
    }

    public String getSolutionStatus() {
        return solutionStatus;
    }

    public void setSolutionStatus(String solutionStatus) {
        this.solutionStatus = solutionStatus;
    }

    public String getSolutionChallengeOrigin() {
        return solutionChallengeOrigin;
    }

    public void setSolutionChallengeOrigin(String solutionChallengeOrigin) {
        this.solutionChallengeOrigin = solutionChallengeOrigin;
    }

    public ArrayList<String> getSolutionTagsList() {
        return solutionTagsList;
    }

    public void setSolutionTagsList(ArrayList<String> solutionTagsList) {
        this.solutionTagsList = solutionTagsList;
    }

    // DONE: Method that takes in a string and adds it to the list of tags
    public void addToSolutionTagsList(String solutionTag) {
        this.solutionTagsList.add(solutionTag);
    }

    // This is the default function to get ALL the Solutions
    public static ArrayList<Solution> getSolutions() {
        // Create a list of solutions here
        ArrayList<Solution> solutions = new ArrayList<>();

        // Create the test Data Tags Lists here
        ArrayList<String> testTagListYesOne = new ArrayList<>();
        testTagListYesOne.add("Yes");
        ArrayList<String> testTagListYesTwo = new ArrayList<>();
        testTagListYesTwo.add("Not");
        testTagListYesTwo.add("Yes");
        ArrayList<String> testTagListNone = new ArrayList<>();
        testTagListNone.add("None");
        ArrayList<String> testTagListNo = new ArrayList<>();
        testTagListNo.add("No");

        // Add the test data Solutions to the list
        solutions.add(new Solution("Contemporary Clothing",
                "Made by contemporaries for our changing times",
                "Second-hand clothing shops help reduce textiles waste to landfill. Australia has 3,000 charity and social enterprise retailers that support 5,000 jobs, 33,000 volunteers, and 10,000 charity collection bins. A range of innovative products were displayed revealing the latest developments in clothing textile waste recycling and highlighting both the challenges and opportunities of addressing textile waste here in Australia.\n",
                "To-Do",
                "The Great Fashion Decarbonisation",
                testTagListYesTwo,
                R.drawable.contemporary));
        solutions.add(new Solution("Decarbonated Style",
                "A holistic overview of decarbonisation actioning",
                "Despite efforts to reduce emissions, the industry is on a trajectory that will exceed the 1.5-degree pathway to mitigate climate change set out by the Intergovernmental Panel on Climate Change (IPCC) and ratified in the 2015 Paris agreement. By 2023, 20% of major apparel companies by revenue committed to net zero through membership in the Fashion Charter\n",
                "To-Do",
                "The Great Fashion Decarbonisation",
                testTagListYesOne,
                R.drawable.decarbstyle));
        solutions.add(new Solution("Sweater Wearer",
                "A change of wardrobe for the fashion industry",
                "The Sweater Wearer Initiative works on the basis of bringing high quality textiles to designers that can make the most of what they're given. Each time a garment is washed as part of daily use, it releases thousands of tiny fibres that find their way through wastewater to the oceans. Although scientists have long noted microfibre or microplastics pollution, it is only now attracting wider public attention." +
                        "\n" +
                        "100 billion garments are produced every year, with around a third of them ending up in landfills within the first initial year of their purchase.The textile industry is estimated to emit 8% of carbon emissions, and 20% of the world's waste water.",
                "In Progress",
                "The Great Fashion Decarbonisation",
                testTagListNone,
                R.drawable.sweater));
        solutions.add(new Solution("Faster Fashion",
                "Agile as they come, our solution is speed",
                "Here's the problem with fast fashion.\n" +
                        "\n" +
                        "Up until the mid-twentieth century, the fashion industry ran on four seasons a year: fall, winter, spring, and summer. Designers would work many months ahead to plan for each season and predict the styles they believed customers would want. This method, although more methodical than fashion today, took away agency from the wearers. Before fashion became accessible to the masses, it was prescribed to high society, and there were rules to be followed.",
                "Done",
                "The Great Fashion Decarbonisation",
                testTagListYesTwo,
                R.drawable.fasterfashion));
        solutions.add(new Solution("Wayfairer",
                "Building community wealth through tourism",
                "\"Every year in Australia, over $150m is paid to international accommodation booking platforms, with the vast majority of that money disappearing offshore. We have seen the impact of this model across Australia, with the hollowing out of communities, increasing unaffordability of housing, and the commodification of tourism that has become insensitive to its local context.\n" +
                        "\n" +
                        "Wayfairer disrupts this extractive model. It enables booking revenue to stay in Australia - creating jobs, catalysing investment, and promoting tourism destinations through sustainable, locally-led initiatives. Wayfairer’s approach creates an alignment between stakeholders, where everyone is pulling in the same direction, and that can empower local communities to promote authentic, fair and sustainable tourism.\n" +
                        "\n" +
                        "Under the model, 50% of travel booking fees are reinvested back into the local community - to be invested across three themes - people, food, and the environment. And as an impact enterprise that is owned by these same local communities, the other 50% of the fees helps to create sustainable jobs.\n" +
                        "\n" +
                        "For this project, the funding contribution from WWF would enable the piloting of the Wayfairer model in the Ballarat region, specifically to support the accommodation needs of delegates attending the 2022 Australian Regional Tourism Convention.\n",
                "To-Do",
                "Innovate to Regenerate",
                testTagListYesTwo,
                R.drawable.wayfairer));
        solutions.add(new Solution("New Life",
                "Pushing the boundaries of possible plant life in the public eye",
                "In 2020, the government of Cameroon announced an initiative to log nearly 170,000 acres of the Ebo Forest's 500,000 acres. The forest is home to a variety of endangered species, like critically endangered western gorillas and endangered forest elephants, sending conservationists into a panic.\n",
                "To-Do",
                "Innovate to Regenerate",
                testTagListNo,
                R.drawable.newlife));
        solutions.add(new Solution("Pining for You",
                "Redfining the public's perception for the environment",
                "This remarkable tree escaped discovery by earlier botanists in part because the only canyon system in which trees grow is bounded by tall sandstone cliffs, and access to the plants requires use of a helicopter or climbing gear. Fewer than 100 adult trees and a few hundred seedlings presently survive in the canyon’s moist sheltered microclimate; their location is kept secret to avoid the introduction of pathogens. The trees were threatened by a bushfire that burned most of Wollemi National Park during the devastating 2019–20 fire season" +
                        "\n" +
                        "The trees that produced these pollen grains began disappearing from the fossil record within the last 10 million years when other species of Wollemia gradually became extinct.",
                "In Progress",
                "Innovate to Regenerate",
                testTagListNone,
                R.drawable.piningforyou));
        solutions.add(new Solution("Up-Rooted",
                "Speaking for the trees, in the name of all that is good",
                "Biodiversity is the ‘diversity of life’ and is not only important in its own right, but also helps support the very air we breathe, the water we drink and the food we eat.\n" +
                        "\n" +
                        "Together we can make a greater positive impact on the conservation. Small, local actions can also make a huge difference.",
                "In Progress",
                "Innovate to Regenerate",
                testTagListYesTwo,
                R.drawable.uprooted));
        return solutions;
    }

    // Done: Create a method to return the correct solution from the test data ArrayList based on a received String value
    public static Solution getSolution(String name) {
        for (Solution solution : getSolutions()) {
            if (solution.getSolutionName().equals(name)) {
                return solution;
            }
        }
        return null;
    }


    // DONE: A method to return an array list of Solutions from the test data on a received String value (the challenge name)
    public static ArrayList<Solution> getAllSolutionsFromChallenge(String challengeName) {
        // Create a new solution list
        ArrayList<Solution> solutionList= new ArrayList<>();

        // Loop through all the test solution data and if it matches then add it to the list
        for (Solution solution : getSolutions()) {
            if (solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        // Return the solution list
        return solutionList;
    }


    // DONE: Method that takes in a string and looks for it in the list of tags
    // if it can be found, then return True
    public boolean doesTagMatch(String inputTag) {
        boolean match = false;

        // Loop through the Solution Tags list
        // and check if the inputTag matches it
        for (String tags : solutionTagsList) {
            if (tags.equals(inputTag)) {
                match = true;
            }
        }

        return match;
    }

    // DONE: Method that makes a new list of Solutions with the matching Tag
    // (New list of Solutions that have the Tag in the solutionsTagList
    // This method will take in a Tag and and calls doesTagMatch
    // ---
    // First it makes a new empty Solution list
    // and then it goes through all the Solution data and if the Tag matches something in the list
    // then add that Solution to the list
    // and finally return the list
    public static ArrayList<Solution> getSolutionListFromTag(String inputTag) {

        // Create a new Solution array list
        ArrayList<Solution> solutionList= new ArrayList<>();

        // Loop through all the Solution data
        for (Solution solution : getSolutions()) {
            // Check if the Tag matches
            if (solution.doesTagMatch(inputTag)) {
                solutionList.add(solution);
            }
        }

        return solutionList;
    }

    // TODO Write a method that returns a list of Solutions given a list of Tags (not just one Tag string)
    // Iterate through the input Tag list and call the doesTagMatch for each tag
    // If any of them match then add that Solution to the list
    public static ArrayList<Solution> getSolutionListFromTagList(ArrayList<String> inputTagList) {

        // Create a new Solution array list
        ArrayList<Solution> solutionList= new ArrayList<>();

        // Loop through all the Solution data
        for (Solution solution : getSolutions()) {
            // Loop through all the Tags in the TagList
            for (String inputTag : inputTagList) {
                // Check if the Tag matches
                if (solution.doesTagMatch(inputTag)) {
                    solutionList.add(solution);
                }
            }
        }

        return solutionList;
    }

    // TODO Write a method that returns a list of Solutions given a list of Tags and counts the number of matches too
    // Since I plan on returning the solution and the Number of matches too, then I should make a new class


    // TODO: Write a method that combines the lists of Solutions so that the ones with more than THREE matches appear at the top


    // TODO: Write a method that returns a list of Solutions given a challenge name AND given a Tags list


    // For each Challenge, there will be corresponding Solutions
    // Solutions will be viewed based on Challenge, Status, Tag

        // Solutions that the Curator has yet To Do
        public static ArrayList<Solution> getSolutionsToDo() {
            // Create a list of challenges here
            ArrayList<Solution> solutions = new ArrayList<>();
            ArrayList<String> testTagListYesOne = new ArrayList<>();
            testTagListYesOne.add("Yes");
            ArrayList<String> testTagListYesTwo = new ArrayList<>();
            testTagListYesTwo.add("Not");
            testTagListYesTwo.add("Yes");
            solutions.add(new Solution("Contemporary Clothing",
                    "Made by contemporaries for our changing times",
                    "Second-hand clothing shops help reduce textiles waste to landfill. Australia has 3,000 charity and social enterprise retailers that support 5,000 jobs, 33,000 volunteers, and 10,000 charity collection bins. A range of innovative products were displayed revealing the latest developments in clothing textile waste recycling and highlighting both the challenges and opportunities of addressing textile waste here in Australia.\n",
                    "To-Do",
                    "The Great Fashion Decarbonisation",
                    testTagListYesTwo,
                    R.drawable.contemporary));
            solutions.add(new Solution("Decarbonated Style",
                    "A holistic overview of decarbonisation actioning",
                    "Despite efforts to reduce emissions, the industry is on a trajectory that will exceed the 1.5-degree pathway to mitigate climate change set out by the Intergovernmental Panel on Climate Change (IPCC) and ratified in the 2015 Paris agreement. By 2023, 20% of major apparel companies by revenue committed to net zero through membership in the Fashion Charter\n",
                    "To-Do",
                    "The Great Fashion Decarbonisation",
                    testTagListYesTwo,
                    R.drawable.decarbstyle));
            solutions.add(new Solution("Wayfairer",
                    "Building community wealth through tourism",
                    "\"Every year in Australia, over $150m is paid to international accommodation booking platforms, with the vast majority of that money disappearing offshore. We have seen the impact of this model across Australia, with the hollowing out of communities, increasing unaffordability of housing, and the commodification of tourism that has become insensitive to its local context.\n" +
                            "\n" +
                            "Wayfairer disrupts this extractive model. It enables booking revenue to stay in Australia - creating jobs, catalysing investment, and promoting tourism destinations through sustainable, locally-led initiatives. Wayfairer’s approach creates an alignment between stakeholders, where everyone is pulling in the same direction, and that can empower local communities to promote authentic, fair and sustainable tourism.\n" +
                            "\n" +
                            "Under the model, 50% of travel booking fees are reinvested back into the local community - to be invested across three themes - people, food, and the environment. And as an impact enterprise that is owned by these same local communities, the other 50% of the fees helps to create sustainable jobs.\n" +
                            "\n" +
                            "For this project, the funding contribution from WWF would enable the piloting of the Wayfairer model in the Ballarat region, specifically to support the accommodation needs of delegates attending the 2022 Australian Regional Tourism Convention.\n",
                    "To-Do",
                    "Innovate to Regenerate",
                    testTagListYesTwo,
                    R.drawable.wayfairer));
            solutions.add(new Solution("New Life",
                    "Pushing the boundaries of possible plant life in the public eye",
                    "In 2020, the government of Cameroon announced an initiative to log nearly 170,000 acres of the Ebo Forest's 500,000 acres. The forest is home to a variety of endangered species, like critically endangered western gorillas and endangered forest elephants, sending conservationists into a panic.\n",
                    "To-Do",
                    "Innovate to Regenerate",
                    testTagListYesTwo,
                    R.drawable.newlife));
            return solutions;
    }

    // Solutions that the Curator has Applied for aka In Progress
    public static ArrayList<Solution> getSolutionsInProgress() {
        // Create a list of challenges here
        ArrayList<Solution> solutions = new ArrayList<>();
        ArrayList<String> testTagListYesOne = new ArrayList<>();
        testTagListYesOne.add("Yes");
        ArrayList<String> testTagListYesTwo = new ArrayList<>();
        testTagListYesTwo.add("Not");
        testTagListYesTwo.add("Yes");
        solutions.add(new Solution("Sweater Wearer",
                "A change of wardrobe for the fashion industry",
                "The Sweater Wearer Initiative works on the basis of bringing high quality textiles to designers that can make the most of what they're given. Each time a garment is washed as part of daily use, it releases thousands of tiny fibres that find their way through wastewater to the oceans. Although scientists have long noted microfibre or microplastics pollution, it is only now attracting wider public attention." +
                        "\n" +
                        "100 billion garments are produced every year, with around a third of them ending up in landfills within the first initial year of their purchase.The textile industry is estimated to emit 8% of carbon emissions, and 20% of the world's waste water.",
                "In Progress",
                "The Great Fashion Decarbonisation",
                testTagListYesTwo,
                R.drawable.sweater));
        solutions.add(new Solution("Pining for You",
                "Redfining the public's perception for the environment",
                "This remarkable tree escaped discovery by earlier botanists in part because the only canyon system in which trees grow is bounded by tall sandstone cliffs, and access to the plants requires use of a helicopter or climbing gear. Fewer than 100 adult trees and a few hundred seedlings presently survive in the canyon’s moist sheltered microclimate; their location is kept secret to avoid the introduction of pathogens. The trees were threatened by a bushfire that burned most of Wollemi National Park during the devastating 2019–20 fire season" +
                        "\n" +
                        "The trees that produced these pollen grains began disappearing from the fossil record within the last 10 million years when other species of Wollemia gradually became extinct.",
                "In Progress",
                "Innovate to Regenerate",
                testTagListYesTwo,
                R.drawable.piningforyou));
        solutions.add(new Solution("Up-Rooted",
                "Speaking for the trees, in the name of all that is good",
                "Biodiversity is the ‘diversity of life’ and is not only important in its own right, but also helps support the very air we breathe, the water we drink and the food we eat.\n" +
                        "\n" +
                        "Together we can make a greater positive impact on the conservation. Small, local actions can also make a huge difference.",
                "In Progress",
                "Innovate to Regenerate",
                testTagListYesTwo,
                R.drawable.uprooted));
        return solutions;
    }

    // Solutions that the Curator has Applied for and Completed aka Done
    public static ArrayList<Solution> getSolutionsCompleted() {
        // Create a list of challenges here
        ArrayList<Solution> solutions = new ArrayList<>();
        ArrayList<String> testTagListYesOne = new ArrayList<>();
        testTagListYesOne.add("Yes");
        ArrayList<String> testTagListYesTwo = new ArrayList<>();
        testTagListYesTwo.add("Not");
        testTagListYesTwo.add("Yes");
        solutions.add(new Solution("Faster Fashion",
                "Agile as they come, our solution is speed",
                "Here's the problem with fast fashion.\n" +
                        "\n" +
                        "Up until the mid-twentieth century, the fashion industry ran on four seasons a year: fall, winter, spring, and summer. Designers would work many months ahead to plan for each season and predict the styles they believed customers would want. This method, although more methodical than fashion today, took away agency from the wearers. Before fashion became accessible to the masses, it was prescribed to high society, and there were rules to be followed.",
                "Done",
                "The Great Fashion Decarbonisation",
                testTagListYesTwo,
                R.drawable.fasterfashion));
        return solutions;
    }
}
