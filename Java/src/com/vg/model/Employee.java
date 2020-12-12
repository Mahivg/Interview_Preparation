package com.vg.model;

import java.math.BigDecimal;

public class Employee {
    private Integer empId;
    private String name;
    private Double salary;
    private String designation;
    private String location;

    public Employee() {
    }

    public Employee(Integer empId, String name, Double salary, String designation, String location) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.location = location;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
