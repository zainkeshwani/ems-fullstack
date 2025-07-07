package com.zainkeshwani.ems.service;

import com.zainkeshwani.ems.dto.EmployeeDto;
import com.zainkeshwani.ems.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto e);

    EmployeeDto getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) throws ResourceNotFoundException;

    void deleteEmployee(Long id) throws ResourceNotFoundException;
}
