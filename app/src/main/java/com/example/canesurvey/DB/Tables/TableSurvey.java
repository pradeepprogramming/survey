package com.example.canesurvey.DB.Tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.canesurvey.Comman.CommanData;
import com.example.canesurvey.model.CompleteSurveyModel;
import com.example.canesurvey.model.GrowerModel;
import com.example.canesurvey.model.SurveyModel;

import java.util.ArrayList;
import java.util.List;

public class TableSurvey extends Table {
    public TableSurvey(SQLiteDatabase db) {
        super(db);
        setPrimaryKey(ID);
        setTableName("Survey");
    }

    private String ID = "ID";
    private String PlotVillagecode="Plotvillagecode";
    private String Growerid = "GrowerId";
    private String Area = "Area";
    private String Variety = "Variety";
    private String Irigation = "Irigation";
    private String PlantationMethod = "PlantationMethod";
    private String PlantationDate = "PlantationDate";
    private String MobileNo = "MobileNo";
    private String AadharNo = "AadharNo";
    private String TotalSharePercent = "TotalSharePercent";
    private String SurveyDate="SurveyDate";
    private String PlotSrno="PlotSrno";

    public String CreateTable() {
        String query = new StringBuilder("create table " + getTableName() + "  (" + ID + " INTEGER not null  PRIMARY KEY AUTOINCREMENT ")
                .append("," + PlotVillagecode + " INTEGER not null")
                .append("," + Growerid + " INTEGER not null")
                .append("," + Area + " NUMERIC NOT NULL")
                .append("," + Variety + " INTEGER NOT NULL")
                .append("," + Irigation + " INTEGER NOT NULL")
                .append("," + PlantationMethod + " INTEGER NOT NULL")
                .append("," + PlantationDate + " text NOT NULL")
                .append("," + MobileNo + " NUMERIC NOT NULL")
                .append("," + AadharNo + " NUMERIC NOT NULL")
                .append("," + TotalSharePercent + " INTEGER NOT NULL")
                .append("," + SurveyDate + " text NOT NULL")
                .append("," + PlotSrno + " INTEGER NOT NULL")
                .append(");").toString();
        return query;
    }

    public long Add(SurveyModel rt) {

        ContentValues cv = new ContentValues();
        cv.put(PlotVillagecode,rt.getPlotvillagecode());
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


    public List<CompleteSurveyModel> getCompleteSurvey() {
        try {
            List<CompleteSurveyModel> completesurveys=new ArrayList<>();
            TableGrower tgrower = CommanData.conn.grower;
            String query = "select s.*,villagecode,growercode from " + getTableName() + " s join " + tgrower.getTableName() +
                    " g on " + Growerid + "= g." + tgrower.ID + ";";
            Cursor cursor = db.rawQuery(query, null);
            int plotvillcode,growerid,id,villcode;
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                CompleteSurveyModel cm = new CompleteSurveyModel();
                 plotvillcode=cursor.getInt(cursor.getColumnIndex(PlotVillagecode));
                cm.setPlotvillagecode(plotvillcode);
                cm.setPlotvillname(CommanData.conn.village.getVillageName(plotvillcode));
                 growerid=cursor.getInt(cursor.getColumnIndex(Growerid));
                cm.setGrowerid(growerid);
                cm.setArea(cursor.getFloat(cursor.getColumnIndex(Area)));
                cm.setVariety(cursor.getInt(cursor.getColumnIndex(Variety)));
                cm.setIrrigation(cursor.getInt(cursor.getColumnIndex(Irigation)));
                cm.setPlantationmethod(cursor.getInt(cursor.getColumnIndex(PlantationMethod)));
                cm.setPlantationdate(cursor.getString(cursor.getColumnIndex(PlantationDate)));
                cm.setMobile(cursor.getLong(cursor.getColumnIndex(MobileNo)));
                cm.setAadhar(cursor.getLong(cursor.getColumnIndex(AadharNo)));
                cm.setSharepercent(cursor.getInt(cursor.getColumnIndex(TotalSharePercent)));
                 id=cursor.getInt(cursor.getColumnIndex(ID));
                 villcode=cursor.getInt(cursor.getColumnIndex(tgrower.VillageCode));
                cm.setVill(villcode);
                cm.setGrow(cursor.getInt(cursor.getColumnIndex(tgrower.GrowerCode)));

                cm.setGrowername(CommanData.conn.grower.getGrowerName(growerid));
                cm.setFathername(CommanData.conn.grower.getFatherName(growerid));
                cm.setVillagename(CommanData.conn.village.getVillageName(villcode));
                cm.setPlotlocations(CommanData.conn.plotlocation.getAllPlotLocation(id));
                completesurveys.add(cm);
            }
            return completesurveys;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
