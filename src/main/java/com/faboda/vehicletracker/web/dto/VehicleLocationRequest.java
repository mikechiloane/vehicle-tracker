package com.faboda.vehicletracker.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class VehicleLocationRequest {
    private String reg;
    private double lat;
    private double lon;
    private String status;
}
