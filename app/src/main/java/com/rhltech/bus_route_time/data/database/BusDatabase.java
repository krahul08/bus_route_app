package com.rhltech.bus_route_time.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.rhltech.bus_route_time.data.model.RouteInfoData;
import com.rhltech.bus_route_time.data.model.Timings;
import com.rhltech.bus_route_time.utils.RoutesTypeConverter;
import com.rhltech.bus_route_time.utils.TimingTypeConverter;

@Database(entities = {Timings.class, RouteInfoData.class}, exportSchema = false,
        version = 1)
@TypeConverters({RoutesTypeConverter.class, TimingTypeConverter.class})
public abstract class BusDatabase extends RoomDatabase {

    public abstract AppDao getAppDao();

    public static BusDatabase configDatabase(Context context) {
        BusDatabase db = Room.databaseBuilder(context,
                BusDatabase.class, "BUS_DATABASE").build();
        return db;
    }
}
