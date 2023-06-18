package ru.skypro.lessons.springboot.myemployeeweblibrary.dto;

import java.io.Serializable;

public class DepartmentReport implements Serializable {

    private String positionName;
    private Long count;
    private int minSalary;
    private int maxSalary;
    private double avgSalary;

    public DepartmentReport(String positionName, Long count, int minSalary, int maxSalary, double avgSalary) {
        this.positionName = positionName;
        this.count = count;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.avgSalary = avgSalary;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }
    @Override
    public String toString() {
        return "{" +
                "pName='" + positionName + '\'' +
                ", count=" + count +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                ", avgSalary=" + avgSalary +
                '}';
    }

}



