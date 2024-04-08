package com.faboda.vehicletracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class VehicleTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleTrackerApplication.class, args);
    }


}
