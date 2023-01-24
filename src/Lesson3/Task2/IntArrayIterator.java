package Lesson3.Task2;

import java.util.Iterator;

public class IntArrayIterator implements Iterator<Integer> {

    private final int[] source;
    private int cursor = 0;

    public IntArrayIterator(int[] source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return cursor <= source.length - 1;
    }

    @Override
    public Integer next() {
        cursor++;
        return source[cursor - 1];
    }
}
