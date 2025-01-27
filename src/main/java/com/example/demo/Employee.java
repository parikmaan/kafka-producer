package com.example.demo;

public class Employee {
    private static long COUNTER = 0L;
    private long employeeId;
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.employeeId = Employee.COUNTER;
        this.firstName = firstName;
        this.lastName = lastName;
        Employee.COUNTER += 1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
