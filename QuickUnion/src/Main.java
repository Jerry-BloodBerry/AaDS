public class Main {
    public static void main(String[] args) {
        QuickUnion qu = new QuickUnion(6);
        System.out.println(qu);
        qu.union(4,5);
        System.out.println(qu);
        qu.union(4,2);
        System.out.println(qu);
        qu.union(3,4);
        System.out.println(qu);
        System.out.println(qu.find(3,4));
        System.out.println(qu.find(3,5));
        System.out.println(qu.find(2,3));
        System.out.println(qu.find(0,1));
    }
}
