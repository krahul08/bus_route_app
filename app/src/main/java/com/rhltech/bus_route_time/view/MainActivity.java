package com.rhltech.bus_route_time.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rhltech.bus_route_time.R;
import com.rhltech.bus_route_time.data.database.AppDao;
import com.rhltech.bus_route_time.data.model.BusDataResponse;
import com.rhltech.bus_route_time.data.model.RouteInfoData;
import com.rhltech.bus_route_time.data.model.RouteTimingsData;
import com.rhltech.bus_route_time.data.model.Timings;
import com.rhltech.bus_route_time.utils.Utils;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BusOnClickListener {

    private RecyclerView recyclerView;
    private RecyclerView verticalRecycler;

    private BusRouteAdapter busRouteAdapter;
    private BusTimingAdapter busTimingAdapter;
    private LinearLayoutManager layoutManager;
    RouteTimingsData rootTimeData;
    AppDao appDao;
    BusViewModel viewModel;


    private ArrayList<RouteInfoData> listToShowRoutes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        readJson();

        if (!listToShowRoutes.isEmpty()) {
            setHorizontalRecycler(listToShowRoutes);
        }
    }

    private void init() {
        viewModel = ViewModelProviders.of(this).get(BusViewModel.class);
        viewModel.configureOperations();
        recyclerView = findViewById(R.id.route_list);
        verticalRecycler = findViewById(R.id.timing_list);
    }

    private void readJson() {
        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "sample.json");
        assert jsonFileString != null;
        Log.i("data", jsonFileString);

        Gson gson = new Gson();
        Type listUserType = new TypeToken<BusDataResponse>() {
        }.getType();

        //For Horizontal Row
        BusDataResponse users = gson.fromJson(jsonFileString, listUserType);
        for (int i = 0; i < users.getRouteInfo().size(); i++) {
            listToShowRoutes.addAll(users.getRouteInfo());
            try {
                appDao.insertRoute(users.getRouteInfo().get(i));

            } catch (Exception e) {
                e.getMessage();
            }
        }


        //For Vertical Row
        rootTimeData = users.getRouteTimings();
        // setting only one to check if it is working.
        setVerticalRecycler(rootTimeData.getR002());

    }


    private void setVerticalRecycler(List<Timings> r002) {
        busTimingAdapter = new BusTimingAdapter(this, r002);
        verticalRecycler.setLayoutManager(new LinearLayoutManager(this));
        verticalRecycler.setAdapter(busTimingAdapter);
    }

    private void setHorizontalRecycler(ArrayList<RouteInfoData> listToShowRoutes) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        busRouteAdapter = new BusRouteAdapter(this, listToShowRoutes, this);
        recyclerView.setAdapter(busRouteAdapter);
    }

    @Override
    public void onBusClicked(int position) throws ParseException {
        switch (position) {
            case 1:
                drawVerticalRecycler(checkWithTheLatestTime(rootTimeData.getR002()));
            case 2:
                drawVerticalRecycler(checkWithTheLatestTime(rootTimeData.getR003()));
            case 3:
                drawVerticalRecycler(checkWithTheLatestTime(rootTimeData.getR004()));
            case 4:
                drawVerticalRecycler(checkWithTheLatestTime(rootTimeData.getR005()));
        }
    }

    private void drawVerticalRecycler(List<Timings> list) {
        if (busTimingAdapter != null) {
            busTimingAdapter.updateList(list);
        } else {
            layoutManager = new LinearLayoutManager(this);
            verticalRecycler.setLayoutManager(layoutManager);
            busTimingAdapter = new BusTimingAdapter(this, list);
            recyclerView.setAdapter(busRouteAdapter);
        }
    }

    private List<Timings> checkWithTheLatestTime(List<Timings> timings) throws ParseException {
        List<Timings> listDataTimings = new ArrayList<>();

        //comparing time and returning list
        viewModel.getTimeBasedOnCurrentTime(timings).observe(this, new Observer<List<Timings>>() {
            @Override
            public void onChanged(List<Timings> timings) {
                for (int i = 0; i <= timings.size() - 1; i++) {
                    listDataTimings.add(timings.get(i));
                }
            }
        });
        return timings;
    }
}