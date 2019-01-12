package javaAlgorithmsPractice;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 3-SUM. Given N distinct integers, how many triples sum to exactly zero?
 */

public class ThreeSum {
    public static int count(int[] a){
        int N = a.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++){
                for (int k = j + 1; k < N; k++){
                    if (a[i] + a[j] + a[k] == 0){
                        System.out.println("i:" + a[i] + "   j:" + a[j] + "   k:" + a[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {4, -4, 3, -3, 2, -2, 0, 1};
//        System.out.println(count(a));

//        int[] a = In.readInts(args[0]);
//        StdOut.println(count(a));

//        int[] a = In.readInts(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(ThreeSum.count(a));
        double time = stopwatch.elapsedTime();

        System.out.println(time);

    }
}
