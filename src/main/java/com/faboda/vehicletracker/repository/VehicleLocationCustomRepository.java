package com.faboda.vehicletracker.repository;

import com.faboda.vehicletracker.model.VehicleTrackingData;

import java.util.List;

public interface VehicleLocationCustomRepository {
    List<VehicleTrackingData> findLatestLocationRecordForEachReg();
    List<VehicleTrackingData> findByReg(String reg);

}
