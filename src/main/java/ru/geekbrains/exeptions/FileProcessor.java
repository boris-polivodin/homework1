package ru.geekbrains.exeptions;

import java.io.*;
import java.util.LinkedHashMap;

class FileProcessor {

    static void writeFile(LinkedHashMap<String, String> map, String name) {

        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append("<").append(map.get(key)).append(">");
        }

        try (FileWriter fw = new FileWriter(name, true)) {
            fw.write(sb.toString());
            fw.write("\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeFile(LinkedHashMap<String, String> map) {

        StringBuilder sb = new StringBuilder();
        String name = "text.txt";
        if (map.containsKey("surname")) name = map.get("surname") + ".txt";
        // <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
        for (String key : map.keySet()) {
            sb.append("<").append(map.get(key)).append(">");
        }

        try (FileWriter fw = new FileWriter(name, true)) {
            fw.write(sb.toString());
            fw.write("\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
