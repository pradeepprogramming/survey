package com.example.canesurvey.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.canesurvey.R;


public class DaySummary extends Fragment {
    private View view;
    public String TAG="DAY SUMMARY";

    public DaySummary() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_day_summary, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {



    }

}
