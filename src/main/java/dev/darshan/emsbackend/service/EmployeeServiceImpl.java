package dev.darshan.emsbackend.service;

import dev.darshan.emsbackend.dto.EmployeeDto;
import dev.darshan.emsbackend.entity.Employee;
import dev.darshan.emsbackend.exception.ResourceNotFundException;
import dev.darshan.emsbackend.mapper.EmployeeMapper;
import dev.darshan.emsbackend.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeesRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
       return employees.stream().map((employee -> EmployeeMapper.toEmployeeDto(employee)))
               .collect(Collectors.toUnmodifiableList());

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
           Employee employee= employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFundException("Employee not found with id " + employeeId));
        return EmployeeMapper.toEmployeeDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployeeDto) {
     Employee employee=   employeeRepository.findById(employeeId).orElseThrow(
               () -> new ResourceNotFundException("Employee not found with id " + employeeId));
        employee.setFirstName(updateEmployeeDto.getFirstName());
        employee.setLastName(updateEmployeeDto.getLastName());
        employee.setEmail(updateEmployeeDto.getEmail());
        Employee updateemployee= employeeRepository.save(employee);
        return EmployeeMapper.toEmployeeDto(updateemployee);

    }

    @Override
    public void deleteEmployee(Long employeeId  ) {
        Employee employee=   employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFundException("Employee not found with id " + employeeId));
        employeeRepository.deleteById(employeeId);

    }


}
