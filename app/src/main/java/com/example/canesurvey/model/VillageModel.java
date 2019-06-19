package com.example.canesurvey.model;

public class VillageModel {

    private int ID;
    private int Code;
    private String Name;
    private int lastghno;

    public VillageModel(int code, String name,int lastghno) {
        Code = code;
        Name = name;
        this.lastghno=lastghno;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLastghno() {
        return lastghno;
    }

    public void setLastghno(int lastghno) {
        this.lastghno = lastghno;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
