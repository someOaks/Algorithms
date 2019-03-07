import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Main {
	
	private static int[] randomizedIntArray;
	private static int[] shuffleRandomizedIntArray;
	private static int[] otherRandomizedIntArray;
	private static int ARRAY_SIZE = 12;

    public static void main(String[] args) {
	    System.out.println("Arrays' size is: " + ARRAY_SIZE);
	    createIdenticalArrays();
	    System.out.println(Arrays.toString(randomizedIntArray));
	    System.out.println(Arrays.toString(shuffleRandomizedIntArray));
	    
	    // test "isPermute"
    	assertTrue(IsPermutation.isPermute(randomizedIntArray, shuffleRandomizedIntArray)); // прямо передать массивы
    	assertTrue(IsPermutation.isPermute(shuffleRandomizedIntArray, randomizedIntArray)); // поменять массывы местами
	    // test "alternativeIsPermute"
	    assertTrue(IsPermutation.alternativeIsPermute(randomizedIntArray, shuffleRandomizedIntArray)); // прямо передать массивы
	    assertTrue(IsPermutation.alternativeIsPermute(shuffleRandomizedIntArray, randomizedIntArray)); // поменять массывы местами

	    createDifficultArrays();
	    
	    // test "isPermute"
	    assertFalse(IsPermutation.isPermute(randomizedIntArray, otherRandomizedIntArray)); // передать массивы один за другим.
	    assertFalse(IsPermutation.isPermute(otherRandomizedIntArray , randomizedIntArray)); // поменять местами и передать массивы в тестируемый метод.
	
	    // test "alternativeIsPermute"
	    assertFalse(IsPermutation.isPermute(randomizedIntArray, otherRandomizedIntArray)); // передать массивы один за другим.
	    assertFalse(IsPermutation.isPermute(otherRandomizedIntArray , randomizedIntArray)); // поменять местами и передать массивы в тестируемый метод.
	    
	    System.out.println(Arrays.toString(randomizedIntArray));
	    System.out.println(Arrays.toString(otherRandomizedIntArray));
    }
    
    
    
    private static void createIdenticalArrays() {
		randomizedIntArray = new int[ARRAY_SIZE];
	    
	    Random R = new Random(System.currentTimeMillis());
	
	    for (int i = 0; i < randomizedIntArray.length; i++) {
		    randomizedIntArray[i] = R.nextInt();
	    }
		
		shuffleRandomizedIntArray = randomizedIntArray.clone();
	    StdRandom.shuffle(shuffleRandomizedIntArray);
    }
    
    private static void createDifficultArrays() {
	    randomizedIntArray = new int[ARRAY_SIZE];
	    otherRandomizedIntArray = new int[ARRAY_SIZE];
	
	    Random R = new Random(System.currentTimeMillis());
	
	    for (int i = 0; i < randomizedIntArray.length; i++) {
		    randomizedIntArray[i] = R.nextInt();
		    otherRandomizedIntArray[i] = R.nextInt();
	    }
    }
}