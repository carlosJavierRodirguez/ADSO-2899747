package com.SENA.FlightManagementSystem.AircraftManagement.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AircraftRequestDto {
    private String code;
    private String name;
    private String description;
    private Boolean status;
    // Agrega aquí relaciones si las hay (por ejemplo, ids de otras entidades)
}
