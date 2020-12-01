package com.rhltech.bus_route_time.view;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rhltech.bus_route_time.data.model.Timings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BusViewModel extends ViewModel {

    SimpleDateFormat simpleDateFormat;
    String pattern;
    Calendar calendar;
    String currentTime;
    Date startTime;
    Date endTime;

    @SuppressLint("SimpleDateFormat")
    public void configureOperations() {
        calendar = Calendar.getInstance();
        pattern = "HH::mm";
        simpleDateFormat = new SimpleDateFormat(pattern);

        //setting current time
        currentTime = simpleDateFormat.format(calendar.getTime());

    }

    MutableLiveData<List<Timings>> filteredTime = new MutableLiveData<>();

    public MutableLiveData<List<Timings>> getTimeBasedOnCurrentTime(List<Timings> timingsDataList) throws ParseException {
        ArrayList<Timings> futureTimings = new ArrayList<>();

        // This method is left because of less understanding of JSON
        futureTimings.clear();
        for (int i = 0; i <= timingsDataList.size() - 1; i++) {
            startTime = simpleDateFormat.parse(timingsDataList.get(i).getTripStartTime());
            endTime = simpleDateFormat.parse(currentTime);

            //Trying with Date, because im not getting any date thing from json.
            if (startTime.before(endTime)) {
                futureTimings.add(timingsDataList.get(i));
            }
        }
        if (futureTimings.size() > 0) {
            filteredTime.postValue(futureTimings);
        }
        return filteredTime;
    }

}