package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static Integer employeeId = 0;
    private static final Map<Integer, Employee> employees = new HashMap<>();

    private final List<Employee> employeeList = List.of(
            new Employee("Ира", 110_000),
            new Employee("Вася", 167_000),
            new Employee("Егор", 90_000),
            new Employee("Маша", 175_000));

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public Map<Integer, Employee> getEmployees() {
        return employees;
    }


    @Override
    public void addEmployee(Employee employee) {
        if (!employees.containsValue(employee)) {
            ++employeeId;
            employees.put(employeeId, employee);
        }
    }

    @Override
    public void editEmployee(int id, Employee employee) {
        if (employees.containsKey(id)) {
            employees.put(id, employee);
        }
    }

    @Override
    public Employee getEmployee(int id) {
        return employees.get(employeeId);
    }

    @Override
    public void deleteEmployee(int id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
        }
    }

}