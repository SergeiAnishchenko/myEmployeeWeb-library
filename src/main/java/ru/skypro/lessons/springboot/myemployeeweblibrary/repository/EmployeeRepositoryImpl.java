package ru.skypro.lessons.springboot.myemployeeweblibrary.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import java.util.Comparator;
import java.util.List;



@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee("Ира", 110_000),
            new Employee("Вася", 167_000),
            new Employee("Егор", 90_000),
            new Employee("Маша", 175_000));

    @Override
    public double getSumOfSalaries() {
        double sumOfSalary = 0;
        for(int i = 0; i < employeeList.size(); i++)
        {
            sumOfSalary += employeeList.get(i).getSalary();
        }
        return sumOfSalary;
    }

    @Override
    public Employee getMinimumWageEmployee() {
        Employee minWageEmployee = (employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).
                toList()).get(0);

        return minWageEmployee;
    }

    @Override
    public Employee getMaxWageEmployee() {
        List<Employee> sortedEmployeeList = employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
        Employee maxWageEmployee = sortedEmployeeList.get(sortedEmployeeList.size() - 1);

        return maxWageEmployee;
    }

    @Override
    public List<Employee> getAllEmployeesWithHighSalary() {
        double averageSalary = (getSumOfSalaries()/employeeList.size());
        List<Employee> allEmployeesWithHighSalary = employeeList.stream().filter(e -> e.getSalary()>averageSalary).toList();
        return allEmployeesWithHighSalary;
    }
}
