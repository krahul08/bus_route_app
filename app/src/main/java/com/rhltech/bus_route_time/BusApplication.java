package com.rhltech.bus_route_time;

import android.app.Application;

import com.rhltech.bus_route_time.data.database.BusDatabase;


public class BusApplication extends Application {

    //Could be used with different dependencies

    @Override
    public void onCreate() {
        super.onCreate();

//        BusDatabase busDatabase = BusDatabase.configDatabase(getApplicationContext());
//        busDatabase.getAppDao();

    }


}
