package com.example.canesurvey.model;

public class ShareDetails {
    int surveyid,percent,vill,grow;

    public ShareDetails(int percent, int vill, int grow) {
        this.percent = percent;
        this.vill = vill;
        this.grow = grow;
    }

    public ShareDetails(int surveyid, int percent, int vill, int grow) {
        this.surveyid = surveyid;
        this.percent = percent;
        this.vill = vill;
        this.grow = grow;
    }

    public int getSurveyid() {
        return surveyid;
    }

    public void setSurveyid(int surveyid) {
        this.surveyid = surveyid;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getVill() {
        return vill;
    }

    public void setVill(int vill) {
        this.vill = vill;
    }

    public int getGrow() {
        return grow;
    }

    public void setGrow(int grow) {
        this.grow = grow;
    }
}
