package com.faboda.vehicletracker.service;

import com.corundumstudio.socketio.SocketIOServer;
import com.faboda.vehicletracker.model.VehicleTrackingData;
import com.faboda.vehicletracker.repository.VehicleLocationCustomRepository;
import com.faboda.vehicletracker.repository.VehicleLocationRepository;
import com.faboda.vehicletracker.web.dto.VehicleLocationHistoryResponse;
import com.faboda.vehicletracker.web.dto.VehicleLocationRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.StandardMongoClientSettingsBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class VehicleLocationServiceImplTest {

    @Autowired
    private VehicleLocationService vehicleLocationService;

    @MockBean
    private StandardMongoClientSettingsBuilderCustomizer standardMongoClientSettingsBuilderCustomizer;

    @MockBean
    private VehicleLocationRepository vehicleLocationRepository;

    @MockBean
    private VehicleLocationCustomRepository vehicleLocationCustomRepository;

    @MockBean
    private SocketIOServer socketIOServer;

    @Test
    public void getVehicleLocationHistory_ValidReg_ReturnsHistory() {
        String reg = "REG123";
        List<VehicleTrackingData> mockData = createMockVehicleData(reg);

        Mockito.when(vehicleLocationCustomRepository.findByReg(reg)).thenReturn(mockData);
        VehicleLocationHistoryResponse response = vehicleLocationService.getVehicleLocationHistory(reg);

        assertThat(response.getReg()).isEqualTo(reg);
    }

    @Test
    public void getVehicleLocations_ReturnsLatestLocations() {
        List<VehicleTrackingData> mockData = createMockVehicleData();

        Mockito.when(vehicleLocationCustomRepository.findLatestLocationRecordForEachReg()).thenReturn(mockData);

        List<VehicleTrackingData> locations = vehicleLocationService.getVehicleLocations();

    }

    private List<VehicleTrackingData> createMockVehicleData(String reg) {
        List<VehicleTrackingData> data = Arrays.asList(
                VehicleTrackingData.builder().reg(reg).lat(12.3).lon(34.5).timestamp(LocalDateTime.now().minusHours(1)).build(),
                VehicleTrackingData.builder().reg(reg).lat(15.8).lon(29.1).timestamp(LocalDateTime.now()).build(),
                VehicleTrackingData.builder().reg("REG789").lat(7.8).lon(42.1).timestamp(LocalDateTime.now()).build() // Different reg for latest locations test
        );
        return data;
    }

    private List<VehicleTrackingData> createMockVehicleData() {
        List<VehicleTrackingData> data = Arrays.asList(
                VehicleTrackingData.builder().reg("REG789").lat(7.8).lon(42.1).timestamp(LocalDateTime.now()).build(),
                VehicleTrackingData.builder().reg("REG951").lat(18.2).lon(13.4).timestamp(LocalDateTime.now().plusMinutes(5)).build(),
                VehicleTrackingData.builder().reg("REG123").lat(12.3).lon(34.5).timestamp(LocalDateTime.now().minusHours(1)).build(),
                VehicleTrackingData.builder().reg("REG456").lat(15.8).lon(29.1).timestamp(LocalDateTime.now()).build()
        );
        return data;
    }
}
