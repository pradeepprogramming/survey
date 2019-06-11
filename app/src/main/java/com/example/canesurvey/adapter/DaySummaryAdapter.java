package com.example.canesurvey.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.canesurvey.R;
import com.example.canesurvey.model.CompleteSurveyModel;
import java.util.List;

public class DaySummaryAdapter extends RecyclerView.Adapter<DaySummaryAdapter.MyHolder> {

    Context mContext;
    List<CompleteSurveyModel> arrayList;

    public DaySummaryAdapter(Context mContext, List<CompleteSurveyModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_summary_item, parent, false);
        return new DaySummaryAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvPlotVill.setText(String.valueOf(arrayList.get(position).getPlotvillagecode()));
        holder.tvPlotVillName.setText(String.valueOf(arrayList.get(position).getPlotvillname()));
        holder.tvVillCode.setText(String.valueOf(arrayList.get(position).getVill()));
        holder.tvVillName.setText(String.valueOf(arrayList.get(position).getVillagename()));
        holder.tvGrowerCode.setText(String.valueOf(arrayList.get(position).getGrow()));
        holder.tvGrowerName.setText(String.valueOf(arrayList.get(position).getGrowername()));
        holder.tvFatherName.setText(String.valueOf(arrayList.get(position).getFathername()));
        holder.tvVarty.setText(String.valueOf(arrayList.get(position).getVariety()));
        holder.tvCaneArea.setText(String.valueOf(arrayList.get(position).getArea()));
        holder.tvMobileNumber.setText(String.valueOf(arrayList.get(position).getMobile()));

        holder.tvType.setText("0");
        holder.tvDataFrom.setText("0");

        holder.tvCorner1.setText(""+arrayList.get(position).getPlotlocations().get(0).getMeter());
        holder.tvCorner2.setText(""+arrayList.get(position).getPlotlocations().get(1).getMeter());
        holder.tvCorner3.setText(""+arrayList.get(position).getPlotlocations().get(2).getMeter());
        holder.tvCorner4.setText(""+arrayList.get(position).getPlotlocations().get(3).getMeter());


        Log.d(">>>", "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView tvGrowerName, tvVarty, tvCaneType, tvGrowerCode,tvPlotVill,tvVillName,tvVillCode,
                tvFatherName, tvMobileNumber, tvCaneArea, tvType, tvDataFrom, tvCorner1, tvCorner2, tvCorner3, tvCorner4,tvPlotVillName;

        public MyHolder(@NonNull View view) {
            super(view);
            tvGrowerName = view.findViewById(R.id.tvGrowerName);
            tvVarty = view.findViewById(R.id.tvVarty);
            tvCaneType = view.findViewById(R.id.tvCaneType);
            tvPlotVillName = view.findViewById(R.id.tvPlotVillName);
            tvGrowerCode = view.findViewById(R.id.tvGrowerCode);

            tvMobileNumber = view.findViewById(R.id.tvMobileNumber);
            tvCaneArea = view.findViewById(R.id.tvCaneArea);
            tvPlotVill = view.findViewById(R.id.tvPlotVill);
            tvVillName = view.findViewById(R.id.tvVillName);
            tvVillCode = view.findViewById(R.id.tvVillCode);
            tvFatherName = view.findViewById(R.id.tvFatherName);


            tvType = view.findViewById(R.id.tvType);
            tvDataFrom = view.findViewById(R.id.tvDataFrom);
            tvCorner1 = view.findViewById(R.id.tvCorner1);
            tvCorner2 = view.findViewById(R.id.tvCorner2);
            tvCorner3 = view.findViewById(R.id.tvCorner3);
            tvCorner4 = view.findViewById(R.id.tvCorner4);
        }
    }
}
