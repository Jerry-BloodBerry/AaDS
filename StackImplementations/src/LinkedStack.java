import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T>{
    private Node<T> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        size = 0;
    }

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        T value = top.data();
        top = top.next();
        size--;
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<T> {
        private Node<T> current = top;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.data();
            current = current.next();
            return item;
        }
    }
}
