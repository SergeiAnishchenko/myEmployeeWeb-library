package ru.skypro.lessons.springboot.myemployeeweblibrary.projections;

public class EmployeeByIdFullInfo {

    private String name;
    private int salary;
    private String positionName;

    public EmployeeByIdFullInfo(String name, int salary, String positionName) {
        this.name = name;
        this.salary = salary;
        this.positionName = positionName;
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
