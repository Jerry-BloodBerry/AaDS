public class LinkedQueue<T> {
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
}
