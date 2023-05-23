package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import java.util.List;

public interface EmployeeService {
    public double getSumOfSalaries();
    public Employee getMinimumWageEmployee();
    public Employee getMaxWageEmployee();
    public List<Employee> getAllEmployeesWithHighSalary();
}