package bitonicArray;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestFindInteger {
    private static int[] array1 = {-10, -7, -2, 0, 1, 3, 5, 8, 7, 6, 4, 2, -1, -3}; // center
    private static int[] array2 = {12, 25, 128, 256, -10, -11, -12, -13, -14, -15, -500}; // убывание
    private static int[] array3 = {-125, -2, 6, 12, 5, 0, -4}; // Центр
    private static int[] array4 = {-10, -7, -2, 0, 1, 3, 5, 8}; // Возрастание
    private static int[] array5 = {-7, -6, -4, -2, 1, 2, 4, 6, 8, 7, 5, 3, 0, -1, -3, -5, -8, -12, -13, -15}; // хитровыебаный

    private final static int NUMBER_OF_TESTS = 250;



    public static void main(String[] args) {
		// search for existing elements in the array
        testBitonicArrayFromConstant(array1, -1, "center", 12);
        testBitonicArrayFromConstant(array2, -11, "убывание", 5);
        testBitonicArrayFromConstant(array3, -2, "Центр", 1);
        testBitonicArrayFromConstant(array4, 8, "Возростание", 7);
	
		for (int i = 0; i < array5.length; i++) {
			testBitonicArrayFromConstant(array5, array5[i], "хитрый итерация №" + i, i);
		}
		// search for non-existent elements in the array
		testBitonicArrayFromConstant(array1, 9, "center", -1);
		testBitonicArrayFromConstant(array5, -14, "хитрый с несуществующим элементом" , -1);




        int[] fromFile =  new int[BitonicArrayGenerator.ARRAY_SIZE];
        In in = new In(BitonicArrayGenerator.FILE_NAME);
        for (int i = 0; i < fromFile.length; i++) {
            fromFile[i] = in.readInt();
        }
        in.close();

        testBitonicArrayFromFile(fromFile);
    }


    private static void testBitonicArrayFromFile(int[] a) {
        System.out.println("## testBitonicArrayFromFile ## KEY: random");
        Random random = new Random();
        Double[] scores;
        FindIntegerInBitonicArray finder = new FindIntegerInBitonicArray(a);

        scores = new Double[NUMBER_OF_TESTS];
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            int key = random.nextInt(BitonicArrayGenerator.ARRAY_SIZE);
            Stopwatch stopwatch = new Stopwatch();
            finder.findKeyIndex(key);
            Double time = stopwatch.elapsedTime();
            scores[i] = time;
        }

        printScore(scores);
    }

    private static void testBitonicArrayFromConstant(int[] a, int b, String typeArray, int trueIndex) {
        System.out.println("## testBitonicArrayFromConstant ## KEY: " + b + "; TYPE: " + typeArray +"::" + Arrays.toString(a));
        FindIntegerInBitonicArray finder = new FindIntegerInBitonicArray(a);
    
        int g = finder.findKeyIndex(b);
        
        if (g != trueIndex) throw new RuntimeException("invalid index found");
        
        System.out.println("My method return key index = " + g);
        System.out.println("                True index = " + trueIndex + "\n");
    }

    private static void printScore(Double[] scores) {
        List<Double> tempScores = Arrays.asList(scores);

        System.out.println("Min score: " + Collections.min(tempScores));
        System.out.println("Max score: " + Collections.max(tempScores));
        System.out.println("Average score: " + (sum(scores)));
    }

    private static double sum(Double[] array) {
        Double sum = 0.0;
        for (Double i : array) {
            sum += i;
        }
        return sum / array.length;
    }
}
