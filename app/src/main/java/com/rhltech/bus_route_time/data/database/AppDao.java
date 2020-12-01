package com.rhltech.bus_route_time.data.database;

import androidx.room.Dao;
import androidx.room.Insert;

import com.rhltech.bus_route_time.data.model.RouteInfoData;

@Dao
public interface AppDao {

    @Insert
    public void insertRoute(RouteInfoData routeInfoData);

//    @Query("select * from route_data sort by ASC")
//    public List<RouteInfoData> getAllRoutes();

/*    @Insert
    public void insertTimings(RouteTimingsData routeTimingsData);*/


//    @Insert
//    public void insertSubTimings(Timings timings);

//    @Query("select * from timing_data")
//    public List<Timings> getTimings();


}
