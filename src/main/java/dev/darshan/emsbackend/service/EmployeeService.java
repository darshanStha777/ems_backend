package dev.darshan.emsbackend.service;

import dev.darshan.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id,EmployeeDto updateEmployeeDto);

    void deleteEmployee(Long id);


}
