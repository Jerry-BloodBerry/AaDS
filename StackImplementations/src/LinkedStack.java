public class LinkedStack<T> {
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
}
