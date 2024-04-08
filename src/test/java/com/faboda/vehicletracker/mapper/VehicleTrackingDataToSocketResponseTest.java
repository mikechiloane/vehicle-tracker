package com.faboda.vehicletracker.mapper;

import com.faboda.vehicletracker.model.VehicleTrackingData;
import com.faboda.vehicletracker.web.dto.SocketIOVehicleTrackingDataResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleTrackingDataToSocketResponseTest {

    @Test
    public void mapList_ValidData_ReturnsMappedList() {
        List<VehicleTrackingData> vehicleTrackingData = createMockVehicleData();

        List<SocketIOVehicleTrackingDataResponse> result = VehicleTrackingDataToSocketResponse.mapList(vehicleTrackingData);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(vehicleTrackingData.size());

        for (int i = 0; i < result.size(); i++) {
            SocketIOVehicleTrackingDataResponse response = result.get(i);
            VehicleTrackingData data = vehicleTrackingData.get(i);

            assertThat(response.getId()).isEqualTo(data.getId());
            assertThat(response.getLat()).isEqualTo(data.getLat());
            assertThat(response.getLon()).isEqualTo(data.getLon());
            assertThat(response.getStatus()).isEqualTo(data.getStatus());
            assertThat(response.getTimestamp()).isEqualTo(data.getTimestamp().toString());
            assertThat(response.getReg()).isEqualTo(data.getReg());
        }
    }

    private List<VehicleTrackingData> createMockVehicleData() {
        List<VehicleTrackingData> data = Arrays.asList(
                VehicleTrackingData.builder().reg("REG123").lat(12.3).lon(34.5).status("ACTIVE").timestamp(LocalDateTime.now()).build(),
                VehicleTrackingData.builder().reg("REG456").lat(15.8).lon(29.1).status("INACTIVE").timestamp(LocalDateTime.now()).build(),
                VehicleTrackingData.builder().reg("REG789").lat(7.8).lon(42.1).status("ACTIVE").timestamp(LocalDateTime.now()).build()
        );
        return data;
    }
}