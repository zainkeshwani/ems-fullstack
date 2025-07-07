package com.zainkeshwani.ems.service.impl;

import com.zainkeshwani.ems.Mapper.EmployeeMapper;
import com.zainkeshwani.ems.dto.EmployeeDto;
import com.zainkeshwani.ems.entity.Employee;
import com.zainkeshwani.ems.exception.ResourceNotFoundException;
import com.zainkeshwani.ems.repository.EmployeeRepository;
import com.zainkeshwani.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto e) {
        Employee savedEmployee = employeeRepository.save(EmployeeMapper.mapToEmployee(e));
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No employee exists with the given id."));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) ->
                        EmployeeMapper.mapToEmployeeDto(employee))
                        .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No employee exists with that id."));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee finalUpdated = employeeRepository.save(employee); // will save,
        // and if it doesn't already contain Employee with this id it'll auto make a new one

        return EmployeeMapper.mapToEmployeeDto(finalUpdated);
    }

    @Override
    public void deleteEmployee(Long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No employee exists with that id."));
        //use the above to check if it exists so that the exception can be
        // thrown since the below method is return type void

        employeeRepository.deleteById(id);
    }
}
