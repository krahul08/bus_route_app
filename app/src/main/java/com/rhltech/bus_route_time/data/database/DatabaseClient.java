package com.rhltech.bus_route_time.data.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;

    // Bus app database object
    private BusDatabase busDatabase;

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;
        busDatabase = Room.databaseBuilder(mCtx, BusDatabase.class, "BUS_DATABASE").build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public BusDatabase getAppDatabase() {
        return busDatabase;
    }
}
