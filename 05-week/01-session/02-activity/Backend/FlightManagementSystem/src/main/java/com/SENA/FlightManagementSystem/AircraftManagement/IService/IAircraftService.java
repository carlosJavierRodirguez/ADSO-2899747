package com.SENA.FlightManagementSystem.AircraftManagement.IService;

import com.SENA.FlightManagementSystem.AircraftManagement.Entity.Arcraft;
import java.util.List;

public interface IAircraftService extends IAircraftManagementBaseService {
    // Métodos específicos para Aircraft si es necesario
    List<Arcraft> findAll();
}
