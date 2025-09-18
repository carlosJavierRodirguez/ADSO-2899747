package com.SENA.FlightManagementSystem.Flight.Controller;

import com.SENA.FlightManagementSystem.Flight.DTO.request.CrewAssignmentRequestDto;
import com.SENA.FlightManagementSystem.Flight.DTO.response.CrewAssignmentResponseDto;
import com.SENA.FlightManagementSystem.Flight.Entity.CrewAssignment;
import com.SENA.FlightManagementSystem.Flight.IService.ICrewAssignmentService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/crew-assignment")
public class CrewAssignmentController extends AFlightBaseController<CrewAssignment, ICrewAssignmentService, CrewAssignmentRequestDto, CrewAssignmentResponseDto> {

    public CrewAssignmentController(ICrewAssignmentService service) {
        super(service, "CrewAssignment");
    }

    @Override
    protected CrewAssignment convertToModel(CrewAssignmentRequestDto dto) {
        CrewAssignment entity = new CrewAssignment();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        // Agrega aquí relaciones si las hay
        return entity;
    }

    @Override
    protected CrewAssignmentResponseDto convertToDto(CrewAssignment entity) {
        return CrewAssignmentResponseDto.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                // Agrega aquí relaciones si las hay
                .build();
    }
}