package com.SENA.FlightManagementSystem.Flight.Controller;

import com.SENA.FlightManagementSystem.Flight.DTO.request.TicketRequestDto;
import com.SENA.FlightManagementSystem.Flight.DTO.response.TicketResponseDto;
import com.SENA.FlightManagementSystem.Flight.Entity.Ticket;
import com.SENA.FlightManagementSystem.Flight.IService.ITicketService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/ticket")
public class TicketController extends AFlightBaseController<Ticket, ITicketService, TicketRequestDto, TicketResponseDto> {

   public TicketController(ITicketService service) {
       super(service, "Ticket");
   }

   @Override
   protected Ticket convertToModel(TicketRequestDto dto) {
       Ticket entity = new Ticket();
       entity.setCode(dto.getCode());
       entity.setName(dto.getName());
       // Agrega aquí relaciones si las hay
       return entity;
   }

   @Override
   protected TicketResponseDto convertToDto(Ticket entity) {
       return TicketResponseDto.builder()
               .id(entity.getId())
               .code(entity.getCode())
               .name(entity.getName())
               // Agrega aquí relaciones si las hay
               .build();
   }
}
