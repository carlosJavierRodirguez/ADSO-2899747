package com.SENA.FlightManagementSystem.AircraftManagement.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AircraftResponseDto {
    private String id;
    private String code;
    private String name;
    private String description;
    private Boolean status;
    // Agrega aquí relaciones si las hay (por ejemplo, ids de otras entidades)
}
