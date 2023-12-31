package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    boolean deleteReservationTable(int idReservation, int tableNo);
    int changeReservationTable(int idReservation, Date reservationDate, int tableNo, String name);

}
