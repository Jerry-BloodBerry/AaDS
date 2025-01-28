import java.util.Iterator;

public class LinkedQueue<T> implements Iterable<T> {
    private Node<T> head, tail;

    public LinkedQueue() {
        head = tail = null;
    }

    public void enqueue(T value) {
        Node<T> oldLast = tail;
        tail = new Node<>(value, null);
        if (isEmpty()) {
            head = tail;
        } else {
            oldLast.setNext(tail);
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T item = head.value();
        head = head.next();
        if (isEmpty()) {
            tail = null;
        }
        return item;
    }

    private boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.value();
            current = current.next();
            return item;
        }
    }
}
