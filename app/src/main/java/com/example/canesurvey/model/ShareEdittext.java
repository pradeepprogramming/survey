package com.example.canesurvey.model;

import android.view.View;
import android.widget.EditText;

public class ShareEdittext {
    EditText spercent,svill,sgrow,svillname,sgrowname;
    View row;

    public ShareEdittext(EditText spercent, EditText svill, EditText sgrow, EditText svillname, EditText sgrowname,View row) {
        this.spercent = spercent;
        this.svill = svill;
        this.sgrow = sgrow;
        this.svillname = svillname;
        this.sgrowname = sgrowname;
        this.row=row;
    }

    public View getRow() {
        return row;
    }

    public void setRow(View row) {
        this.row = row;
    }

    public EditText getSpercent() {
        return spercent;
    }

    public void setSpercent(EditText spercent) {
        this.spercent = spercent;
    }

    public EditText getSvill() {
        return svill;
    }

    public void setSvill(EditText svill) {
        this.svill = svill;
    }

    public EditText getSgrow() {
        return sgrow;
    }

    public void setSgrow(EditText sgrow) {
        this.sgrow = sgrow;
    }

    public EditText getSvillname() {
        return svillname;
    }

    public void setSvillname(EditText svillname) {
        this.svillname = svillname;
    }

    public EditText getSgrowname() {
        return sgrowname;
    }

    public void setSgrowname(EditText sgrowname) {
        this.sgrowname = sgrowname;
    }
}
