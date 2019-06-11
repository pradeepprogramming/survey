package com.example.canesurvey.View;


import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.canesurvey.Comman.CommanData;
import com.example.canesurvey.R;
import com.example.canesurvey.adapter.DaySummaryAdapter;
import com.example.canesurvey.model.CompleteSurveyModel;

import java.util.ArrayList;
import java.util.List;


public class DaySummary extends Fragment {
    private View view;
    public String TAG = "DAY SUMMARY";
    List<CompleteSurveyModel> surveyModels = new ArrayList<>();
    RecyclerView recyclerView;
    Activity mActivity;
    TextView tvNoRecord;

    public DaySummary() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_day_summary, container, false);
        mActivity =getActivity();
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        tvNoRecord =view.findViewById(R.id.tvNoRecord);
        recyclerView = view.findViewById(R.id.recyclerView);
        surveyModels = CommanData.conn.survey.getCompleteSurvey();

        Log.d(TAG, "initUI: "+surveyModels.size());
        if(surveyModels.size()>0) {
            tvNoRecord.setVisibility(View.GONE);
            DaySummaryAdapter mAdapter = new DaySummaryAdapter(mActivity, surveyModels);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mActivity);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }else {
            tvNoRecord.setVisibility(View.VISIBLE);
        }
    }

}
