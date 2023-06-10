package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.myemployeeweblibrary.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.myemployeeweblibrary.exceptions.IncorrectEmployeeIdException;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.repository.EmployeeRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployeeById(int id, EmployeeDTO employeeDTO) throws IncorrectEmployeeIdException {
        if (employeeRepository.existsById(id)) {
            Employee employee = employeeRepository.save(employeeDTO.toEmployee());
        } else throw new IncorrectEmployeeIdException("Некорректный ID сотрудника.");
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) throws IncorrectEmployeeIdException {

        Optional<EmployeeDTO> employeeOptional = employeeRepository.findById(id).map(EmployeeDTO::fromEmployee);

        return employeeOptional.orElseThrow(() -> new IncorrectEmployeeIdException("Некорректный ID сотрудника."));
    }

    @Override
    public void deleteEmployeeById(int id) throws IncorrectEmployeeIdException {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else throw new IncorrectEmployeeIdException("Некорректный ID сотрудника.");
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach((employeeList::add));
        return employeeList.stream().map(EmployeeDTO::fromEmployee).collect(Collectors.toList());
    }

}

