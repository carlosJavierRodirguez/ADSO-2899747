package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.DTO.request.CountryRequestDto;
import com.SENA.FlightManagementSystem.Geolocation.DTO.response.CountryResponseDto;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Continent;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Country;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICountryService;
import com.SENA.FlightManagementSystem.Geolocation.IService.IStateService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/country")
public class CountryController extends ABaseControllerGeolocation<
        Country,
        ICountryService,
        CountryRequestDto,
        CountryResponseDto> {

    public CountryController(ICountryService service) {
        super(service, "Country");
    }

    @Override
    protected Country convertToModel(CountryRequestDto dto) {
        Country entity = new Country();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        if (dto.getContinentId() != null) {
            Continent ref = new Continent();
            ref.setId(dto.getContinentId());
            entity.setContinent(ref);
        }
        return entity;
    }

    @Override
    protected CountryResponseDto convertToDto(Country entity) {
        CountryResponseDto dto = new CountryResponseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        if (entity.getContinent() != null) {
            dto.setContinentId(entity.getContinent().getId());
        }
        return dto;
    }
}
