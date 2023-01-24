package Lesson3.Task1;

import java.util.Comparator;

public class SortedComplex implements Comparator<Notebook> {

    @Override
    public int compare(Notebook obj1, Notebook obj2) {
        int ram1 = obj1.getRam();
        int ram2 = obj2.getRam();
        double price1 = obj1.getPrice();
        double price2 = obj2.getPrice();

        if(ram1 > ram2){
            return 1;
        } else if (ram1 < ram2){
            return -1;
        } else {
            if(price1 > price2){
                return 1;
            } else if (price1< price2){
                return -1;
            } else {
                return 0;
            }
        }
    }


}

