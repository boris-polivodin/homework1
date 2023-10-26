package ru.geekbrains.exeptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;

public class Parser {

    static void parsing(LinkedHashMap<String, String> map, String line) {

        String[] arr = line.split(" ");
        if (arr.length != 4) throw new MyArraySizeExeption(arr.length);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        boolean isExeption;
        boolean isTelephone;
        boolean isDate;
        boolean isSurname;
        boolean isSex;

        for (String item : arr) {

            isExeption = false;
            isTelephone = false;
            isDate = false;
            isSurname = false;
            isSex = false;

            try {
                long num = Long.parseLong(item);
                isTelephone = true;
            } catch (IllegalArgumentException e) {
                System.out.printf("%s - не число\n", item);

                try {
                    LocalDate localDate = LocalDate.parse(item, formatter);
                    isDate = true;
                } catch (DateTimeParseException exception) {
                    System.out.printf("%s - не дата\n", item);
                    isExeption = true;
                } catch (IllegalArgumentException exception) {
                    System.out.printf("%s - не удалось конвертировать в дату\n", item);
                    isExeption = true;
                }
            }

            if (isExeption) {
                if (item.length() == 1 && (item.equals("f") || item.equals("m"))) {
                    isSex = true;
                } else {
                    isSurname = true;
                }
            }

            if (isDate && map.get("birthday").isEmpty()) {
                map.put("birthday", item);
            } else if (isSex && map.get("sex").isEmpty()) {
                map.put("sex", item);
            } else if (isSurname && map.get("surname").isEmpty()) {
                map.put("surname", item);
            } else if (isTelephone && map.get("telephone").isEmpty()) {
                map.put("telephone", item);
            } else {
                throw new RuntimeException(String.format("Некорректный формат введенных данных - %s\n", item));
            }


        }
    }
}

class MyArraySizeExeption extends RuntimeException {
    public MyArraySizeExeption() {
        super("Количество данных должно быть равным 4");
    }

    public MyArraySizeExeption(int size) {
        super(String.format("Количество данных должно быть равным 4. Вы ввели %d типа(-ов)", size));
    }
}



