package dev.runje.ana.jpapagingsortingfiltering.repository;

import dev.runje.ana.jpapagingsortingfiltering.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
