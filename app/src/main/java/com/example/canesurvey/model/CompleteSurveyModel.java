package com.example.canesurvey.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class CompleteSurveyModel extends SurveyModel {

    private List<PlotLcationModel> plotlocations;
    private int grow;
    private int vill;

    public List<PlotLcationModel> getPlotlocations() {
        return plotlocations;
    }

    public void setPlotlocations(List<PlotLcationModel> plotlocations) {
        this.plotlocations = plotlocations;
    }

    public int getGrow() {
        return grow;
    }

    public void setGrow(int grow) {
        this.grow = grow;
    }

    public int getVill() {
        return vill;
    }

    public void setVill(int vill) {
        this.vill = vill;
    }

    public JSONObject getJsonobj() throws JSONException {
        JSONObject jobj=new JSONObject();
        jobj.put("growerid",getGrowerid());
        jobj.put("vill",vill);
        jobj.put("grow",grow);
        jobj.put("area",getArea());
        jobj.put("variety",getVariety());
        jobj.put("irrigation",getIrrigation());
        jobj.put("plantation",getPlantationmethod());
        jobj.put("plantationdate",getPlantationdate());
        jobj.put("mobile",getMobile());
        jobj.put("aadhar",getAadhar());
        jobj.put("sharepercent",getSharepercent());
        JSONArray ar=new JSONArray();
        for (PlotLcationModel plot:plotlocations
             ) {
            JSONObject jo=new JSONObject().put("corner",plot.getCorner())
                    .put("lat",plot.getLat())
                    .put("lang",plot.getLang())
                    .put("meter",plot.getMeter());
            ar.put(jo);
        }

        jobj.put("plotlocations",ar);
        return jobj;
    }

}
