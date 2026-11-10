package dev.darshan.emsbackend.repository;

import dev.darshan.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
