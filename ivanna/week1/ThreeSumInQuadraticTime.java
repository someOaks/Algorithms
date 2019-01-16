import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 1. Sort array;
 2. For each element c of the array
    try to find two numbers a and b such that a+b = -c.
    (hint:use two pointers, one at the beginning, the other at the end) O(n^2)
 */

public class ThreeSumInQuadraticTime {

    public static int count(int[] a){
        Arrays.sort(a);

        int N = a.length;
        int count = 0;

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
        int[] b = new int[]{1, 3, 5, 9, -9, 69, 8, -4, -1, -3};

        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(b));
        double time = stopwatch.elapsedTime();

        System.out.println(time);

    }
}