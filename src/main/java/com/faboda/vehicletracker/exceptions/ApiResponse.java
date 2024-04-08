package com.faboda.vehicletracker.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse {
    private HttpStatus status;
    private String error;
    private String message;

}