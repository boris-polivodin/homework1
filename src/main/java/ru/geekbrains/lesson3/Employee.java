package ru.geekbrains.lesson3;

import java.math.BigDecimal;

public abstract class Employee implements Comparable<Employee> {
    
    protected String name;
    protected String surName;
    protected BigDecimal salary;

    public Employee(String name, String surName, BigDecimal salary) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
    }

    protected abstract BigDecimal calculateSalary();
    
}
