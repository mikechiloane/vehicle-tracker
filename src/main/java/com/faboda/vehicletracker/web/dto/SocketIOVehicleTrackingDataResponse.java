package com.faboda.vehicletracker.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class SocketIOVehicleTrackingDataResponse {
    private String id;
    private double lat;
    private double lon;
    private String status;
    private String timestamp;
    private String reg;
}
