import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        if (trials <= 0) {
            throw new IllegalArgumentException("trials must be greater than 0");
        }
        double totalSites = n * n;
        double[] fractionsOfOpenSites = new double[trials];
        for (int i = 0; i < trials; i++) {
            var percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniformInt(n) + 1;
                int col = StdRandom.uniformInt(n) + 1;
                percolation.open(row, col);
            }
            fractionsOfOpenSites[i] = percolation.numberOfOpenSites() / totalSites;
        }
        this.mean = StdStats.mean(fractionsOfOpenSites);
        this.stddev = StdStats.stddev(fractionsOfOpenSites);
        this.confidenceLo = mean() - (1.96 * stddev()) / Math.sqrt(trials);
        this.confidenceHi = mean() + (1.96 * stddev()) / Math.sqrt(trials);
    }

    // sample mean of percolation threshold
    public double mean() {
        return this.mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return this.stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.confidenceHi;
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        var stats = new PercolationStats(n, trials);
        System.out.printf("%-24s = %s%n", "mean", stats.mean());
        System.out.printf("%-24s = %s%n", "stddev", stats.stddev());
        System.out.printf("%-24s = [%s, %s]", "95 % confidence interval", stats.confidenceLo(), stats.confidenceHi());
    }
}