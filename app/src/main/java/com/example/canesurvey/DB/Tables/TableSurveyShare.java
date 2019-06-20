package com.example.canesurvey.DB.Tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.canesurvey.Comman.CommanData;
import com.example.canesurvey.model.PlotLcationModel;
import com.example.canesurvey.model.ShareDetails;

import java.util.ArrayList;
import java.util.List;

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

    public List<ShareDetails> getAllsharedetails(int surveyid) {
        List<ShareDetails> shareDetails=new ArrayList<>();
        try {
            TableGrower growers=CommanData.conn.grower;
            String query="Select " +growers.VillageCode+","+growers.GrowerCode+","+Percent+
                    " from "+getTableName()+" join "+ growers.getTableName() +" on "+growers.ID+"="+GrowerID+"  where "+SurveyID+"="+surveyid+";";
            Cursor cursor=db.rawQuery(query,null);
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                ShareDetails pm=new ShareDetails(surveyid
                        ,cursor.getInt(cursor.getColumnIndex(Percent))
                        ,cursor.getInt(cursor.getColumnIndex(growers.VillageCode))
                        ,cursor.getInt(cursor.getColumnIndex(growers.GrowerCode))
                );
                shareDetails.add(pm);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return shareDetails;
    }
}
