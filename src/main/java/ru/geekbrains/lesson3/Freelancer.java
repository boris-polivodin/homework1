package ru.geekbrains.lesson3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Freelancer extends Employee {

    private Double hoursWorked;


    public Freelancer(String name, String surName, BigDecimal salary) {
        this(name, surName, salary, 0d);
    }

    public Freelancer(String name, String surName, BigDecimal salary, Double hoursWorked) {
        super(name, surName, salary);
        this.hoursWorked = hoursWorked;
    }

    @Override
    protected BigDecimal calculateSalary() {
        return salary.multiply(new BigDecimal(hoursWorked));
    }

    @Override
    public String toString() {
        return String.format("%s %s. Фрилансер. Среднемесячная зарплата (почасовая): %s (руб.) за %.1f отработанных часов по ставке %s (руб.)."
                            , surName, name, calculateSalary().setScale(2, RoundingMode.HALF_UP).toString(), hoursWorked, salary.setScale(0, RoundingMode.HALF_UP).toString());
    }

    @Override
    public int compareTo(Employee o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    
    
}
