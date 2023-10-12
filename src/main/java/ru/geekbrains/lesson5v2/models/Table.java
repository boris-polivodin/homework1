package ru.geekbrains.lesson5v2.models;

import ru.geekbrains.lesson5v2.models.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {

    private static int counter;
    private final int no;

    {
        no = ++counter;
    }

    private final Collection<ru.geekbrains.lesson5v2.models.Reservation> reservations = new ArrayList<>();

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public int getNo() {
        return no;
    }


    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }

}
