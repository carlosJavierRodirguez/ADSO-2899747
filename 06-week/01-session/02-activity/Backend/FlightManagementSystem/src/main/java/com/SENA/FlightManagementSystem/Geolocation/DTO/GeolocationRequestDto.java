package com.SENA.FlightManagementSystem.Geolocation.DTO;

import lombok.Data;

@Data
public class GeolocationRequestDto {
    private String code;
    private String name;
    private String description;
    private Boolean status;
}
