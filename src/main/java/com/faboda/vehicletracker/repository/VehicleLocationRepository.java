package com.faboda.vehicletracker.repository;

import com.faboda.vehicletracker.model.VehicleTrackingData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface VehicleLocationRepository extends MongoRepository<VehicleTrackingData, String>{
    @Query(value = "{ 'reg' : ?0 }")
    List<VehicleTrackingData> findByReg(String reg);
}
