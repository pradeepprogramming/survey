package com.example.canesurvey.model;

public class PlotLcationModel {
    private int ID;
    private int surveyid;
    private int corner;
    private double lat;
    private double lang;
    private double meter;


    public PlotLcationModel(int surveyid, int corner, double lat, double lang, double meter) {
        this.surveyid = surveyid;
        this.corner = corner;
        this.lat = lat;
        this.lang = lang;
        this.meter = meter;
    }

    public int getSurveyid() {
        return surveyid;
    }

    public void setSurveyid(int surveyid) {
        this.surveyid = surveyid;
    }

    public int getCorner() {
        return corner;
    }

    public void setCorner(int corner) {
        this.corner = corner;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    public double getMeter() {
        return meter;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }
}
