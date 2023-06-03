package ru.skypro.lessons.springboot.myemployeeweblibrary.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.myemployeeweblibrary.repository.EmployeeRepositoryImpl;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public double getSumOfSalaries() {
        double sumOfSalary = 0;
        for (int i = 0; i < employeeRepository.getEmployeeList().size(); i++) {
            sumOfSalary += employeeRepository.getEmployeeList().get(i).getSalary();
        }
        return sumOfSalary;
    }

    @Override
    public Employee getMinimumWageEmployee() {
        Employee minWageEmployee = employeeRepository.getEmployeeList().stream().min(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        return minWageEmployee;
    }

    @Override
    public Employee getMaxWageEmployee() {
        Employee maxWageEmployee = employeeRepository.getEmployeeList().stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        return maxWageEmployee;

    }

    @Override
    public List<Employee> getAllEmployeesWithHighSalary() {
        double averageSalary = (getSumOfSalaries() / employeeRepository.getEmployeeList().size());
        List<Employee> allEmployeesWithHighSalary = employeeRepository.getEmployeeList().stream().filter(e -> e.getSalary() > averageSalary).toList();
        return allEmployeesWithHighSalary;
    }


    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        employeeRepository.editEmployee(id, employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }


    @Override
    public List<Employee> getAllEmployeesWithSalaryHigherThan(int compareSalary) {
        List<Employee> employeesList = new ArrayList<>(employeeRepository.getEmployees().values());
        List<Employee> allEmployeesWithSalaryHigherThan = employeesList.stream().
                filter(e -> e.getSalary() > compareSalary).toList();
        return allEmployeesWithSalaryHigherThan;
    }
}

