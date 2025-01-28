import java.util.Iterator;

public class LinkedBag<T> implements Iterable<T> {
    private Node<T> head, tail = null;
    private int size = 0;

    public LinkedBag() {
    }

    public void add(T item) {
        Node<T> oldLast = tail;
        tail = new Node<>(item, null);
        if (isEmpty()) {
            head = tail;
        } else {
            oldLast.setNext(tail);
        }
        size++;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedBagIterator();
    }

    private class LinkedBagIterator implements Iterator<T> {
        Node<T> current = head;

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
