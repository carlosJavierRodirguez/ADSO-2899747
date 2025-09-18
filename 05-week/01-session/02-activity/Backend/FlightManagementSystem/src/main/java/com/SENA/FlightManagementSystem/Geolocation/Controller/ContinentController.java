package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.DTO.request.ContinentRequestDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.response.BaseResponseDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.response.ContinentResponseDto;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Continent;
import com.SENA.FlightManagementSystem.Geolocation.IService.IContinentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/continent")
public class ContinentController extends ABaseControllerGeolocation<
        Continent,
        IContinentService,
        ContinentRequestDto,
        ContinentResponseDto> {

    public ContinentController(IContinentService service) {
        super(service, "Continent");
    }

    @Override
    protected Continent convertToModel(ContinentRequestDto dto) {
        Continent entity = new Continent();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    @Override
    protected ContinentResponseDto convertToDto(Continent entity) {
        ContinentResponseDto dto = new ContinentResponseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}

