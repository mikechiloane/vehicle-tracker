package com.faboda.vehicletracker.service;


import com.corundumstudio.socketio.SocketIOServer;
import com.faboda.vehicletracker.exceptions.MissingInputFieldException;
import com.faboda.vehicletracker.mapper.VehicleTrackingDataToLocation;
import com.faboda.vehicletracker.mapper.VehicleTrackingDataToSocketResponse;
import com.faboda.vehicletracker.model.VehicleTrackingData;
import com.faboda.vehicletracker.repository.VehicleLocationCustomRepository;
import com.faboda.vehicletracker.repository.VehicleLocationRepository;
import com.faboda.vehicletracker.web.dto.VehicleLocationHistoryResponse;
import com.faboda.vehicletracker.web.dto.VehicleLocationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class VehicleLocationServiceImpl implements VehicleLocationService {

    private final VehicleLocationRepository vehicleLocationRepository;
    private final VehicleLocationCustomRepository vehicleLocationCustomRepository;
    private final SocketIOServer socketIOServer;


    @Override
    public VehicleLocationHistoryResponse getVehicleLocationHistory(String reg) {
        List<VehicleTrackingData> vehicleTrackingData = vehicleLocationCustomRepository.findByReg(reg);
        return VehicleLocationHistoryResponse.builder()
                .reg(reg)
                .locations(VehicleTrackingDataToLocation.map(vehicleTrackingData))
                .build();
    }

    @Override
    public List<VehicleTrackingData> getVehicleLocations() {
        return vehicleLocationCustomRepository.findLatestLocationRecordForEachReg();
    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<Void> addVehicleLocation(VehicleLocationRequest vehicleLocationRequest) {

        VehicleTrackingData vehicleTrackingData = VehicleTrackingData.builder()
                .lat(vehicleLocationRequest.getLat())
                .lon(vehicleLocationRequest.getLon())
                .status(vehicleLocationRequest.getStatus())
                .reg(vehicleLocationRequest.getReg())
                .timestamp(LocalDateTime.now())
                .build();
        vehicleLocationRepository.save(vehicleTrackingData);

        socketIOServer.getBroadcastOperations().sendEvent("location", VehicleTrackingDataToSocketResponse.mapList(getVehicleLocations()));
        return CompletableFuture.completedFuture(null);
    }



}
