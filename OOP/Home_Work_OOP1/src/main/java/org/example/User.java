package org.example;

import java.util.Arrays;

public class User {
    String userName;
    String password;

    public static Basket basket = new Basket();

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static String[] buy(String name, String[] basket) {
        basket = new String[] {name};
        System.out.println("В корзине: " + Arrays.toString(basket));
        return basket;
    }


}
