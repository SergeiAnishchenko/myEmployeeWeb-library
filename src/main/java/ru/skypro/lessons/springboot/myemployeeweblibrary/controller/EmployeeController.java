package ru.skypro.lessons.springboot.myemployeeweblibrary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

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


    @PostMapping("/")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public void editEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.editEmployee(id, employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/allEmployeesWithSalaryHigherThan")
    public List<Employee> getAllEmployeesWithSalaryHigherThan(@RequestParam("compareSalary") double compareSalary) {
        return employeeService.getAllEmployeesWithSalaryHigherThan(compareSalary);
    }

}
