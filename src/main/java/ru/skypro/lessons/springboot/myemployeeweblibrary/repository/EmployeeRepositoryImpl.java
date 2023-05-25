package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import java.util.List;



@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee("Ира", 110_000),
            new Employee("Вася", 167_000),
            new Employee("Егор", 90_000),
            new Employee("Маша", 175_000));

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
