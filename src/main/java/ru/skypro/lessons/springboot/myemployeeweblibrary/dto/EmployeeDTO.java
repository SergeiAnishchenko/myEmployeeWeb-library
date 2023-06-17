package ru.skypro.lessons.springboot.myemployeeweblibrary.dto;

import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Employee;
import ru.skypro.lessons.springboot.myemployeeweblibrary.pojo.Position;
import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private Integer id;
    private String name;
    private int salary;
    private int departmentNumber;
    private Position position;

    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setDepartmentNumber(employee.getDepartmentNumber());
        employeeDTO.setPosition(employee.getPosition());
        return employeeDTO;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        employee.setDepartmentNumber(this.getDepartmentNumber());
        employee.setPosition(this.getPosition());

        return employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }
    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}

