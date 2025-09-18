package com.SENA.FlightManagementSystem.AircraftManagement.IRepository;

import com.SENA.FlightManagementSystem.AircraftManagement.Entity.Arcraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAircraftRepository extends JpaRepository<Arcraft, String> {
    // Métodos personalizados si es necesario
}
