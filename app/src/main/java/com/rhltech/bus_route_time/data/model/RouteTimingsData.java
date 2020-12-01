package com.rhltech.bus_route_time.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RouteTimingsData {

    private int primaryKey = 0;

    @SerializedName("r002")
    @Expose
    private List<Timings> r002 = null;
    @SerializedName("r005")
    @Expose
    private List<Timings> r005 = null;
    @SerializedName("r001")
    @Expose
    private List<Timings> r001 = null;
    @SerializedName("r004")
    @Expose
    private List<Timings> r004 = null;
    @SerializedName("r003")
    @Expose
    private List<Timings> r003 = null;


    public List<Timings> getR002() {
        return r002;
    }

    public void setR002(List<Timings> r002) {
        this.r002 = r002;
    }

    public List<Timings> getR005() {
        return r005;
    }

    public void setR005(List<Timings> r005) {
        this.r005 = r005;
    }

    public List<Timings> getR001() {
        return r001;
    }

    public void setR001(List<Timings> r001) {
        this.r001 = r001;
    }

    public List<Timings> getR004() {
        return r004;
    }

    public void setR004(List<Timings> r004) {
        this.r004 = r004;
    }

    public List<Timings> getR003() {
        return r003;
    }

    public void setR003(List<Timings> r003) {
        this.r003 = r003;
    }
}
