public class Main {
    public static void main(String[] args) {
        var arrayBag = new ArrayBag<Integer>();
        arrayBag.add(1);
        arrayBag.add(2);
        arrayBag.add(2);
        arrayBag.add(2);
        arrayBag.add(3);
        for (var value : arrayBag) {
            System.out.println(value);
        }
        System.out.println("Size of arrayBag: " + arrayBag.size());
        System.out.println();

        var linkedBag = new LinkedBag<Integer>();
        linkedBag.add(4);
        linkedBag.add(2);
        linkedBag.add(2);
        linkedBag.add(2);
        linkedBag.add(4);
        for (var value : linkedBag) {
            System.out.println(value);
        }
        System.out.println("Size of linkedBag: " + linkedBag.size());
    }
}