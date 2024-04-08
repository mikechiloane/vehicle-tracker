package com.faboda.vehicletracker.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Location {
    private double lat;
    private double lon;
    private String status;
    private LocalDateTime timestamp;
}
