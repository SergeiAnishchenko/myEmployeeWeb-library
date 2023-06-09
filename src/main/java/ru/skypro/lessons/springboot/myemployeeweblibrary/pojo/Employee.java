package ru.skypro.lessons.springboot.myemployeeweblibrary.pojo;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "salary")
    private int salary;

    @Column (name = "departmentNumber")
    private int departmentNumber;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;


    public Employee(Integer id, String name, int salary, int departmentNumber, Position position) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.departmentNumber = departmentNumber;
        this.position = position;
    }

    public Employee() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id && salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", departmentNumber=" + departmentNumber +
                ", position=" + position +
                '}';
    }
}