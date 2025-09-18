package com.SENA.FlightManagementSystem.Geolocation.DTO.response;

import com.SENA.FlightManagementSystem.Geolocation.DTO.BaseDTO;
import lombok.Data;

@Data
public class CityResponseDto extends BaseResponseDto {
    private String stateId;
}
