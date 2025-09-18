package com.SENA.FlightManagementSystem.Flight.DTO;

import com.SENA.FlightManagementSystem.DTO.BaseDTO;
import lombok.Data;

@Data
public class FlightBaseDTO extends BaseDTO {
    private String code;
    private String name;
    // Puedes agregar aquí campos comunes de Flight si los hay
}
