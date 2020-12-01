package com.rhltech.bus_route_time.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rhltech.bus_route_time.R;
import com.rhltech.bus_route_time.data.model.Timings;

import java.text.MessageFormat;
import java.util.List;

public class BusTimingAdapter extends RecyclerView.Adapter<BusTimingAdapter.ViewHolder> {

    private Context context;
    List<Timings> routeTimingsData;


    public BusTimingAdapter(Context context, List<Timings> routeTimingsData) {
        this.context = context;
        this.routeTimingsData = routeTimingsData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_timing_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.startTime.setText(String.format("Start time: %s", routeTimingsData.get(position).getTripStartTime()));
        holder.availableSeats.setText(MessageFormat.format("Available seats: {0}/{1}", routeTimingsData.get(position).getAvaiable(), routeTimingsData.get(position).getTotalSeats()));
    }

    @Override
    public int getItemCount() {
        return routeTimingsData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView startTime;
        TextView availableSeats;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            startTime = itemView.findViewById(R.id.start_time);
            availableSeats = itemView.findViewById(R.id.available_seats);
        }
    }

    public void updateList(List<Timings> routeTimingsData) {
        this.routeTimingsData = routeTimingsData;
        notifyDataSetChanged();
    }
}
