package com.SENA.FlightManagementSystem.HumanResources.IService;

import com.SENA.FlightManagementSystem.HumanResources.Entity.Employee;
import java.util.List;

public interface IEmployeeService extends IBaseService<Employee> {
    // Métodos específicos para Employee si es necesario
    List<Employee> findAll();
}
