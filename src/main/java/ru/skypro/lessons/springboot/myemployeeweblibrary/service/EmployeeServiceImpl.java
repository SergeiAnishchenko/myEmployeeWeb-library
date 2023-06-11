package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
            Employee employee = employeeDTO.toEmployee();
            employee.setId(id);
            employeeRepository.save(employee);
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
        return employeeList.
                stream().map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesWithHighestSalary() {
        List<Employee> employeeList = employeeRepository.findEmployeesWithHighestSalary();
        return employeeList
                .stream().map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }


    public List<EmployeeDTO> getAllEmployeesByPosition(String positionName) {
        String correctPositionName;
        if (getAllEmployees().stream().map(EmployeeDTO::toEmployee)
                .anyMatch(employee -> employee.getPosition().getName()
                        .equalsIgnoreCase(positionName))) {
            if (getAllEmployees().stream().map(EmployeeDTO::toEmployee)
                    .anyMatch(employee -> employee.getPosition().getName()
                            .equals(positionName))) {
                return employeeRepository.getAllEmployeesByPosition(positionName).stream()
                        .map(EmployeeDTO::fromEmployee)
                        .collect(Collectors.toList());
            } else correctPositionName = positionName.substring(0, 1).toUpperCase() + positionName.substring(1);
            return employeeRepository.getAllEmployeesByPosition(correctPositionName).stream()
                    .map(EmployeeDTO::fromEmployee)
                    .collect(Collectors.toList());
        } else return getAllEmployees();
    }


    @Override
    public EmployeeDTO getEmployeeByIdFullInfo(int id) throws IncorrectEmployeeIdException {
            Optional<EmployeeDTO> employeeOptional = employeeRepository.getEmployeeByIdFullInfo(id).map(EmployeeDTO::fromEmployee);
            return employeeOptional.orElseThrow(() -> new IncorrectEmployeeIdException("Некорректный ID сотрудника."));
    }


    public List<EmployeeDTO> getEmployeesByPage(int page) {
        Pageable employeeOfConcretePage = PageRequest.of(page, 10);
        Page<Employee> employeePage = employeeRepository.findAll(employeeOfConcretePage);
        List<Employee> employeeList = employeePage.stream().toList();
        return employeeList.stream().map(EmployeeDTO::fromEmployee).collect(Collectors.toList());
    }

}