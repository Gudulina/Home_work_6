package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        System.out.println("Продукты: " + Arrays.toString(Category.food));
        System.out.println("Напитки: " + Arrays.toString(Category.drinks));
        System.out.println();

        Merchandise.potato.getInfo();
        Merchandise.bread.getInfo();
        Merchandise.milk.getInfo();
        System.out.println();

        User.buy("Картошка", Basket.basket);

    }
}