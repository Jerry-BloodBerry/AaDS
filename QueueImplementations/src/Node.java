public final class Node<T> {
    private final T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T value() {
        return value;
    }

    public Node<T> next() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
