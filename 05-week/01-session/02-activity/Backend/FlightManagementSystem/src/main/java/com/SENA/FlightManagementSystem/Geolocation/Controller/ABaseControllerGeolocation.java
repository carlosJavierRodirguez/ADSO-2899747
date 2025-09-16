package com.SENA.FlightManagementSystem.Geolocation.Controller;

import com.SENA.FlightManagementSystem.Geolocation.Entity.ABaseEntityGeo;
import com.SENA.FlightManagementSystem.Geolocation.IService.IBaseServiceGeolocation;
import com.SENA.FlightManagementSystem.Infrastructure.DTO.ApiResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ABaseControllerGeolocation<T extends ABaseEntityGeo, S extends IBaseServiceGeolocation<T>, D> {
    protected S service;
    protected String entityName;

    protected ABaseControllerGeolocation(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    protected abstract T convertToModel(D dto);

    protected abstract D convertToDto(T entity);

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<D>>> findByStateTrue() {
        try {
            List<D> data = service.findByStateTrue()
                    .stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(new ApiResponseDto<List<D>>("Datos obtenidos", data, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<D>>(e.getMessage(), null, false));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto<Optional<D>>> show(@PathVariable String id) {
        try {
            Optional<D> dto = service.findById(id).map(this::convertToDto);
            return ResponseEntity.ok(new ApiResponseDto<Optional<D>>("Registro encontrado", dto, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponseDto<Optional<D>>(e.getMessage(), null, false));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponseDto<D>> save(@RequestBody D dto) {
        try {
            T saved = service.save(convertToModel(dto));
            return ResponseEntity.ok(new ApiResponseDto<D>("Datos guardados", convertToDto(saved), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<D>(e.getMessage(), null, false));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponseDto<D>> update(@PathVariable String id, @RequestBody D dto) {
        try {
            service.update(id, convertToModel(dto));
            return ResponseEntity.ok(new ApiResponseDto<D>("Datos actualizados", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<D>(e.getMessage(), null, false));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseDto<D>> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new ApiResponseDto<D>("Registro eliminado", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<D>(e.getMessage(), null, false));
        }
    }
}
