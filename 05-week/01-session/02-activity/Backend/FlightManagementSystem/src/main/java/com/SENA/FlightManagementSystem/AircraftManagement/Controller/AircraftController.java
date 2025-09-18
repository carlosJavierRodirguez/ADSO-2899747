package com.SENA.FlightManagementSystem.AircraftManagement.Controller;

import com.SENA.FlightManagementSystem.AircraftManagement.DTO.request.AircraftRequestDto;
import com.SENA.FlightManagementSystem.AircraftManagement.DTO.response.AircraftResponseDto;
import com.SENA.FlightManagementSystem.AircraftManagement.Entity.Arcraft;
import com.SENA.FlightManagementSystem.AircraftManagement.IService.IAircraftService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/aircraft")
public class AircraftController extends AAircraftManagementBaseController {


    public AircraftController(IAircraftService service) {
        // Constructor para inyección de dependencias
    }

    protected Arcraft convertToModel(AircraftRequestDto dto) {
        Arcraft entity = new Arcraft();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        // Agrega aquí relaciones si las hay
        return entity;
    }

    protected AircraftResponseDto convertToDto(Arcraft entity) {
        return AircraftResponseDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .status(entity.getStatus())
                // Agrega aquí relaciones si las hay
                .build();
    }
}
