package com.example.canesurvey.DB.Tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.canesurvey.model.PlotLcationModel;

public class TablePlotLocation extends Table {
    public TablePlotLocation(SQLiteDatabase db)
    {
        super(db);
        setPrimaryKey(ID);
        setTableName("PlotLocation");
    }

    private  String ID="ID";
    private  String SurveyID="SID";
    private  String Corner="Corner";
    private  String Lat="Lat";
    private  String Lang="Lang";
    private  String Meter="Meter";

    public String CreateTable()
    {
        String query=new StringBuilder("create table "+getTableName()+"  ("+ID+" INTEGER not null  PRIMARY KEY AUTOINCREMENT ")
                .append(","+SurveyID+" INTEGER not null")
                .append(","+Corner+" INTEGER not null")
                .append(","+Lat+" numeric not null")
                .append(","+Lang+" numeric not null")
                .append(","+Meter+" numeric not null")

                .append(");").toString();
        return query;
    }

    public long Add(PlotLcationModel rt){
        ContentValues cv = new ContentValues();
        cv.put(SurveyID, rt.getSurveyid());
        cv.put(Corner, rt.getCorner());
        cv.put(Lat, rt.getLat());
        cv.put(Lang, rt.getLang());
        cv.put(Meter, rt.getMeter());

        return Add(cv);
    }
}
