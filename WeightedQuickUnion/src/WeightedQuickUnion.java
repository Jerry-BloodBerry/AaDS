import java.util.Arrays;

public class WeightedQuickUnion {
    private final int[] id;
    private final int[] sizes;

    public WeightedQuickUnion(int n)
    {
        id = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (sizes[i] <= sizes[j]) {
            id[i] = id[j];
            sizes[j] += sizes[i];
        } else {
            id[j] = id[i];
            sizes[i] += sizes[j];
        }
    }

    public boolean find(int p, int q)
    {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != id[i])
        {
            id[i] = id[id[i]]; // Path compression
            i = id[i];
        }
        return i;
    }

    @Override
    public String toString() {
        return "WeightedQuickUnion{" +
                "id=" + Arrays.toString(id) +
                '}';
    }
}
