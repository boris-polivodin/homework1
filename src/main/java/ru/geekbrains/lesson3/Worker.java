package ru.geekbrains.lesson3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Worker extends Employee{

    public Worker(String name, String surName, BigDecimal salary) {
        super(name, surName, salary);
    }

    @Override
    protected BigDecimal calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s. Рабочий. Среднемесячная зарплата (фиксированная): %s (руб.)"
                            , surName, name, calculateSalary().setScale(2, RoundingMode.HALF_UP).toString());
    }

    @Override
    public int compareTo(Employee o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    
    
}
