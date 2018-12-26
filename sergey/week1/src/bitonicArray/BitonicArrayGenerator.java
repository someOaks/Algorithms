package bitonicArray;


import edu.princeton.cs.algs4.Out;

import java.util.*;

/**
 * Creates a file with a test array.
 */
public class BitonicArrayGenerator {
    static final String FILE_NAME = "testBitinicArray" + ".txt";
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
        ArrayList<Integer> tempList = new ArrayList<>(ARRAY_SIZE / 2);

        Object[] tempIntArray;
        int randomInt = generateRandomInt();

        for (int i = 0; i < ARRAY_SIZE / 2; i++ ) {

            //System.out.println(randomInt);
            while (list.contains(randomInt)) randomInt = generateRandomInt();
            list.add(randomInt);
        }

        tempIntArray = list.toArray();

        Arrays.sort(tempIntArray);
        list.clear();
        Collections.addAll(list,  tempIntArray);


        for (int i = 0; i < ARRAY_SIZE / 2; i++ ) {
            randomInt = generateRandomInt();
            //System.out.println(randomInt);
            while (list.contains(randomInt) || tempList.contains(randomInt)) randomInt = generateRandomInt();
            tempList.add(randomInt);
        }

        tempIntArray = tempList.toArray();
        Arrays.sort(tempIntArray);

        for (int i = tempIntArray.length - 1; i >= 0; i--) {
            list.add((Integer) tempIntArray[i]);
        }


        for (int i = 0; i < list.size(); i++) {
            out.println(" " + list.get(i));
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
