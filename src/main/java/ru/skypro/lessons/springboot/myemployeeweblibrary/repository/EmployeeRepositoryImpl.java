package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.myemployeeweblibrary.exceptions.EmployeeExceptionHandler;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static Integer employeeId = 0;
    private Map<Integer, Employee> employees = new HashMap<>();


    private final List<Employee> employeeList = List.of(
            new Employee(123,"Ира", 110_000),
            new Employee(124,"Вася", 167_000),
            new Employee(125,"Егор", 90_000),
            new Employee(126,"Маша", 175_000));


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
            employee.setId(employeeId);
            employees.put(employeeId, employee);
        }
    }

    @Override
    public void editEmployee(int id, Employee employee) throws IllegalArgumentException {
        if (employees.containsKey(id)) {
            employees.put(id, employee);
        }
        else throw new IllegalArgumentException ("Некорректный ID сотрудника.");
    }

    @Override
    public Employee getEmployee(int id) throws IllegalArgumentException {
        if (employees.containsKey(id)) {
           return employees.get(id);
        }
        else throw new IllegalArgumentException ("Некорректный ID сотрудника.");
    }

    @Override
    public void deleteEmployee(int id) throws IllegalArgumentException {
        if (employees.containsKey(id)) {
            employees.remove(id);
        }
        else throw new IllegalArgumentException ("Некорректный ID сотрудника.");
    }
}