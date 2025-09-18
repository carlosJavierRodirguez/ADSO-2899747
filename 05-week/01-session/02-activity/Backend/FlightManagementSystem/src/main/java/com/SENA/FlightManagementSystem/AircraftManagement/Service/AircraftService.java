package com.SENA.FlightManagementSystem.AircraftManagement.Service;

import com.SENA.FlightManagementSystem.AircraftManagement.Entity.Arcraft;
import com.SENA.FlightManagementSystem.AircraftManagement.IRepository.IAircraftRepository;
import com.SENA.FlightManagementSystem.AircraftManagement.IService.IAircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService extends AAircraftManagementBaseService implements IAircraftService {

    @Autowired
    private IAircraftRepository aircraftRepository;

    @Override
    public List<Arcraft> findAll() {
        return aircraftRepository.findAll();
    }
    // Implementa aquí otros métodos de negocio si es necesario
}
