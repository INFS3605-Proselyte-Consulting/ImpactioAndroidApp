package com.example.impactioproselyteconsulting;

public class SolutionTagMatchValue {
    // This class is created so that when showing the Solutions on the Discover Solutions page and To-Do
    // the Solutions are displayed in an order that is dependent on how many user Tags match how many Solution Tags

    Solution actualSolution;
    int numOfTagMatches;

    SolutionTagMatchValue(Solution actualSolution, int numOfTagMatches) {
        this.actualSolution = actualSolution;
        this.numOfTagMatches = numOfTagMatches;
    }

    public Solution getActualSolution() {
        return actualSolution;
    }

    public void setActualSolution(Solution actualSolution) {
        this.actualSolution = actualSolution;
    }

    public int getNumOfTagMatches() {
        return numOfTagMatches;
    }

    public void setNumOfTagMatches(int numOfTagMatches) {
        this.numOfTagMatches = numOfTagMatches;
    }


    public static SolutionTagMatchValue getSolutionTagMatchValue(Solution actualSolution) {
        int numOfTagMatches = 0;
        return new SolutionTagMatchValue(actualSolution, numOfTagMatches);
    }
}
