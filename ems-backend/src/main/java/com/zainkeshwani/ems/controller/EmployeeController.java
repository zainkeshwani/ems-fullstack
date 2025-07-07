package com.zainkeshwani.ems.controller;

import com.zainkeshwani.ems.Mapper.EmployeeMapper;
import com.zainkeshwani.ems.dto.EmployeeDto;
import com.zainkeshwani.ems.entity.Employee;
import com.zainkeshwani.ems.exception.ResourceNotFoundException;
import com.zainkeshwani.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //all clients can use this API
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //build addEmployee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) throws ResourceNotFoundException {
        EmployeeDto employee = employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employee);
    }

    //build get all employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    //build update employee REST API
    @PutMapping("{id}") //don't need a new thing like /update since this is a put not a get like other one
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,
                                                      @RequestBody EmployeeDto updatedEmployee) throws ResourceNotFoundException {
        EmployeeDto employeeDto = employeeService.updateEmployee(id, updatedEmployee);

        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) throws ResourceNotFoundException {
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }

}
