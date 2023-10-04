package ru.geekbrains.lesson4;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;
    private T fruit;
    
    public Box(ArrayList<T> fruits, T fruit) {
        this.fruits = fruits;
        this.fruit = fruit;
    }

    public float getWeight() {
        return fruits.size() * fruit.getWeight();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public boolean compare(Box o) {  // (Box<T> o)
        return this.getWeight() == o.getWeight();
    }

    public void add(T e) {
        fruits.add(e);
    }

    public boolean remove() {
        if (fruits.size() > 0) {
            fruits.remove(fruits.size() - 1);
            return true;
        }
        return false;  
    }

    public boolean transfer(Box<T> o) {
        
        // if (fruits.size() >= count) {
        //     for (int index = count; index > 0; index--) {
        //         o.add(fruits.get(fruits.size() - 1));
        //         this.remove();
        //     } 
        // } else System.out.println("В коробке нет такого количества фруктов.");

        boolean result = false;
        while (fruits.size() > 0) {

            o.add(fruits.get(fruits.size() - 1));
            this.remove();
            result = true;

        }
        return result;

    }

}
