package com.SENA.FlightManagementSystem.Flight.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SENA.FlightManagementSystem.Flight.DTO.request.FlightRequestDto;
import com.SENA.FlightManagementSystem.Flight.DTO.response.FlightResponseDto;
import com.SENA.FlightManagementSystem.Flight.Entity.Flight;
import com.SENA.FlightManagementSystem.Flight.IService.IFlightService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/flight")
public class FlightController extends AFlightBaseController<Flight, IFlightService, FlightRequestDto, FlightResponseDto> {

    public FlightController(IFlightService service) {
        super(service, "Flight");
    }

    @Override
    protected Flight convertToModel(FlightRequestDto dto) {
        Flight entity = new Flight();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        // Agrega aquí relaciones si las hay (solo setea id de referencia)
        return entity;
    }

    @Override
    protected FlightResponseDto convertToDto(Flight entity) {
        FlightResponseDto dto = new FlightResponseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        // Agrega aquí relaciones si las hay (solo setea id de referencia)
        return dto;
    }
}
