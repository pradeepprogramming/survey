package com.example.canesurvey.DB.Tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.canesurvey.model.GrowerModel;
import com.example.canesurvey.model.SurveyModel;

public class TableSurvey extends Table {
    public TableSurvey(SQLiteDatabase db) {
        super(db);
        setPrimaryKey(ID);
        setTableName("Survey");
    }

    private String ID = "ID";
    private String Growerid = "GrowerId";
    private String Area = "Area";
    private String Variety = "Variety";
    private String Irigation = "Irigation";
    private String PlantationMethod = "PlantationMethod";
    private String PlantationDate = "PlantationDate";
    private String MobileNo = "MobileNo";
    private String AadharNo = "AadharNo";
    private String TotalSharePercent = "TotalSharePercent";

    public String CreateTable() {
        String query = new StringBuilder("create table " + getTableName() + "  (" + ID + " INTEGER not null  PRIMARY KEY AUTOINCREMENT ")
                .append("," + Growerid + " INTEGER not null")
                .append("," + Area + " NUMERIC NOT NULL")
                .append("," + Variety + " INTEGER NOT NULL")
                .append("," + Irigation + " INTEGER NOT NULL")
                .append("," + PlantationMethod + " INTEGER NOT NULL")
                .append("," + PlantationDate + " NUMERIC NOT NULL")
                .append("," + MobileNo + " NUMERIC NOT NULL")
                .append("," + AadharNo + " NUMERIC NOT NULL")
                .append("," + TotalSharePercent + " INTEGER NOT NULL")

                .append(");").toString();
        return query;
    }

    public long Add(SurveyModel rt) {

        ContentValues cv = new ContentValues();
        cv.put(Growerid, rt.getGrowerid());
        cv.put(Area, rt.getArea());
        cv.put(Variety, rt.getVariety());
        cv.put(Irigation, rt.getIrrigation());
        cv.put(PlantationMethod, rt.getPlantationmethod());
        cv.put(PlantationDate, rt.getPlantationdate());
        cv.put(MobileNo, rt.getMobile());
        cv.put(AadharNo, rt.getAadhar());
        cv.put(TotalSharePercent, rt.getSharepercent());

        return Add(cv);
    }


}
