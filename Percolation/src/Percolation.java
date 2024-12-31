import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private int numberOfOpenSites = 0;
    private final boolean[] siteIsOpen;
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    private final WeightedQuickUnionUF weightedQuickUnionForBackwash;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be a positive number");
        }
        this.n = n;
        siteIsOpen = new boolean[n * n];
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);
        weightedQuickUnionForBackwash = new WeightedQuickUnionUF(n * n + 1);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("invalid row or column");
        }
        if (!isOpen(row, col)) {
            int currentId = (row - 1) * n + col - 1;
            siteIsOpen[currentId] = true;
            numberOfOpenSites++;
            if (col - 1 >= 1 && isOpen(row, col - 1)) {
                weightedQuickUnionUF.union(currentId, (row - 1) * n + col - 2);
                weightedQuickUnionForBackwash.union(currentId, (row - 1) * n + col - 2);
            }
            if (col + 1 <= this.n && isOpen(row, col + 1)) {
                weightedQuickUnionUF.union(currentId, (row - 1) * n + col);
                weightedQuickUnionForBackwash.union(currentId, (row - 1) * n + col);
            }
            if (row - 1 >= 1 && isOpen(row - 1, col)) {
                weightedQuickUnionUF.union(currentId, (row - 2) * n + col - 1);
                weightedQuickUnionForBackwash.union(currentId, (row - 2) * n + col - 1);
            }
            if (row + 1 <= this.n && isOpen(row + 1, col)) {
                weightedQuickUnionUF.union(currentId, row * n + col - 1);
                weightedQuickUnionForBackwash.union(currentId, row * n + col - 1);
            }
            if (row == 1) {
                weightedQuickUnionUF.union(currentId, this.n * this.n);
                weightedQuickUnionForBackwash.union(currentId, this.n * this.n);
            }
            if (row == this.n) {
                weightedQuickUnionUF.union(currentId, this.n * this.n + 1);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("invalid row or column");
        }
        return siteIsOpen[(row - 1) * n + col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("invalid row or column");
        }
        int currentId = (row - 1) * n + col - 1;
        return weightedQuickUnionForBackwash.find(currentId) == weightedQuickUnionForBackwash.find(this.n * this.n);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.find(this.n * this.n) == weightedQuickUnionUF.find(this.n * this.n + 1);
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}
