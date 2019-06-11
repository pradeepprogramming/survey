package com.example.canesurvey.Async;

import android.os.AsyncTask;

import com.example.canesurvey.Comman.CommanData;
import com.example.canesurvey.Comman.Path;
import com.example.canesurvey.Repository.ITaskComplete;
import com.example.canesurvey.model.IrrigatiaonModel;
import com.example.canesurvey.model.VillageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAllIrrigationTask extends AsyncTask<Void,Void,Boolean> {


    String errormsg="";
    String msg="";
    ITaskComplete task;
    public GetAllIrrigationTask(ITaskComplete Task)
    {
        task=Task;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        String result=new UrlCalling().getResult(Path.getirrigations,UrlCalling.Method.GET);
        if(result.length()>5)
        {
            try {

                JSONArray rootarr=new JSONArray(result);

                CommanData.conn.irrigation.truncateTable();

                for(int i=0;i<rootarr.length();i++) {
                    JSONObject dataobj = rootarr.getJSONObject(i);
                    IrrigatiaonModel rt = new IrrigatiaonModel(
                            dataobj.getInt("code"),
                            dataobj.getString("name")

                    );
                    CommanData.conn.irrigation.Add(rt);
                }
                msg="All Irrigations Imported.";
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                errormsg=e.getMessage();
                return false;
            }
        }
        else
        {
            msg="No Data Returned.";
            return true;
        }


    }
    protected  void onPostExecute(Boolean success)
    {
        if(success)
        {
            task.OnTaskComplete(success,msg);
        }
        else
        {
            task.OnTaskComplete(success,errormsg);
        }
    }
}
