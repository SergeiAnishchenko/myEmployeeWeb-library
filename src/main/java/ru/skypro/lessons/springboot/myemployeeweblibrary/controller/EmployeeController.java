package ru.skypro.lessons.springboot.myemployeeweblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/salary/sum")
    public double getSumOfSalaries() {
        return employeeService.getSumOfSalaries();
    }

    @GetMapping("/salary/min")
    public Employee getMinimumWageEmployee() {
        return employeeService.getMinimumWageEmployee();
    }

    @GetMapping("/salary/max")
    public Employee getMaxWageEmployee() {
        return employeeService.getMaxWageEmployee();
    }

    @GetMapping("/high-salary")
    public List<Employee> getAllEmployeesWithHighSalary() {
        return employeeService.getAllEmployeesWithHighSalary();
    }

}
