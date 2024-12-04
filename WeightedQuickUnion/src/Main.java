public class Main {
    public static void main(String[] args) {
        WeightedQuickUnion wqu = new WeightedQuickUnion(6);
        System.out.println(wqu);
        wqu.union(4,3);
        System.out.println(wqu);
        wqu.union(5,2);
        System.out.println(wqu);
        wqu.union(5,3);
        System.out.println(wqu);
        System.out.println(wqu.find(3,4));
        System.out.println(wqu.find(3,5));
        System.out.println(wqu.find(2,3));
        System.out.println(wqu.find(0,1));
    }
}
