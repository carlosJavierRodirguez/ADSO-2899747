package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.DTO.StateDto;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Country;
import com.SENA.FlightManagementSystem.Geolocation.Entity.State;

import com.SENA.FlightManagementSystem.Geolocation.IService.IStateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/state")
public class StateController extends ABaseControllerGeolocation<State, IStateService, StateDto> {
    public StateController(IStateService service) {
        super(service, "State");
    }

    @Override
    protected State convertToModel(StateDto dto) {
        State entity = new State();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        if (dto.getCountryId() != null) {
            Country ref = new Country();
            ref.setId(dto.getCountryId());
            entity.setCountry(ref);
        }
        return entity;
    }

    @Override
    protected StateDto convertToDto(State entity) {
        StateDto dto = new StateDto();
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        if (entity.getCountry() != null) {
            dto.setCountryId(entity.getCountry().getId());
        }
        return dto;
    }
}
