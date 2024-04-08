package com.faboda.vehicletracker;

import com.faboda.vehicletracker.repository.VehicleLocationRepository;
import com.faboda.vehicletracker.repository.VehicleLocationRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.mongo.StandardMongoClientSettingsBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class VehicleTrackerApplicationTests {

    @MockBean
    private VehicleLocationRepository vehicleLocationRepository;
    @MockBean
    private VehicleLocationRepositoryImpl vehicleLocationRepositoryImpl;

    @MockBean
    private StandardMongoClientSettingsBuilderCustomizer standardMongoClientSettingsBuilderCustomizer;

    @Test
    void contextLoads() {
    }

}
