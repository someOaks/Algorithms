package SUM3;

import java.util.Arrays;
import java.util.Collections;

class MyThreeSum {


    static int countBase(Integer[] m) {
        int N = m.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (m[i] + m[j] + m[k] == 0) {
                        //System.out.println("#: " + m[i] + " " + m[j] + " " + m[k]);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    static int count1(Integer[] m) { // N^3
        int N = m.length;
        int count = 0;
        int a = 0;
        int b = 1;
        int c = 2;

        while(a <= (N - 3)) {

            if (m[a] + m[b] + m[c] == 0) {
                //System.out.println("#: " + m[a] +" " + m[b] +" " + m[c]);
                count++;
            }

            if (b == N - 2) {
                a++;
                b = a;

            }

            if (c == N - 1) {
                b++;
                c = b;
            }

            c++;

        }
        return count;
    }


    /**
     * УТОПИЯ
     * @param m
     * @return
     */
    static int countWith2SUM(Integer[] m) {

        Arrays.sort(m, Collections.reverseOrder());
        System.out.println(Arrays.toString(m));
        int count = 0;

        for (int i : m) {

            if (find2Sum(m, i)) count++;
        }

        return count;
    }

    private static boolean find2Sum(Integer[] m, int i) {
        int L = 0;
        int R = m.length - 1;

        while (L < R) {
            int tempSum = (m[L] + m[R]);

            if (tempSum + i == 0) {
                System.out.println("# " + m[L] +"." + m[R] +"." +(i));
                return true;
            } else if (tempSum < i) {
                L++;
            } else {
                R--;
            }
        }
        return false;
    }

    static int countWithBinarySearch(Integer[] m) { // n log n + n*n log n  = n log n (1 + n)

        Arrays.sort(m); // n log n
        int N = m.length;
        int count = 0;

        for (int i = 0; i < N -2; i++) {
            for (int j = i + 1; j < N; j++) {
                int thirdIndex = Arrays.binarySearch(m, j + 1, N,-(m[i] + m[j])); // N^2 log n
                if (thirdIndex > j) count++;

            }
        }

        return count;
    }
}
