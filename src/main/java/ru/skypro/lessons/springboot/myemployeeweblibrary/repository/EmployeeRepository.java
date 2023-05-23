package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;

import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    public double getSumOfSalaries();
    public Employee getMinimumWageEmployee();
    public Employee getMaxWageEmployee();
    public List<Employee> getAllEmployeesWithHighSalary();
}
