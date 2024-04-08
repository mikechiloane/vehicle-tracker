package com.faboda.vehicletracker.mapper;

import com.faboda.vehicletracker.model.Location;
import com.faboda.vehicletracker.model.VehicleTrackingData;

import java.util.List;

public class VehicleTrackingDataToLocation {

    public static Location map(VehicleTrackingData vehicleTrackingData) {
        return Location.builder()
                .lat(vehicleTrackingData.getLat())
                .lon(vehicleTrackingData.getLon())
                .timestamp(vehicleTrackingData.getTimestamp())
                .status(vehicleTrackingData.getStatus())
                .build();
    }

    public static Location[] map(List<VehicleTrackingData> vehicleTrackingDataList) {
        Location[] locations = new Location[vehicleTrackingDataList.size()];
        for (int i = 0; i < vehicleTrackingDataList.size(); i++) {
            locations[i] = map(vehicleTrackingDataList.get(i));
        }
        return locations;
    }

}

