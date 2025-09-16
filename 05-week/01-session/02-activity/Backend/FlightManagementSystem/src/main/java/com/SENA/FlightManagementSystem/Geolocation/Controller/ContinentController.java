package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.DTO.ContinentDto;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Continent;
import com.SENA.FlightManagementSystem.Geolocation.IService.IContinentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/continent")
public class ContinentController extends ABaseControllerGeolocation<Continent, IContinentService, ContinentDto> {

    public ContinentController(IContinentService service) {
        super(service, "Continent");
    }

    @Override
    protected Continent convertToModel(ContinentDto dto) {
        Continent entity = new Continent();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    @Override
    protected ContinentDto convertToDto(Continent entity) {
        ContinentDto dto = new ContinentDto();
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
