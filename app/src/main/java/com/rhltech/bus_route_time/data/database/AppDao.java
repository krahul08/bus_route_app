package com.rhltech.bus_route_time.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.rhltech.bus_route_time.data.model.RouteInfoData;

import java.util.List;

@Dao
public interface AppDao {
    @Insert
    void insertRoute(RouteInfoData routeInfoData);

    @Query("select * from route_data")
    List<RouteInfoData> getAllRoutes();

/*    @Insert
    public void insertTimings(RouteTimingsData routeTimingsData);*/

//    @Insert
//    public void insertSubTimings(Timings timings);

//    @Query("select * from timing_data")
//    public List<Timings> getTimings();

}
