package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public double getSumOfSalaries() {
        return employeeRepository.getSumOfSalaries();
    }

    @Override
    public Employee getMinimumWageEmployee() {
        return employeeRepository.getMinimumWageEmployee();
    }

    @Override
    public Employee getMaxWageEmployee() {
        return employeeRepository.getMaxWageEmployee();
    }

    @Override
    public List<Employee> getAllEmployeesWithHighSalary() {
        return employeeRepository.getAllEmployeesWithHighSalary();
    }
}
