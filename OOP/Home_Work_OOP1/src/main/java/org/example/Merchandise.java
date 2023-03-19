package org.example;

/**
 * Класс товаров
 */
public class Merchandise {

    public int number;
    public String name;
    public int price;
    public double rating;


    public Merchandise(int number, String name, int price, double rating) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

//    public Merchandise() {
//    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    private void setRating(double rating) {
        this.rating = rating;
    }
    private void setPrice(int price) {
        this.price = price;
    }


    public static Merchandise potato = new Merchandise(1, "Картошка", 120, 4.0);
    public static Merchandise milk = new Merchandise(2,"Молоко", 70, 5.0);
    public static Merchandise bread = new Merchandise(3,"Хлеб", 120, 4.3);

public void getInfo (){
    System.out.println(number + " " + getName()+ ", " +  "цена: "+ getPrice()+" руб." + " рейтинг: " + getRating());
}

}
