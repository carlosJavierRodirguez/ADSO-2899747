package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.DTO.request.CityRequestDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.request.CountryRequestDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.response.CityResponseDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.response.CountryResponseDto;
import com.SENA.FlightManagementSystem.Geolocation.Entity.City;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Continent;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Country;
import com.SENA.FlightManagementSystem.Geolocation.Entity.State;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICityService;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/city")
public class CityController extends ABaseControllerGeolocation<
        City,
        ICityService,
        CityRequestDto,
        CityResponseDto> {

    public CityController(ICityService service) {
        super(service, "City");
    }

    @Override
    protected City convertToModel(CityRequestDto dto) {
        City entity = new City();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        if (dto.getStateId() != null) {
            State ref = new State();
            ref.setId(dto.getStateId());
            entity.setState(ref);
        }
        return entity;
    }

    @Override
    protected CityResponseDto convertToDto(City entity) {
        CityResponseDto dto = new CityResponseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        if (entity.getState() != null) {
            dto.setStateId(entity.getState().getId());
        }
        return dto;
    }
}
