package com.SENA.FlightManagementSystem.Geolocation.DTO;

/**
 * DTO base con campos comunes para requests/responses de Geolocation.
 */
import lombok.Data;

@Data
public class BaseDTO {
    
    private String code;
    private String name;
    private String description;
    private Boolean status;

}
