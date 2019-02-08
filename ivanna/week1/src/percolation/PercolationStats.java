package percolation;/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] experimentsResults;

    private int T;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();
        experimentsResults = new double[trials];
        T = trials;

        for (int i = 0; i < trials; i++){
            experimentsResults[i] = runOnePercolationExperiment(n);
        }
    }

    // sample mean of week1.percolation threshold
    public double mean() {
        return StdStats.mean(experimentsResults);
    }

    // sample standard deviation of week1.percolation threshold
    public double stddev() {
        return StdStats.stddev(experimentsResults);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        double xMean = mean();
        //double s = Math.sqrt(stddev());

        return xMean - (1.96 * stddev())/Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double xMean = mean();
//        double s = Math.sqrt(stddev());

        return xMean + (1.96 * stddev())/Math.sqrt(T);
    }

    // test client (described below)
    public static void main(String[] args) {
        new PercolationStats(2, 10000);
    }

    private static double runOnePercolationExperiment(int n) {
        Percolation percExperiment = new Percolation(n);

        int i = 0;
        while (true) {
            int col = StdRandom.uniform(1, n + 1);
            int row = StdRandom.uniform(1, n + 1);

            if (!percExperiment.isOpen(row, col)) {
                percExperiment.open(row, col);
                i++;
            }
            if (percExperiment.percolates()) {
                return (0.0+i)/(n*n);
            }
        }
    }
}
