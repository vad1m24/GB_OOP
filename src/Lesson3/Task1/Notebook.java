package Lesson3.Task1;

import java.util.ArrayList;

public class Notebook {

    /**
     * 1. Создать список объектов типа Notebook
     * Отсортировать его тремя способами:
     * 1.1 по ОЗУ (ram)
     * 1.2 по цене (price)
     * 1.3 сначала по ram, потом по price (если ram не равны, сортируем по ним; если равны, то по цене)
     */

    private int ram;
    private double price;

    public Notebook(int ram, double price) {
        this.ram = ram;
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "ram = " + ram +
                ", price = " + price +
                '}';
    }

    public static void fillingList(ArrayList<Notebook> list) {
        int detailsSize = getRandomSize(6, 20);
        System.out.println("~~~~~ Данные без сортировки ~~~~~");
        for (int i = 0; i < detailsSize; i++) {
            Notebook details = (new Notebook(getRandomRam(4, 32), getRandomPrice(100, 500)));
            list.add(i, details);
            System.out.println(details);
        }
        System.out.println();
    }

    public static int getRandomSize(int min, int max) {
        return (int) ((Math.random() * ++max) + min);
    }

    public static int getRandomRam(int min, int max) {
        return (int) ((Math.random() * ++max) + min);
    }

    public static double getRandomPrice(int min, int max) {
        double randomPrice = (Math.random() * (max - min)) + min;
        return Math.ceil(randomPrice);
    }

}
