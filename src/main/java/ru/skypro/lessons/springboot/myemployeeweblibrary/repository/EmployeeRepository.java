package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;


import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;

public interface EmployeeRepository {

    void addEmployee(Employee employee);

    void editEmployee(int id, Employee employee) throws IllegalArgumentException;

    Employee getEmployee(int id) throws IllegalArgumentException;

    void deleteEmployee(int id) throws IllegalArgumentException;
}