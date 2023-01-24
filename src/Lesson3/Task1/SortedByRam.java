package Lesson3.Task1;

import java.util.Comparator;

public class SortedByRam implements Comparator<Notebook> {
/*
    private final int ram;

    public SortedByRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return ram;
    }

    @Override
    public int compareTo(Notebook o) {
        return (int) (this.getPrice() - o.getPrice());
    }*/


    @Override
    public int compare(Notebook obj1, Notebook obj2) {
        int ram1 = obj1.getRam();
        int ram2 = obj2.getRam();

        return Integer.compare(ram1,ram2);
    }
}
