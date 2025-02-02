import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private static class Node<T> {
        private final T value;
        private Node<T> next, prev = null;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<Item> head, tail;
    private int size;

    // construct an empty deque
    public Deque() {
        head = tail = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return head == null || tail == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item");
        }
        var oldHead = head;
        head = new Node<>(item);
        if (isEmpty()) {
            tail = head;
        }
        head.next = oldHead;
        if (oldHead != null) {
            oldHead.prev = head;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item");
        }
        var oldTail = tail;
        tail = new Node<>(item);
        if (isEmpty()) {
            head = tail;
        }
        if (oldTail != null) {
            oldTail.next = tail;
        }
        tail.prev = oldTail;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        var oldHead = head;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = head;
        } else {
            head.prev = null;
        }
        return oldHead.value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        var oldTail = tail;
        tail = tail.prev;
        size--;
        if (isEmpty()) {
            head = tail;
        }
        if (tail != null) {
            tail.next = null;
        }
        return oldTail.value;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node<Item> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException("Deque does not contain next item");
            }
            var res = current.value;
            current = current.next;
            return res;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        System.out.println("Removed: " + deque.removeLast());
        deque.addFirst(2);
        deque.addLast(3);
        System.out.println(deque.size());
        for (var item : deque) {
            System.out.println(item);
        }
        System.out.println("Removed first item: " + deque.removeFirst());
        System.out.println("Removed last item: " + deque.removeLast());
        System.out.println(deque.size());
        for (var item : deque) {
            System.out.println(item);
        }
    }

}