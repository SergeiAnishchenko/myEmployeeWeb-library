package ru.skypro.lessons.springboot.myemployeeweblibrary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> editEmployee(@PathVariable int id, @RequestBody Employee employee) {
        try {
            employeeService.editEmployee(id, employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Throwable t) {
            return new ResponseEntity<>("Некорректный ID сотрудника.",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public Object getEmployee(@PathVariable int id) {
        try {
            employeeService.getEmployee(id);
            return employeeService.getEmployee(id);
        } catch (Throwable t) {
            return new ResponseEntity<>("Некорректный ID сотрудника.",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Throwable t) {
            return new ResponseEntity<>("Некорректный ID сотрудника.",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("allEmployeesWithSalaryHigherThan")
    public List<Employee> getAllEmployeesWithSalaryHigherThan(@RequestParam("compareSalary") int compareSalary) {
        return employeeService.getAllEmployeesWithSalaryHigherThan(compareSalary);
    }

}
