import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T> {
    private T[] array;
    private int size;

    public ArrayStack() {
        array = (T[]) new Object[1];
        size = 0;
    }

    public void push(T item) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
            System.out.println("Array is full. Doubling the size");
        }
        array[size++] = item;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("ArrayStack is empty");
        }
        if (size == array.length / 4) {
            System.out.println("Array is only quarter full. Halving the size");
            array = Arrays.copyOf(array, array.length / 2);
        }
        return array[--size];
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int current = size;
        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public T next() {
            return array[--current];
        }
    }
}
