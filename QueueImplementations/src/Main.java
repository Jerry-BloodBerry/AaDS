public class Main {
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("a");
        System.out.println(queue.dequeue());
        System.out.println();
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}