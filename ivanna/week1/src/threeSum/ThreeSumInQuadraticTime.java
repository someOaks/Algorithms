package threeSum;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 3-SUM in quadratic time.

 Design an algorithm for the 3-SUM problem
 that takes time proportional to n^2 in the worst case.

 You may assume that you can sort the n integers
 in time proportional to n^2 or better.

 * **/

public class ThreeSumInQuadraticTime {

    public static int count(int[] a){
        Arrays.sort(a); //  sort array

        int N = a.length;
        int count = 0;

        // for each element c of the array
        // try to find two numbers a and b such that a+b = -c.
        for (int i = 0; i < N; i++) {

            int j = i + 1;
            int k = N - 1;
            int sum;

            while (j < k) {
                sum = a[j] + a[k];
                if (sum == -a[i]) {
                    System.out.println("i:" + a[i] + "   j:" + a[j] + "   k:" + a[k]);
                    count++;
                    k--;
                } else if (sum > -a[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] b = {1, 3, 5, 9, -9, 69, 8, -4, -1, -3};

        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(b));
        double time = stopwatch.elapsedTime();

        System.out.println(time);

    }
}