package com.SENA.FlightManagementSystem.Flight.Controller;

import com.SENA.FlightManagementSystem.Flight.DTO.request.BaggageRequestDto;
import com.SENA.FlightManagementSystem.Flight.DTO.response.BaggageResponseDto;
import com.SENA.FlightManagementSystem.Flight.Entity.Baggage;
import com.SENA.FlightManagementSystem.Flight.IService.IBaggageService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/baggage")
public class BaggeController extends AFlightBaseController<Baggage, IBaggageService, BaggageRequestDto, BaggageResponseDto> {

   public BaggeController(IBaggageService service) {
       super(service, "Baggage");
   }

   @Override
   protected Baggage convertToModel(BaggageRequestDto dto) {
       Baggage entity = new Baggage();
       entity.setCode(dto.getCode());
       entity.setName(dto.getName());
       // Agrega aquí relaciones si las hay
       return entity;
   }

   @Override
   protected BaggageResponseDto convertToDto(Baggage entity) {
       return BaggageResponseDto.builder()
               .id(entity.getId())
               .code(entity.getCode())
               .name(entity.getName())
               // Agrega aquí relaciones si las hay
               .build();
   }
}
