package com.faboda.vehicletracker.mapper;

import com.faboda.vehicletracker.model.VehicleTrackingData;
import com.faboda.vehicletracker.model.Location;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleTrackingDataToLocationTest {

    private VehicleTrackingDataToLocation mapper = new VehicleTrackingDataToLocation();

    @Test
    public void map_ValidData_ReturnsLocation() {
        VehicleTrackingData trackingData = VehicleTrackingData.builder()
                .reg("REG123")
                .lat(12.3)
                .lon(34.5)
                .timestamp(LocalDateTime.now())
                .build();

        Location location = mapper.map(trackingData);

        assertThat(location.getLat()).isEqualTo(trackingData.getLat());
        assertThat(location.getLon()).isEqualTo(trackingData.getLon());
        assertThat(location.getTimestamp()).isEqualTo(trackingData.getTimestamp());
    }
}