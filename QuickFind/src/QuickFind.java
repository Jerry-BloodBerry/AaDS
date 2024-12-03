import java.util.Arrays;

public class QuickFind {
    private int[] id;
    public QuickFind(int n)
    {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean find(int p, int q)
    {
        return id[p] == id[q];
    }

    public void union(int p, int q)
    {
        if (id[p] == id[q]) return;
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == qid)
            {
                id[i] = id[p];
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(id);
    }
}
