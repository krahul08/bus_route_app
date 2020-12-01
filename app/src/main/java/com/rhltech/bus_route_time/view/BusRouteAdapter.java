package com.rhltech.bus_route_time.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rhltech.bus_route_time.R;
import com.rhltech.bus_route_time.data.model.RouteInfoData;

import java.text.ParseException;
import java.util.ArrayList;

public class BusRouteAdapter extends RecyclerView.Adapter<BusRouteAdapter.ViewHolder> {

    Context context;
    ArrayList<RouteInfoData> infoDataList;
    BusOnClickListener busOnClickListener;

    public BusRouteAdapter(Context context, ArrayList<RouteInfoData> infoDataList, BusOnClickListener busOnClickListener) {
        this.context = context;
        this.infoDataList = infoDataList;
        this.busOnClickListener = busOnClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.route_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RouteInfoData routeInfoData = infoDataList.get(position);
        holder.bus_name.setText(routeInfoData.getName());
        holder.source_destination.setText(routeInfoData.getDestination());
        holder.bus_duration.setText(routeInfoData.getTripDuration());
        holder.setClickListener(busOnClickListener);
    }

    @Override
    public int getItemCount() {
        return infoDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bus_name;
        private TextView source_destination;
        private TextView bus_duration;
        private BusOnClickListener busOnClickListener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bus_name = itemView.findViewById(R.id.bus_name);
            source_destination = itemView.findViewById(R.id.source_destination);
            bus_duration = itemView.findViewById(R.id.bus_duration);
            itemView.setOnClickListener(view -> {
                try {
                    busOnClickListener.onBusClicked(getAdapterPosition() + 1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }

        public void setClickListener(BusOnClickListener busOnClickListener) {
            this.busOnClickListener = busOnClickListener;
        }
    }
}
