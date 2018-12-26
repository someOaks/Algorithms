package SUM3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestThreeSum {
    private static final int NUMBER_OF_TESTS = 3;

    public static void main(String... args) {
        /*
        #: -15 -10 25
        #: -15 10 5
        #: -15 0 15
        #: -10 10 0
        #: 25 -40 15
        #: 0 -40 40 +
        #: 0 20 -20
        #: -20 15 5
        8
        0.026
         */
        Integer[] localArray = {-15, -10, 25, 10, 0, -40, 1, 20, -20, 15, 5, 40};
        Integer[] fromFile = new Integer[CreateTestFile.ARRAY_SIZE];

        // Read from file
        In in = new In(CreateTestFile.FILE_NAME);
        for (int i = 0; i < fromFile.length; i++) {
            fromFile[i] = in.readInt();
        }
        in.close();

        /**
         * run the tests
         */
        testCountBase(fromFile);
        testCount1(fromFile);
        //testCountWith2SUM(localArray);
        testCountWithBinarySearch(fromFile);

    }

    private static void testCountBase(Integer[] a) {
        Double[] scores = new Double[NUMBER_OF_TESTS];
        int howMany = 0;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            Stopwatch stopwatch = new Stopwatch();

            howMany = (int) MyThreeSum.countBase(a);
            Double time = stopwatch.elapsedTime();
            scores[i] = time;
            //StdOut.println(time);
        }

        printScore(scores, "\ntestCountBase fo: " +  howMany + " counts\n");

    }

    private static void testCount1(Integer[] a) {
        Double[] scores = new Double[NUMBER_OF_TESTS];
        int howMany = 0;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            Stopwatch stopwatch = new Stopwatch();
            //StdOut.println(SUM3.MyThreeSum.count1(a));
            howMany = (int) MyThreeSum.count1(a);
            Double time = stopwatch.elapsedTime();
            scores[i] = time;
            //StdOut.println(time);
        }

        printScore(scores, "\ntestCount1 fo: " +  howMany +  " counts\n");

    }

    private static void testCountWith2SUM(Integer[] a) {
        Double[] scores = new Double[NUMBER_OF_TESTS];
        int howMany = 0;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            Stopwatch stopwatch = new Stopwatch();
            //StdOut.println(SUM3.MyThreeSum.countWith2SUM(a));
            howMany = (int) MyThreeSum.countWith2SUM(a);
            Double time = stopwatch.elapsedTime();
            scores[i] = time;
            //StdOut.println(time);
        }

        printScore(scores, "\ntestCountWith2SUM fo: " +  howMany +  " counts\n");

    }

    private static void testCountWithBinarySearch(Integer[] a) {
        Double[] scores = new Double[NUMBER_OF_TESTS];
        int howMany = 0;

        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            Stopwatch stopwatch = new Stopwatch();
            //StdOut.println(SUM3.MyThreeSum.countWithBinarySearch(a));
            howMany = (int) MyThreeSum.countWithBinarySearch(a);
            Double time = stopwatch.elapsedTime();
            scores[i] = time;
            //StdOut.println(time);
        }

        printScore(scores, "\ntestCountWithBinarySearch fo: " +  howMany +  " counts\n");

    }

    /**
     * Print min, max & average score
     * @param scores - Array for printing the minimum, maximum and average test speed results.
     */
    private static void printScore(Double[] scores, String s) {
        List<Double> tempScores = Arrays.asList(scores);

        System.out.println(s);
        System.out.println("Min score: " + Collections.min(tempScores));
        System.out.println("Max score: " + Collections.max(tempScores));
        System.out.println("Average score: " + (sum(scores)));
    }

    /**
     * Adder.
     * @param array - array based on which you want to calculate the average.
     * @return Average number by array.
     */
    private static double sum(Double[] array) {
        Double sum = 0.0;
        for (Double i : array) {
            sum += i;
        }
        //System.out.println(sum);
        Double result = sum / array.length; //НЕ РАБОТАЕТ
        //System.out.println(result);

        return result;
    }
}
