package com.example.canesurvey.model;

import java.util.Date;

public class SurveyModel {
    private int ID;
    private int plotvillagecode;
    private int growerid;
    private double area;
    private int variety;
    private int irrigation;
    private int plantationmethod;
    private String plantationdate;
    private long mobile;
    private long aadhar;
    private int sharepercent;


    public SurveyModel() {

    }

    public SurveyModel(int plotvillagecode,int growerid, double area, int variety, int irrigation, int plantationmethod, String plantationdate, long mobile, long aadhar, int sharepercent) {
        this.plotvillagecode=plotvillagecode;
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

    public int getPlotvillagecode() {
        return plotvillagecode;
    }

    public void setPlotvillagecode(int plotvillagecode) {
        this.plotvillagecode = plotvillagecode;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
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
