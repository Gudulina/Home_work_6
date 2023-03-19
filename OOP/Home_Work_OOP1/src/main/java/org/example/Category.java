package org.example;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Класс категории товаров
 */
public class Category {

    String nameCategory;

    protected Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }


    public static String[] food = new String[]{"potato", "butter", "bread"};
    public static String[] drinks = new String[]{"coffee", "milk", "tea"};



}

