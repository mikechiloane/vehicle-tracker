package com.faboda.vehicletracker.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Document(collection = "vehicle_tracking_data")
@Data
@Builder
@AllArgsConstructor
public class VehicleTrackingData {

    private String id;
    private double lat;
    private double lon;
    private String status;
    private LocalDateTime timestamp;
    private String reg;

}
