import java.util.Arrays;
import java.util.Iterator;

public class ArrayBag<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArrayBag() {
        items = (T[]) new Object[1];
        size = 0;
    }

    public void add(T item) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[size++] = item;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return items[index++];
        }
    }
}
