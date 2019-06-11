package com.example.canesurvey.model;

import org.json.JSONException;
import org.json.JSONObject;

public class CompleteSurveyModel extends SurveyModel {

    private PlotLcationModel plotlocation;

    public JSONObject getJsonobj(int vill,int grow) throws JSONException {
        JSONObject jobj=new JSONObject();
        jobj.put("growerid",getGrowerid());
        jobj.put("vill",vill);
        jobj.put("grow",grow);
        jobj.put("area",getArea());
        jobj.put("area",getArea());
        jobj.put("area",getArea());
        jobj.put("area",getArea());
        jobj.put("area",getArea());
        jobj.put("area",getArea());
        jobj.put("area",getArea());
        return jobj;
    }

}
