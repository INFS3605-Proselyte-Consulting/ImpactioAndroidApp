package com.example.impactioproselyteconsulting;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.SortedList;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    String solutionName;
    String solutionBlurb;
    String solutionDesc;
    String solutionChallengeOrigin;

    int solutionImage;

    // Add tags and SDGs
    // Because from the database Tags are in one long string
    // So here is that one long string variable
    String solutionTagsString;
    // And here is the tags Array list of Strings that it will be separated into
    ArrayList<String> solutionTagsList = new ArrayList<String>();

    // Rating of Solutions - only 3 allowed
    String rating1UID;
    int rating1Rating;
    String rating1Comment;
    String rating2UID;
    int rating2Rating;
    String rating2Comment;
    String rating3UID;
    int rating3Rating;
    String rating3Comment;

    int overallRating;

    int ratingCount;
    // If Solution has 3 curator ratings then solutionFull is true, if less than 3 then false
    Boolean solutionFull;

    public ArrayList<String> tempSolutionNamesList;



    public Solution() {
        // Empty constructor
        solutionName = "solutionName";
        solutionBlurb = "solutionBlurb";
        solutionDesc = "solutionDesc";
        solutionChallengeOrigin = "solutionChallengeOrigin";
        solutionImage = R.drawable.sweater;

        solutionTagsString = "";
        solutionTagsList = convertLongStringToList(solutionTagsString);

        rating1UID = "";
        rating1Rating = 5;
        rating1Comment = "";
        rating2UID = "";
        rating2Rating = 5;
        rating2Comment = "";
        rating3UID = "";
        rating3Rating = 5;
        rating3Comment = "";
        overallRating = 5;
        ratingCount = 0;
        solutionFull = false;
    }

    public Solution(String solutionName, String solutionBlurb, String solutionDesc,String solutionChallengeOrigin, ArrayList<String> solutionTagsList, int solutionImage) {
        this.solutionName = solutionName;
        this.solutionBlurb = solutionBlurb;
        this.solutionDesc = solutionDesc;
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

//    public String getSolutionStatus() {
//        return solutionStatus;
//    }
//
//    public void setSolutionStatus(String solutionStatus) {
//        this.solutionStatus = solutionStatus;
//    }

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

    public String getSolutionTagsString() {
        return solutionTagsString;
    }

    public void setSolutionTagsString(String solutionTagsString) {
        this.solutionTagsString = solutionTagsString;
    }

    public String getRating1UID() {
        return rating1UID;
    }

    public void setRating1UID(String rating1UID) {
        this.rating1UID = rating1UID;
    }

    public int getRating1Rating() {
        return rating1Rating;
    }

    public void setRating1Rating(int rating1Rating) {
        this.rating1Rating = rating1Rating;
    }

    public String getRating1Comment() {
        return rating1Comment;
    }

    public void setRating1Comment(String rating1Comment) {
        this.rating1Comment = rating1Comment;
    }

    public String getRating2UID() {
        return rating2UID;
    }

    public void setRating2UID(String rating2UID) {
        this.rating2UID = rating2UID;
    }

    public int getRating2Rating() {
        return rating2Rating;
    }

    public void setRating2Rating(int rating2Rating) {
        this.rating2Rating = rating2Rating;
    }

    public String getRating2Comment() {
        return rating2Comment;
    }

    public void setRating2Comment(String rating2Comment) {
        this.rating2Comment = rating2Comment;
    }

    public String getRating3UID() {
        return rating3UID;
    }

    public void setRating3UID(String rating3UID) {
        this.rating3UID = rating3UID;
    }

    public int getRating3Rating() {
        return rating3Rating;
    }

    public void setRating3Rating(int rating3Rating) {
        this.rating3Rating = rating3Rating;
    }

    public String getRating3Comment() {
        return rating3Comment;
    }

    public void setRating3Comment(String rating3Comment) {
        this.rating3Comment = rating3Comment;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(int overallRating) {
        this.overallRating = overallRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Boolean getSolutionFull() {
        return solutionFull;
    }

    public void setSolutionFull(Boolean solutionFull) {
        this.solutionFull = solutionFull;
    }




    // TODO: Write a method that takes in a really long string of something separated by '%' symbols
    // and put them into an ArrayList of Strings and return that list
    public static ArrayList<String> convertLongStringToList(String longStr) {
        System.out.println("Long String: " + longStr);

        // Make a new empty Array List of strings
        ArrayList<String> resultingStringList;

        String[] list = longStr.split("%");
        System.out.println("List" + list);

        resultingStringList = new ArrayList<>(Arrays.asList(list));

        return resultingStringList;
    }

    // This is the default function to get ALL the Solutions
    public static ArrayList<Solution> getSolutions() {
        // Create a list of solutions here
        ArrayList<Solution> solutions = new ArrayList<>();
        /*

//        // Create the test Data Tags Lists here
//        ArrayList<String> testTagListYesOne = new ArrayList<>();
//        testTagListYesOne.add("Yes");
//        ArrayList<String> testTagListYesTwo = new ArrayList<>();
//        testTagListYesTwo.add("Not");
//        testTagListYesTwo.add("Yes");
//        ArrayList<String> testTagListNone = new ArrayList<>();
//        testTagListNone.add("None");
//        ArrayList<String> testTagListNo = new ArrayList<>();
//        testTagListNo.add("No");

        // Create more proper test Data Tags Lists here
        ArrayList<String> testTagListHSMA = new ArrayList<>();
        testTagListHSMA.add("Health");
        testTagListHSMA.add("Science");
        testTagListHSMA.add("Maths");
        testTagListHSMA.add("Astrology");
        ArrayList<String> testTagListHSM = new ArrayList<>();
        testTagListHSM.add("Health");
        testTagListHSM.add("Science");
        testTagListHSM.add("Maths");
        ArrayList<String> testTagListWrong = new ArrayList<>();
        testTagListWrong.add("Not");
        testTagListWrong.add("Yes");
        ArrayList<String> testTagListAstrology = new ArrayList<>();
        testTagListAstrology.add("Not");
        testTagListAstrology.add("Astrology");
        testTagListAstrology.add("No");
        ArrayList<String> testTagListEMS = new ArrayList<>();
        testTagListEMS.add("English");
        testTagListEMS.add("Maths");
        testTagListEMS.add("Science");

        // TODO: Create new test data of Tags list for each Solution (data that makes more sense)
        // TODO: Also related, make the tags visible on the Discover Solutions and Solution Detail screen


        // Add the test data Solutions to the list
        solutions.add(new Solution("Contemporary Clothing",
                "Made by contemporaries for our changing times",
                "Second-hand clothing shops help reduce textiles waste to landfill. Australia has 3,000 charity and social enterprise retailers that support 5,000 jobs, 33,000 volunteers, and 10,000 charity collection bins. A range of innovative products were displayed revealing the latest developments in clothing textile waste recycling and highlighting both the challenges and opportunities of addressing textile waste here in Australia.\n",
                "To-Do",
                "The Great Fashion Decarbonisation",
                testTagListWrong,
                R.drawable.contemporary));
        solutions.add(new Solution("Decarbonated Style",
                "A holistic overview of decarbonisation actioning",
                "Despite efforts to reduce emissions, the industry is on a trajectory that will exceed the 1.5-degree pathway to mitigate climate change set out by the Intergovernmental Panel on Climate Change (IPCC) and ratified in the 2015 Paris agreement. By 2023, 20% of major apparel companies by revenue committed to net zero through membership in the Fashion Charter\n",
                "To-Do",
                "The Great Fashion Decarbonisation",
                testTagListWrong,
                R.drawable.decarbstyle));
        solutions.add(new Solution("Sweater Wearer",
                "A change of wardrobe for the fashion industry",
                "The Sweater Wearer Initiative works on the basis of bringing high quality textiles to designers that can make the most of what they're given. Each time a garment is washed as part of daily use, it releases thousands of tiny fibres that find their way through wastewater to the oceans. Although scientists have long noted microfibre or microplastics pollution, it is only now attracting wider public attention." +
                        "\n" +
                        "100 billion garments are produced every year, with around a third of them ending up in landfills within the first initial year of their purchase.The textile industry is estimated to emit 8% of carbon emissions, and 20% of the world's waste water.",
                "In Progress",
                "The Great Fashion Decarbonisation",
                testTagListEMS,
                R.drawable.sweater));
        solutions.add(new Solution("Faster Fashion",
                "Agile as they come, our solution is speed",
                "Here's the problem with fast fashion.\n" +
                        "\n" +
                        "Up until the mid-twentieth century, the fashion industry ran on four seasons a year: fall, winter, spring, and summer. Designers would work many months ahead to plan for each season and predict the styles they believed customers would want. This method, although more methodical than fashion today, took away agency from the wearers. Before fashion became accessible to the masses, it was prescribed to high society, and there were rules to be followed.",
                "Done",
                "The Great Fashion Decarbonisation",
                testTagListWrong,
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
                testTagListHSMA,
                R.drawable.wayfairer));
        solutions.add(new Solution("New Life",
                "Pushing the boundaries of possible plant life in the public eye",
                "In 2020, the government of Cameroon announced an initiative to log nearly 170,000 acres of the Ebo Forest's 500,000 acres. The forest is home to a variety of endangered species, like critically endangered western gorillas and endangered forest elephants, sending conservationists into a panic.\n",
                "To-Do",
                "Innovate to Regenerate",
                testTagListAstrology,
                R.drawable.newlife));
        solutions.add(new Solution("Pining for You",
                "Redfining the public's perception for the environment",
                "This remarkable tree escaped discovery by earlier botanists in part because the only canyon system in which trees grow is bounded by tall sandstone cliffs, and access to the plants requires use of a helicopter or climbing gear. Fewer than 100 adult trees and a few hundred seedlings presently survive in the canyon’s moist sheltered microclimate; their location is kept secret to avoid the introduction of pathogens. The trees were threatened by a bushfire that burned most of Wollemi National Park during the devastating 2019–20 fire season" +
                        "\n" +
                        "The trees that produced these pollen grains began disappearing from the fossil record within the last 10 million years when other species of Wollemia gradually became extinct.",
                "In Progress",
                "Innovate to Regenerate",
                testTagListHSM,
                R.drawable.piningforyou));
        solutions.add(new Solution("Up-Rooted",
                "Speaking for the trees, in the name of all that is good",
                "Biodiversity is the ‘diversity of life’ and is not only important in its own right, but also helps support the very air we breathe, the water we drink and the food we eat.\n" +
                        "\n" +
                        "Together we can make a greater positive impact on the conservation. Small, local actions can also make a huge difference.",
                "In Progress",
                "Innovate to Regenerate",
                testTagListEMS,
                R.drawable.uprooted));
        */

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




    // TODO: Write a method that returns ALL the solutions in the database in an Array List of Solutions
    public static ArrayList<Solution> getAllSolutionsFromDB() {
        // First
        //FireBase Database
        FirebaseDatabase firebaseDatabase;

        // Make an instance of Solution??
        //Solution solutionInstance;

        // Database Reference
        DatabaseReference referenceGetSolutionName;

        //Recognise the firebase database user
        // May not be needed in this method
        //String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // initializing our object class variable.
        //solutionInstance = new Solution();

        // Initialize the array list of solutions
        ArrayList<Solution> solutionsArrayListInstance = new ArrayList<>();

        //Reference Database
        firebaseDatabase = FirebaseDatabase.getInstance();
        referenceGetSolutionName =  firebaseDatabase.getReference().child("Solution");

        referenceGetSolutionName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Write a for loop for the keys under Solution
                int counter = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //
                    // Reset the solution instance
                    Solution solutionInstance = new Solution();

                    // Fill in the data
                    solutionInstance.setSolutionName(snapshot.child("solutionName").getValue().toString());
                    solutionInstance.setSolutionBlurb(snapshot.child("solutionBlurb").getValue().toString());
                    solutionInstance.setSolutionDesc(snapshot.child("solutionDesc").getValue().toString());
                    solutionInstance.setSolutionChallengeOrigin(snapshot.child("solutionChallengeOrigin").getValue().toString());


                    // Comment this out and use a default image if this breaks
//                    String imgFileName = snapshot.child("solutionImage").getValue().toString();
//                    int resID = solutionInstance.context.getResources().getIdentifier(imgFileName , "drawable", solutionInstance.context.getPackageName());
//                    solutionInstance.setSolutionImage(resID);
                    solutionInstance.setSolutionImage(R.drawable.sweater);

                    // Now get tags by passing in the string and getting an array list out of it with the method made previously
                    String tempString = snapshot.child("Tags").getValue().toString();
                    solutionInstance.setSolutionTagsList(convertLongStringToList(tempString));

                    // Ratings
//                    // Must check if the ratings work or not
                    //TODO: Fix ratings to match the database layout and aslo check if empty
//                    solutionInstance.setRating1UID(snapshot.child("customerRating/rating1/uid").getValue().toString());
//                    solutionInstance.setRating1Rating(snapshot.child("customerRating/rating1/rating").getValue(Integer.class));
//                    solutionInstance.setRating1Comment(snapshot.child("customerRating/rating1/comment").getValue().toString());
//                    solutionInstance.setRating2UID(snapshot.child("customerRating/rating2/uid").getValue().toString());
//                    solutionInstance.setRating2Rating(snapshot.child("customerRating/rating2/rating").getValue(Integer.class));
//                    solutionInstance.setRating2Comment(snapshot.child("customerRating/rating2/comment").getValue().toString());
//                    solutionInstance.setRating3UID(snapshot.child("customerRating/rating3/uid").getValue().toString());
//                    solutionInstance.setRating3Rating(snapshot.child("customerRating/rating3/rating").getValue(Integer.class));
//                    solutionInstance.setRating3Comment(snapshot.child("customerRating/rating3/comment").getValue().toString());
//
//                    // Rating Count and Check if Full
//                    solutionInstance.setRatingCount(snapshot.child("customerRating/ratingCount").getValue(Integer.class));
//                    solutionInstance.setSolutionFull(snapshot.child("solutionFull").getValue(Boolean.class));

                    // Now that all the data is set then add it to the Array List
                    solutionsArrayListInstance.add(solutionInstance);
                }
                // Now iterate the for loop for the next Child
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return solutionsArrayListInstance;

    }

    public static ArrayList<Solution> solutionsAllDBList = getAllSolutionsFromDB();

    // TODO: Write a method that returns a Solution (using the data from the database)
    // taking in a solution name
    public static Solution getSolutionFromDB(String solutionName) {

        for (Solution solution : solutionsAllDBList) {
            if (solution.getSolutionName().equals(solutionName)) {
                System.out.println("Successfully found: " + solution.getSolutionName());
                return solution;
            }
        }
        System.out.println("Failed to find a solution");
        return null;
    }

    // TODO: Write a method that returns an Array List of Solutions from DB by taking in an Array List of Strings of Solution names
    // This in theory could be used for the Dashboard redirects to Solutions
    public static ArrayList<Solution> getSolutionsFromSolutionNames(ArrayList<String> solutionNamesList) {
        ArrayList<Solution> outputSolutions = new ArrayList<>();

        // Loop through the Solution Names list
        for (String name : solutionNamesList) {
            // Loop through all the Solutions list
            for (Solution solution : solutionsAllDBList) {
                // Check if match
                if (solution.getSolutionName().equals(name)) {
                    // if they match then, append to the output list
                    outputSolutions.add(solution);
                }
            }
        }

        System.out.println("Solution name conversion: " + outputSolutions);

        return outputSolutions;
    }



    // TODO: Write a method that returns an array list of Solutions from Database based on the challenge name string
    public static ArrayList<Solution> getAllDBSolutionsFromChallenge(String challengeName) {
        // Create a new solution list
        ArrayList<Solution> solutionList= new ArrayList<>();

        // Loop through all the test solution data and if it matches then add it to the list
        for (Solution solution : solutionsAllDBList) {
            if (solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        // Return the solution list
        return solutionList;
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
    // Should still work with DB
    public boolean doesTagMatch(String inputTag) {

        // Loop through the Solution Tags list
        // and check if the inputTag matches it
        for (String tags : solutionTagsList) {
            if (tags.equals(inputTag)) {
                return true;
            }
        }

        return false;
    }

    // DONE: Method that finds the number of matches between tags of solution vs user
    public int howManyTagsMatch(ArrayList<String> userTagsList) {
        int matches = 0;

        // Loop through the Solution Tags list
        for (String solutionTag : solutionTagsList) {
            // Loop through the UserTags list
            for (String userTag : userTagsList) {
                // Check if match
                if (solutionTag.equals(userTag)) {
                    // if they match then, iterate counter
                    matches++;
                }
            }
        }

        return matches;
    }

    // DONE: Method that returns a list of ALL Solutions with those with more matches at the top
    // This is THE Algorithm
    // This can be used later in the To Do Solutions from the dashboard
    // Should in theory, call howManyTagsMatch method
    public static ArrayList<Solution> getPrioritizedSolutionListFromTagList(ArrayList<String> userTagList) {

        // Create a new empty Solution list
        ArrayList<Solution> solutionList = new ArrayList<>();

        // Make a separate loop for each number to check
        // to ensure right order

        // TODO: Not that important but if can, make this a loop so that it looks nicer

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) >= 10) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 9) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 8) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 7) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 6) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 5) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 4) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 3) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 2) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 1) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 0) {
                solutionList.add(solution);
            }
        }

        return solutionList;
    }

    // TODO: Write a method that returns a list of DB solutions names String that match the status of Discover
    //
    public static ArrayList<String> getDiscoverSolutionNamesFromUserDB() {
        // First
        //FireBase Database
        FirebaseDatabase firebaseDatabase;

        // Make an instance of Solution??
        Solution solutionInstance = new Solution();

        // Database Reference
        DatabaseReference referenceGetSolutionName;

        //Recognise the firebase database user
        // May not be needed in this method
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // initializing our object class variable.
        //solutionInstance = new Solution();

        // Initialize the array list of solutions
        //ArrayList<String> solutionsDiscoverOutputList = new ArrayList<>();

        //Reference Database
        firebaseDatabase = FirebaseDatabase.getInstance();
        referenceGetSolutionName =  firebaseDatabase.getReference().child("CustomerInfo").child(uid).child("cusSolutions");

        referenceGetSolutionName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                // Write a for loop for the keys under Solution
                int counter = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //
                    String solutionName = snapshot.child("solutionName").getValue().toString();
                    System.out.println("Solution Name: " + solutionName);
                    String solutionStatus = snapshot.child("solutionStatus").getValue().toString();
                    System.out.println("Solution Status: " + solutionStatus);

                    // If the solution status is equal to Discover then
                    if (solutionStatus.equals("discover")) {
                        // then add the solution name to the list
                        System.out.println("Added: " + solutionName);
                        solutionInstance.tempSolutionNamesList.add(solutionName);
                    }

                    System.out.println("List nowww has:..." + solutionInstance.tempSolutionNamesList);

                }
                // Now iterate the for loop for the next Child
                System.out.println("List should have: " + solutionInstance.tempSolutionNamesList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        System.out.println("All Discover Solution names: " + solutionInstance.tempSolutionNamesList);

        return solutionInstance.tempSolutionNamesList;

    }

    // This is the Solution List Discover
    public static ArrayList<Solution> solutionsDiscoverDBList = getSolutionsFromSolutionNames(getDiscoverSolutionNamesFromUserDB());



    // TODO: Write a method that returns a list of ALL DB Solutions with those with more matches at the top
    // This is THE Algorithm
    // This can be used later in the To Do Solutions from the dashboard
    // Should in theory, call howManyTagsMatch method
    public static ArrayList<Solution> getPrioritizedSolutionDBListFromTagList(ArrayList<String> userTagList) {

        // Create a new empty Solution list
        ArrayList<Solution> solutionList = new ArrayList<>();

        // Make a separate loop for each number to check
        // to ensure right order

        // TODO: Not that important but if can, make this a loop so that it looks nicer

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) >= 10) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 9) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 8) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 7) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 6) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 5) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 4) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 3) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 2) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 1) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 0) {
                solutionList.add(solution);
            }
        }

        return solutionList;
    }


    // DONE: Method that returns a list of Solutions specific to the input Challenge name
    // with those with more matches at the top
    // This uses THE Algorithm
    // This can be used later in the Discover page from Challenge Detail Activity
    public static ArrayList<Solution> getPrioritizedSolutionListFromTagListAndChallengeName(ArrayList<String> userTagList, String challengeName) {

        // Create a new empty Solution list
        ArrayList<Solution> solutionList = new ArrayList<Solution>();

        // Make a separate loop for each number to check
        // to ensure right order

        // TODO: Not that important but if can, make this a loop so that it looks nicer

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) >= 10 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 9 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 8 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 7 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 6 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 5 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 4 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 3 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 2 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 1 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : getSolutions()) {
            if (solution.howManyTagsMatch(userTagList) == 0 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        return solutionList;
    }


    // TODO: Write a method that returns a list of DB Solutions specific to the input Challenge name
    // with those with more matches at the top
    // This uses THE Algorithm
    // This can be used later in the Discover page from Challenge Detail Activity
    public static ArrayList<Solution> getPrioritizedDBSolutionListFromTagListAndChallengeName(ArrayList<String> userTagList, String challengeName) {

        // Create a new empty Solution list
        ArrayList<Solution> solutionList = new ArrayList<>();

        // Make a separate loop for each number to check
        // to ensure right order

        // TODO: Not that important but if can, make this a loop so that it looks nicer

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) >= 10 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 9 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 8 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 7 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 6 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 5 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 4 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 3 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 2 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 1 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsAllDBList) {
            if (solution.howManyTagsMatch(userTagList) == 0 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        return solutionList;
    }


    // TODO: Write a method that returns a list of DB Solutions specific to the input Challenge name
    // with those with more matches at the top
    // This uses THE Algorithm
    // This can be used later in the Discover page from Challenge Detail Activity
    public static ArrayList<Solution> getPrioritizedDBDiscoverSolutionListFromTagListAndChallengeName(ArrayList<String> userTagList, String challengeName) {

        // Create a new empty Solution list
        ArrayList<Solution> solutionList = new ArrayList<>();

        // Make a separate loop for each number to check
        // to ensure right order

        // TODO: Not that important but if can, make this a loop so that it looks nicer

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) >= 10 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 9 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 8 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 7 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 6 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 5 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 4 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 3 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 2 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 1 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        for (Solution solution : solutionsDiscoverDBList) {
            if (solution.howManyTagsMatch(userTagList) == 0 && solution.getSolutionChallengeOrigin().equals(challengeName)) {
                solutionList.add(solution);
            }
        }

        System.out.println("Priority List: " + solutionList);

        return solutionList;
    }



    // DONE: Method that makes a new list of Solutions with the matching Tag
    // (New list of Solutions that have the Tag in the solutionsTagList
    // This method will take in a Tag and and calls doesTagMatch
    // ---
    // First it makes a new empty Solution list
    // and then it goes through all the Solution data and if the Tag matches something in the list
    // then add that Solution to the list
    // and finally return the list
    // The resulting solution list is Unsorted / not in any order or priority, thus unused
    public static ArrayList<Solution> getSolutionListFromTag(String inputTag) {

        // Create a new Solution array list
        ArrayList<Solution> solutionList = new ArrayList<>();

        // Loop through all the Solution data
        for (Solution solution : getSolutions()) {
            // Check if the Tag matches
            if (solution.doesTagMatch(inputTag)) {
                solutionList.add(solution);
            }
        }

        return solutionList;
    }

    // DONE: Method that returns a list of Solutions given a list of Tags (not just one Tag string)
    // Iterate through the input Tag list and call the doesTagMatch for each tag
    // If any of them match then add that Solution to the list
    // The resulting solution list is Unsorted / not in any order or priority, thus unused
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


    // For each Challenge, there will be corresponding Solutions
    // Solutions will be viewed based on Challenge, Status, Tag

        // Solutions that the Curator has yet To Do
        public static ArrayList<Solution> getSolutionsToDo() {
            // Create a list of challenges here
            ArrayList<Solution> solutions = new ArrayList<>();
            /*
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


             */

            return solutions;
    }

    // Solutions that the Curator has Applied for aka In Progress
    public static ArrayList<Solution> getSolutionsInProgress() {
        // Create a list of challenges here
        ArrayList<Solution> solutions = new ArrayList<>();
        /*
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

         */

        return solutions;
    }

    // Solutions that the Curator has Applied for and Completed aka Done
    public static ArrayList<Solution> getSolutionsCompleted() {
        // Create a list of challenges here
        ArrayList<Solution> solutions = new ArrayList<>();
        /*
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

         */

        return solutions;
    }
}
