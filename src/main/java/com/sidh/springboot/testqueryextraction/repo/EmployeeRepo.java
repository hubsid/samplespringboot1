package com.sidh.springboot.testqueryextraction.repo;

import com.sidh.springboot.testqueryextraction.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo  extends JpaRepository<Employee, Integer> {
//    List<Employee> findAllOrderByFirstnameAsc();
    List<Employee> findByCityOrderByFirstnameAsc(String city);

    List<Employee> findByFirstname(String name, Sort pageable);

    List<Employee> findByFirstnameContainsIgnoreCaseOrderByFirstname(String name);

    List<Employee> findByFirstnameNotContains(String startKeyword);

    List<Employee> findByZipBetween(int input, int to);

}
