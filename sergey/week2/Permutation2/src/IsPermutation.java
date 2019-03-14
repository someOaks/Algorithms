import java.util.Arrays;

public class IsPermutation {
	
	public static boolean isPermute(final int[] A, final int[] B) { // O(n log n + n log n )
		if (A.length != B.length) return false; // O(1)
		
		int matchCounter = 0;
		final int[] sortArray = A.clone(); // O(?)
		final int[] secondArray = B.clone(); // O(?)
		
		Arrays.sort(sortArray); // O(n log n) n < 286; O(n) n < 47; O(?)n > 286;
		for (int i : secondArray) { // O(n)
			if (Arrays.binarySearch(sortArray, i) >= 0) matchCounter++; // O (log n)
		}
		return matchCounter == secondArray.length;
	}
	
	public static boolean alternativeIsPermute(final int[] A, final int[] B) { // O (n + 2 * n log n)
		if (A.length != B.length) return false; // O(1)
		
		final int[] firstArray = A.clone(); // O(?)
		final int[] secondArray = B.clone(); // O(?)
		
		Arrays.sort(firstArray); // O(n log n) n < 286; O(n) n < 47; O(?)  n > 286;
		Arrays.sort(secondArray); // O(n log n) n < 286; O(n) n < 47; O(?) n > 286;
		
		for (int i = 0; i < firstArray.length; i++) { // O(n)
			if (firstArray[i] != secondArray[i]) return false; // O(1)
		}
		return true;
	}
}
