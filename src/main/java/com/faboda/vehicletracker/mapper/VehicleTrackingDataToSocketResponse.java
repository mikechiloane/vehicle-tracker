package com.faboda.vehicletracker.mapper;

import com.faboda.vehicletracker.model.VehicleTrackingData;
import com.faboda.vehicletracker.web.dto.SocketIOVehicleTrackingDataResponse;

import java.util.List;

public class VehicleTrackingDataToSocketResponse {
    public static List<SocketIOVehicleTrackingDataResponse> mapList(List<VehicleTrackingData> vehicleTrackingData) {
        List<SocketIOVehicleTrackingDataResponse> socketIOVehicleTrackingDataResponses =  new java.util.ArrayList<>();
        assert vehicleTrackingData != null;
        for (VehicleTrackingData data : vehicleTrackingData) {
            socketIOVehicleTrackingDataResponses.add(SocketIOVehicleTrackingDataResponse.builder()
                    .id(data.getId())
                    .lat(data.getLat())
                    .lon(data.getLon())
                    .status(data.getStatus())
                    .timestamp(data.getTimestamp().toString())
                    .reg(data.getReg())
                    .build());
        }
        return socketIOVehicleTrackingDataResponses;
    }
}
