package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import java.util.List;
import java.util.Set;

public interface EmployeeService {

    public double getSumOfSalaries();
    public Employee getMinimumWageEmployee();
    public Employee getMaxWageEmployee();
    public List<Employee> getAllEmployeesWithHighSalary();


    public void addEmployee(Employee employee);
    public void editEmployee(int id, Employee employee) throws IllegalArgumentException;
    public Employee getEmployee(int id) throws IllegalArgumentException;
    public void deleteEmployee(int id) throws IllegalArgumentException;
    public List<Employee> getAllEmployeesWithSalaryHigherThan(int compareSalary);
}
