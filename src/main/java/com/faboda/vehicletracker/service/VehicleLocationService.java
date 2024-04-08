package com.faboda.vehicletracker.service;

import com.faboda.vehicletracker.model.VehicleTrackingData;
import com.faboda.vehicletracker.web.dto.VehicleLocationHistoryResponse;
import com.faboda.vehicletracker.web.dto.VehicleLocationRequest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface VehicleLocationService {
    VehicleLocationHistoryResponse getVehicleLocationHistory(String reg);
    List<VehicleTrackingData> getVehicleLocations();
    CompletableFuture<Void> addVehicleLocation(VehicleLocationRequest vehicleLocationRequest);

}
