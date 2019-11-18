package com.sidh.springboot.testqueryextraction.repo;

import com.sidh.springboot.testqueryextraction.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo  extends JpaRepository<Employee, Integer> {
//    List<Employee> findAllOrderByFirstnameAsc();
    List<Employee> findByCityOrderByFirstnameAsc(String city);

    List<Employee> findFirstnameByFirstnameIgnoreCase(String name);

    List<Employee> findByFirstName(String name, Sort pageable);
}
