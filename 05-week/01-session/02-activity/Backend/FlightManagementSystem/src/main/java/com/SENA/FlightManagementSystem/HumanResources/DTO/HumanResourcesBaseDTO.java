package com.SENA.FlightManagementSystem.HumanResources.DTO;

import com.SENA.FlightManagementSystem.DTO.BaseDTO;
import lombok.Data;

@Data
public class HumanResourcesBaseDTO extends BaseDTO {
    private String code;
    private String name;
    private String description;
    // Puedes agregar aquí campos comunes de HumanResources si los hay
}
