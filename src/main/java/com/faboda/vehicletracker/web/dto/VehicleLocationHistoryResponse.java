package com.faboda.vehicletracker.web.dto;

import com.faboda.vehicletracker.model.Location;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VehicleLocationHistoryResponse {
    private String reg;
    private  Location[] locations;

}
