package dev.runje.ana.jpapagingsortingfiltering.service;

import dev.runje.ana.jpapagingsortingfiltering.model.Employee;
import dev.runje.ana.jpapagingsortingfiltering.model.EmployeePage;
import dev.runje.ana.jpapagingsortingfiltering.model.EmployeeSearchCriteria;
import dev.runje.ana.jpapagingsortingfiltering.repository.EmployeeCriteriaRepository;
import dev.runje.ana.jpapagingsortingfiltering.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final EmployeeCriteriaRepository employeeCriteriaRepository;

  public EmployeeService(EmployeeRepository employeeRepository, EmployeeCriteriaRepository employeeCriteriaRepository) {
    this.employeeRepository = employeeRepository;
    this.employeeCriteriaRepository = employeeCriteriaRepository;
  }

  public Page<Employee> getEmployees(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria){
    return employeeCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
  }

  public Employee addEmployee(Employee employee){
    return employeeRepository.save(employee);
  }
}
