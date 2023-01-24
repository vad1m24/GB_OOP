package Lesson3.Task2;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        int[] source = {1, 2, 3, 4, 5, 6, 7};
        Iterator<Integer> intArrayIterator = new IntArrayIterator(source);
        while (intArrayIterator.hasNext()) {
            System.out.println(intArrayIterator.next());

        }
    }
}