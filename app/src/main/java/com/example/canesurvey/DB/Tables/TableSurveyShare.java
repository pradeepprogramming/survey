package com.example.canesurvey.DB.Tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.canesurvey.model.PlotLcationModel;
import com.example.canesurvey.model.ShareDetails;

public class TableSurveyShare extends Table {
    public TableSurveyShare(SQLiteDatabase db)
    {
        super(db);
        setPrimaryKey(ID);
        setTableName("SurveyShare");
    }

    private  String ID="ID";
    private  String SurveyID="SId";
    private  String GrowerID="GrowerID";
    private  String Percent="Percent";

    public String CreateTable()
    {
        String query=new StringBuilder("create table "+getTableName()+"  ("+ID+" INTEGER not null  PRIMARY KEY AUTOINCREMENT ")
                .append(","+SurveyID+" INTEGER not null")
                .append(","+GrowerID+" INTEGER not null")
                .append(","+Percent+" INTEGER not null")

                .append(");").toString();
        return query;
    }

    public long Add(long surveyid,int growerid,int percent){
        ContentValues cv = new ContentValues();
        cv.put(SurveyID, surveyid);
        cv.put(GrowerID, growerid);
        cv.put(Percent, percent);

        return Add(cv);
    }

}
