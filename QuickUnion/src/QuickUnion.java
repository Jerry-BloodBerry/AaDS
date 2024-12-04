import java.util.Arrays;

public class QuickUnion {
    private final int[] id;

    public QuickUnion(int n)
    {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public boolean find(int p, int q)
    {
        return root(p) == root(q);
    }

    private int root(int q) {
        while (q != id[q])
        {
            q = id[q];
        }
        return q;
    }

    @Override
    public String toString() {
        return "QuickUnion{" +
                "id=" + Arrays.toString(id) +
                '}';
    }
}
