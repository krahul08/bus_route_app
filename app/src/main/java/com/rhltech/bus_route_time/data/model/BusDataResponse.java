package com.rhltech.bus_route_time.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusDataResponse {

//    @PrimaryKey(autoGenerate = true)
//    private int primaryKey = 0;

    @SerializedName("routeInfo")
    @Expose
    private List<RouteInfoData> routeInfo;

    @SerializedName("routeTimings")
    @Expose
    private RouteTimingsData routeTimings;


    public List<RouteInfoData> getRouteInfo() {
        return routeInfo;
    }

    public void setRouteInfo(List<RouteInfoData> routeInfo) {
        this.routeInfo = routeInfo;
    }

    public RouteTimingsData getRouteTimings() {
        return routeTimings;
    }

    public void setRouteTimings(RouteTimingsData routeTimings) {
        this.routeTimings = routeTimings;
    }
}
