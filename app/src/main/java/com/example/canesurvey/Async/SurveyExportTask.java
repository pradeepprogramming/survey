package com.example.canesurvey.Async;

import android.os.AsyncTask;

import com.example.canesurvey.Comman.CommanData;
import com.example.canesurvey.Comman.Path;
import com.example.canesurvey.Repository.ITaskComplete;
import com.example.canesurvey.model.GrowerModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SurveyExportTask extends AsyncTask<Void,Void,Boolean> {

    String errormsg="";
    String msg="";
    ITaskComplete task;
    String jsontoexport="";

    public SurveyExportTask(ITaskComplete Task,String json)
    {
        task=Task;
        jsontoexport=json;
    }


    @Override
    protected Boolean doInBackground(Void... voids) {
        String result=new UrlCalling().getResult(Path.exportsurvey+ CommanData.oprator.getCode()+"?surveydata="+jsontoexport,UrlCalling.Method.POST);
        if(result.length()>5)
        {
            try {

                JSONObject obj=new JSONObject(result);

                msg="All Survey Exported."+obj.getString("message");
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
