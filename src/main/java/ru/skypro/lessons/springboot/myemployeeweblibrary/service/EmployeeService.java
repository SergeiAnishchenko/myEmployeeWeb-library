package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.myemployeeweblibrary.exceptions.IncorrectEmployeeIdException;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import java.util.List;

public interface EmployeeService {


    void addEmployee(Employee employee);

    void editEmployeeById(int id, EmployeeDTO employeeDTO) throws IncorrectEmployeeIdException;

    EmployeeDTO getEmployeeById(int id) throws IncorrectEmployeeIdException;

    void deleteEmployeeById(int id) throws IncorrectEmployeeIdException;

    List<EmployeeDTO> getAllEmployees();
}
