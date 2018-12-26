package SUM3;

import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creates a file with a test array.
 */

public class CreateTestFile {
    static final String FILE_NAME = "testArray" + ".txt";
    static final int ARRAY_SIZE = 2500;
    static Random r = new Random();

    /**
     * These numbers are not repeated within the same file.
     * Generates pseudo-random numbers and writes them into a file.
     * @param args - в сраку
     */
    public static void main(String[] args) {

        Out out = new Out(FILE_NAME);
        List list = new ArrayList(ARRAY_SIZE);

        for (int i = 0; i < ARRAY_SIZE; i++ ) {
            int randomInt = generateRandomInt();
            System.out.println(randomInt);
            while (list.contains(randomInt)) randomInt = generateRandomInt();
            list.add(randomInt);
            out.println(" " + randomInt);
        }
        out.close();
    }

    /**
     * The limits in which pseudo-random numbers are generated are given by the variable ARRAY_SIZE.
     * From -ARRAY_SIZE to + ARRAY_SIZE, including zero.
     * @return Integer in given limits.
     */
    private static int generateRandomInt() {
        return r.nextInt((ARRAY_SIZE + ARRAY_SIZE) - 1) - (ARRAY_SIZE  - 1);
    }
}
