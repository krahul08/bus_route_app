package com.rhltech.bus_route_time.utils;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.rhltech.bus_route_time.data.model.RouteInfoData;

import java.io.Serializable;
import java.util.List;

public class RoutesTypeConverter implements Serializable {

    @TypeConverter
    public static List<RouteInfoData> restoreList(List<RouteInfoData> listOfString) {
        return new Gson().fromJson((JsonElement) listOfString, new TypeToken<List<RouteInfoData>>() {
        }.getType());
    }

    @TypeConverter
    public static String saveList(List<RouteInfoData> listOfString) {
        return new Gson().toJson(listOfString);
    }
}
