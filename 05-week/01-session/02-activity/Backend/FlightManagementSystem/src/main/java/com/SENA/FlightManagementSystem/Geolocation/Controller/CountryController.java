package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.DTO.CountryDto;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Continent;
import com.SENA.FlightManagementSystem.Geolocation.Entity.Country;
import com.SENA.FlightManagementSystem.Geolocation.IService.ICountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/country")
public class CountryController extends ABaseControllerGeolocation<Country, ICountryService, CountryDto> {
    public CountryController(ICountryService service) {
        super(service, "Country");
    }

    @Override
    protected Country convertToModel(CountryDto dto) {
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
    protected CountryDto convertToDto(Country entity) {
        CountryDto dto = new CountryDto();
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
