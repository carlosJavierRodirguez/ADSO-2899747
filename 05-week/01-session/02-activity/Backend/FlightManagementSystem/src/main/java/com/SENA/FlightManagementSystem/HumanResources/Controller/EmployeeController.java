package com.SENA.FlightManagementSystem.HumanResources.Controller;

import com.SENA.FlightManagementSystem.HumanResources.DTO.request.EmployeeRequestDto;
import com.SENA.FlightManagementSystem.HumanResources.DTO.response.EmployeeResponseDto;
import com.SENA.FlightManagementSystem.HumanResources.Entity.Employee;
import com.SENA.FlightManagementSystem.HumanResources.IService.IEmployeeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/employee")
public class EmployeeController extends ABaseControllerHumanResources<
        Employee,
        IEmployeeService,
        EmployeeRequestDto,
        EmployeeResponseDto> {

    public EmployeeController(IEmployeeService service) {
        super(service, "Employee");
    }

    @Override
    protected Employee convertToModel(EmployeeRequestDto dto) {
        Employee entity = new Employee();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        // Relaciones: solo setea id de referencia si aplica
        return entity;
    }

    @Override
    protected EmployeeResponseDto convertToDto(Employee entity) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        // Relaciones: solo setea id de referencia si aplica
        return dto;
    }
}
