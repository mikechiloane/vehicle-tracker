package com.faboda.vehicletracker.aspect;

import com.faboda.vehicletracker.exceptions.MissingInputFieldException;
import com.faboda.vehicletracker.web.dto.VehicleLocationRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VehicleLocationAspect {

    @Before("execution(* com.faboda.vehicletracker.service.VehicleLocationServiceImpl.addVehicleLocation(..)) && args(vehicleLocationRequest)")
    public void checkRequiredFields(JoinPoint joinPoint, VehicleLocationRequest vehicleLocationRequest) {
        if (vehicleLocationRequest.getReg()== null || vehicleLocationRequest.getReg().isEmpty())
            throw new MissingInputFieldException("Vehicle registration number is required");
        if (vehicleLocationRequest.getLat() == 0 ) {
            throw new MissingInputFieldException("Invalid latitude value. Latitude is required");
        }
        if (vehicleLocationRequest.getLon() ==0)
            throw new MissingInputFieldException("Invalid longitude value. Longitude is required");
        if (vehicleLocationRequest.getStatus() == null || vehicleLocationRequest.getStatus().isEmpty())
            throw new MissingInputFieldException("Status is required");

    }
}
