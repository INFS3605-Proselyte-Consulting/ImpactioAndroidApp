package com.example.impactioproselyteconsulting;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerInfo {
    private String cusEmail, cusPass, cusName, cusBio, cusSDG, cusExpertise, cusGeneratedTags, cusCombinedTagsString;
    private ArrayList<String> cusCombinedTagList;

    public CustomerInfo() {
    }

    @Override
    public String toString() {
        return cusName + "," + cusEmail + "," + cusPass + "," + cusBio + "," + cusExpertise + "," + cusSDG;
    }

    public CustomerInfo(String cusEmail, String cusPass, String cusName, String cusBio, String cusSDG, String cusExpertise, String cusGeneratedTags, String cusCombinedTagsString, ArrayList<String> cusCombinedTagList) {
        this.cusEmail = cusEmail;
        this.cusPass = cusPass;
        this.cusName = cusName;
        this.cusBio = cusBio;
        this.cusSDG = cusSDG;
        this.cusExpertise = cusExpertise;
        this.cusGeneratedTags = cusGeneratedTags;
        this.cusCombinedTagsString = cusCombinedTagsString;
        this.cusCombinedTagList = cusCombinedTagList;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusPass() {
        return cusPass;
    }

    public void setCusPass(String cusPass) {
        this.cusPass = cusPass;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusBio() {
        return cusBio;
    }

    public void setCusBio(String cusBio) {
        this.cusBio = cusBio;
    }

    public String getCusSDG() {
        return cusSDG;
    }

    public void setCusSDG(String cusSDG) {
        this.cusSDG = cusSDG;
    }

    public String getCusExpertise() {
        return cusExpertise;
    }

    public void setCusExpertise(String cusExpertise) {
        this.cusExpertise = cusExpertise;
    }

    public String getCusGeneratedTags() {return cusGeneratedTags; }

    public void setCusGeneratedTags(String cusGeneratedTags) {this.cusGeneratedTags = cusGeneratedTags; }

    public String getCusCombinedTagsString() {
        return cusCombinedTagsString;
    }

    public void setCusCombinedTagsString(String cusCombinedTagsString) {
        this.cusCombinedTagsString = cusCombinedTagsString;
    }

    public ArrayList<String> getCusCombinedTagList() {
        return cusCombinedTagList;
    }

    public void setCusCombinedTagList(ArrayList<String> cusCombinedTagList) {
        this.cusCombinedTagList = cusCombinedTagList;
    }


    // TODO: Write a method that takes in a really long string of something separated by '%' symbols
    // and put them into an ArrayList of Strings and return that list
    public static ArrayList<String> convertLongStringToList(String longString) {
        // Make a new empty Array List of strings
        ArrayList<String> resultingStringList;

        String[] list = longString.split("%");

        resultingStringList = new ArrayList<>(Arrays.asList(list));

        return resultingStringList;
    }
}
