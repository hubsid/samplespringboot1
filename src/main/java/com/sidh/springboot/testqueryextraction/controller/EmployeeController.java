package com.sidh.springboot.testqueryextraction.controller;

import com.sidh.springboot.testqueryextraction.model.Employee;
import com.sidh.springboot.testqueryextraction.properties.CustomProperty;
import com.sidh.springboot.testqueryextraction.repo.EmployeeRepo;
import com.sidh.springboot.testqueryextraction.service.Jdbcservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
@ConfigurationProperties
public class EmployeeController {
    @Autowired
    EmployeeRepo repo;

    @GetMapping(value = "/get", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> everyEmployee() {
        List<Employee> employees = new ArrayList<>();
        repo.findAll().forEach(employees::add);
        return employees;
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee employeeWithId(@PathVariable int id) {
        Optional<Employee> byId = repo.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            Employee employee = new Employee();
            employee.setFirstname("employee not at all found !");
            return employee;
        }
    }

    @GetMapping("/shut")
    public void shutdown() {
        System.out.println("going to close...");
        System.exit(0);
    }

    @Value("${custom.property}")
    private String property;

    @GetMapping("propertyvalue")
    public String getpropertyValue() {
        return property;
    }


    @Value("${custom.random.secret}")
    String val1;
    @Value("${custom.random.int}")
    String val2;
    @Value("${custom.random.bigint}")
    String val3;
    @Value("${custom.random.uuid}")
    String val4;

    @GetMapping("randomproperty")
    public List<String> getrandompropertyvalues() {
        return Arrays.asList(val1, val2, val3, val4);
    }

    //not working
    @GetMapping("/yamlsmap")
    public Map<String, Object> getyamlsasmap() {
        return new YamlMapFactoryBean().getObject();
    }

    //not working
    @GetMapping("/yamls/{value}")
    public Object getSingleProperty(@PathVariable String value) {
        System.out.println("user entered property value : " + value);
        return new YamlMapFactoryBean().getObject().get(value);
    }

    @Autowired
    private CustomProperty customProperty;

    @GetMapping("/beanProperty")
    public String beanProperties() {
        return customProperty.toString();
    }

    @GetMapping("/error/{inputString}")
    public String geterror(@PathVariable String inputString) {
        inputString = null;
        return inputString.toUpperCase();
    }

    @Autowired
    Jdbcservice jdbcservice;

    @GetMapping("/jdbctest")
    public List<String> getallemployessnamelike() {
        return jdbcservice.serve();
    }

    @GetMapping("/getpaged/{page}")
    public List<String> getpagedresult(@PathVariable int page) {
        Page<Employee> employeePage = repo.findAll(PageRequest.of(page, 20));
        return employeePage.stream().map(e -> e.getFirstname()).collect(Collectors.toList());
    }

    @GetMapping("/getbycity/{city}")
    public List<String> sortedEmployees(@PathVariable String city) {
        return repo.findByCityOrderByFirstnameAsc(city).stream().map(e -> e.getFirstname()).collect(Collectors.toList());
    }

    @GetMapping("findbyname/{name}")
    public List<String> findbyname(@PathVariable String name) {
        return repo.findByFirstnameContainsIgnoreCaseOrderByFirstname(name).stream().map(Employee::getFirstname).collect(Collectors.toList());
    }

    @GetMapping(value = "/bylastname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findStringString(@PathVariable String name) {
        return repo.findByFirstnameContainsIgnoreCaseOrderByFirstname(name);
    }


    @GetMapping("/sorting")
    public List<List<String>> sortedfirstnames() {
        Sort sort = Sort.by("zip").ascending().and(Sort.by("firstname").descending());
        return repo.findAll(sort).stream().map(e ->
            new ArrayList<String>() {{
                add(e.getFirstname());
                add(String.valueOf(e.getZip()));
            }}).collect(Collectors.toList());
    }

    @GetMapping("/otherconditions/{conditionString}")
    public List<String> otherconditions(@PathVariable String conditionString) {
        return repo.findByFirstnameNotContains(conditionString).stream().map(Employee::getFirstname).collect(Collectors.toList());
    }

    @GetMapping("/inequality/{from}/{to}")
    public List<Integer> getzipbycondition(@PathVariable int from, @PathVariable int to) {
        return repo.findByZipBetween(from, to).stream().map(Employee::getZip)
                .sorted()
                .collect(Collectors.toList());
    }

}
