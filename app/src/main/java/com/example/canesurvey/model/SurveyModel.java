package com.example.canesurvey.model;

import java.util.Date;

public class SurveyModel {
    private int ID;
    private int growerid;
    private float area;
    private int variety;
    private int irrigation;
    private int plantationmethod;
    private String plantationdate;
    private long mobile;
    private long aadhar;
    private int sharepercent;

    public SurveyModel(int growerid, float area, int variety, int irrigation, int plantationmethod, String plantationdate, long mobile, long aadhar, int sharepercent) {
        this.growerid = growerid;
        this.area = area;
        this.variety = variety;
        this.irrigation = irrigation;
        this.plantationmethod = plantationmethod;
        this.plantationdate = plantationdate;
        this.mobile = mobile;
        this.aadhar = aadhar;
        this.sharepercent = sharepercent;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGrowerid() {
        return growerid;
    }

    public void setGrowerid(int growerid) {
        this.growerid = growerid;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getVariety() {
        return variety;
    }

    public void setVariety(int variety) {
        this.variety = variety;
    }

    public int getIrrigation() {
        return irrigation;
    }

    public void setIrrigation(int irrigation) {
        this.irrigation = irrigation;
    }

    public int getPlantationmethod() {
        return plantationmethod;
    }

    public void setPlantationmethod(int plantationmethod) {
        this.plantationmethod = plantationmethod;
    }

    public String getPlantationdate() {
        return plantationdate;
    }

    public void setPlantationdate(String plantationdate) {
        this.plantationdate = plantationdate;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public long getAadhar() {
        return aadhar;
    }

    public void setAadhar(long aadhar) {
        this.aadhar = aadhar;
    }

    public int getSharepercent() {
        return sharepercent;
    }

    public void setSharepercent(int sharepercent) {
        this.sharepercent = sharepercent;
    }

}
