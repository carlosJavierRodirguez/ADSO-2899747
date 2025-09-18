package com.SENA.FlightManagementSystem.HumanResources.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

public abstract class ABaseControllerHumanResources<T, S, Req, Res> {
    protected S service;
    protected String entityName;

    protected ABaseControllerHumanResources(S service, String entityName) {
        this.service = service;
        this.entityName = entityName;
    }

    protected abstract T convertToModel(Req dto);
    protected abstract Res convertToDto(T entity);

    // Métodos CRUD similares a Geolocation (puedes copiar la lógica de ABaseControllerGeolocation)
}
