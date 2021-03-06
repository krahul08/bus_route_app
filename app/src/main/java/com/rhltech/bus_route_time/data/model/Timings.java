package com.rhltech.bus_route_time.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "TIMINGS")
public class Timings {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("totalSeats")
    @Expose
    private Integer totalSeats;
    @SerializedName("avaiable")
    @Expose
    private Integer avaiable;
    @SerializedName("tripStartTime")
    @Expose
    private String tripStartTime;

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getAvaiable() {
        return avaiable;
    }

    public void setAvaiable(Integer avaiable) {
        this.avaiable = avaiable;
    }

    public String getTripStartTime() {
        return tripStartTime;
    }

    public void setTripStartTime(String tripStartTime) {
        this.tripStartTime = tripStartTime;
    }
}
