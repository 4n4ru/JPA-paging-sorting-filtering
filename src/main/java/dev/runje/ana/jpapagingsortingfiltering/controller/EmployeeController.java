package dev.runje.ana.jpapagingsortingfiltering.controller;

import dev.runje.ana.jpapagingsortingfiltering.model.Employee;
import dev.runje.ana.jpapagingsortingfiltering.model.EmployeePage;
import dev.runje.ana.jpapagingsortingfiltering.model.EmployeeSearchCriteria;
import dev.runje.ana.jpapagingsortingfiltering.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public ResponseEntity<Page<Employee>> getEmployeePage (EmployeePage employeePage,
                                                         EmployeeSearchCriteria employeeSearchCriteria) {
    return new ResponseEntity<>(employeeService.getEmployees(employeePage, employeeSearchCriteria), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
  }
}
