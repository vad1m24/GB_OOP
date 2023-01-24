package Lesson3.Task1;

import java.util.Comparator;

public class SortedByPrice implements Comparator<Notebook> {
/*
    public final double price;

    public SortedByPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Notebook o) {
        return (int) (this.getPrice() - o.getPrice());
    }*/
    @Override
    public int compare(Notebook obj1, Notebook obj2) {
        double price1 = obj1.getPrice();
        double price2 = obj2.getPrice();

        return Double.compare(price1, price2);
    }
}
