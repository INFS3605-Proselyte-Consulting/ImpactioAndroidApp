package com.example.impactioproselyteconsulting;

public class CustomerInfo {
    private String cusEmail, cusPass, cusName, cusBio, cusSDG, cusExpertise, cusGeneratedTags;

    public CustomerInfo() {
    }

    public CustomerInfo(String cusEmail, String cusPass, String cusName, String cusBio, String cusSDG, String cusExpertise, String cusGeneratedTags) {
        this.cusEmail = cusEmail;
        this.cusPass = cusPass;
        this.cusName = cusName;
        this.cusBio = cusBio;
        this.cusSDG = cusSDG;
        this.cusExpertise = cusExpertise;
        this.cusGeneratedTags = cusGeneratedTags;
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
}
