public class Main {
    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        System.out.println(qf);
        qf.union(1,3);
        System.out.println(qf);
        qf.union(3,5);
        System.out.println(qf);
        qf.union(4,5);
        System.out.println(qf);
        qf.union(8,9);
        System.out.println(qf);
        qf.union(0,9);
        System.out.println(qf);

        System.out.println(qf.find(1,5) ? "1 and 5 are connected" : "1 and 5 are not connected");
        System.out.println(qf.find(1,4) ? "1 and 4 are connected" : "1 and 4 are not connected");
        System.out.println(qf.find(8,5) ? "8 and 5 are connected" : "8 and 5 are not connected");
        System.out.println(qf.find(8,0) ? "8 and 0 are connected" : "8 and 0 are not connected");
    }
}
