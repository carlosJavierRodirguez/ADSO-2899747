package com.SENA.FlightManagementSystem.Flight.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrewAssignmentResponseDto {
    private String id;
    private String code;
    private String name;
    // Agrega aquí campos adicionales y relaciones si las hay
}
