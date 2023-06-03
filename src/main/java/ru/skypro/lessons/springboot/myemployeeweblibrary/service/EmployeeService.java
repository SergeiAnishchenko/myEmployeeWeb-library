package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import java.util.List;

public interface EmployeeService {

    public double getSumOfSalaries();
    public Employee getMinimumWageEmployee();
    public Employee getMaxWageEmployee();
    public List<Employee> getAllEmployeesWithHighSalary();


    public void addEmployee(Employee employee);
    public void editEmployee(int id, Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
    public List<Employee> getAllEmployeesWithSalaryHigherThan(double compareSalary);
}
