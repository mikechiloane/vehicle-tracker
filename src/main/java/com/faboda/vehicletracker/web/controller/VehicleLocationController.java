package com.faboda.vehicletracker.web.controller;


import com.faboda.vehicletracker.model.VehicleTrackingData;
import com.faboda.vehicletracker.service.VehicleLocationService;
import com.faboda.vehicletracker.web.dto.VehicleLocationHistoryResponse;
import com.faboda.vehicletracker.web.dto.VehicleLocationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle/location")
@RequiredArgsConstructor
public class VehicleLocationController {

//    private final SimpMessagingTemplate simpMessagingTemplate;
    private final VehicleLocationService vehicleLocationService;

    @MessageMapping("/location")
    @SendTo("/topic/location")
    public String send(@Payload VehicleLocationRequest vehicleLocationRequest) {
        return "hello";
    }

    @PostMapping
    public void addVehicleLocation(@RequestBody VehicleLocationRequest vehicleLocationRequest){
        vehicleLocationService.addVehicleLocation(vehicleLocationRequest);
    }
    @GetMapping
    public List<VehicleTrackingData> getVehicleLocations(){
        return vehicleLocationService.getVehicleLocations();
    }
    @GetMapping("/history/{reg}")
    public VehicleLocationHistoryResponse getVehicleLocationHistory(@PathVariable String reg){
        return vehicleLocationService.getVehicleLocationHistory(reg);
    }
}
