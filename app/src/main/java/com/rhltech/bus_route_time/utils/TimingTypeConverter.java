package com.rhltech.bus_route_time.utils;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.rhltech.bus_route_time.data.model.RouteInfoData;

import java.util.List;

public class TimingTypeConverter {

//    if we add timings then we have to add particular table for particular timings, so skipped for time being.

    @TypeConverter
    public static List<RouteInfoData> restoreList(List<String> listOfString) {
        return new Gson().fromJson((JsonElement) listOfString, new TypeToken<List<String>>() {
        }.getType());
    }

    @TypeConverter
    public static String saveList(List<String> listOfString) {
        return new Gson().toJson(listOfString);
    }
}
