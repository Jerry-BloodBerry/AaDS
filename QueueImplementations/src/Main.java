public class Main {
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("a");
        System.out.println(queue.dequeue());
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}