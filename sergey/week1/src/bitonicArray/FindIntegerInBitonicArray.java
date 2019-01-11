package bitonicArray;

import java.util.Arrays;

/**
 * The class is designed to search in a concrete array of various integers.
 * Each class instance is only one array to search. But in the same array, you can search for different integers.
 */

class FindIntegerInBitonicArray {
	
	private final int[] bitonicArray;
	
	FindIntegerInBitonicArray(int[] bitonicArray) {
		this.bitonicArray = bitonicArray;
	}
	
	
	int correctSolution(int key) {
		Arrays.sort(bitonicArray);
		return Arrays.binarySearch(bitonicArray, key);
	}


	/**
	 * Searches index of element in the array.
	 * @return The index of the item.
	 */
	int findKeyIndex(int key) {
		int index = bitonicArray.length / 2;
		int left = 0;
		int right = bitonicArray.length - 1;
		
		do {
			if (key == bitonicArray[index]) return index;
			if (key == bitonicArray[left]) return left;
			if (key == bitonicArray[right]) return right;
			
			if (key > bitonicArray[index]) { // запустить и справа и слева
				if (isIncreases(index)) {// run right search
					left = index + 1;
					index = left + (right - left) / 2;
				} else { // run left search
					right = index - 1;
					index = left + (right - left) / 2;
				}
			} else {
				int tempIndex = findKeyIndex1(left, index - 1, key); // left
				if (tempIndex >= 0) {
					return tempIndex;
				} else { // right
					return findKeyIndex1(index + 1, right, key);
				}
			}
		} while (left != right);
		
		return -index;
	}
	
	private int findKeyIndex1(int left, int right, int key) {
		int index = left + (right - left) / 2;
		
		do {
			if (key == bitonicArray[index]) return index;
			if (key == bitonicArray[left]) return left;
			if (key == bitonicArray[right]) return right;
			
			if (key < bitonicArray[index] && isIncreases(index)) { // left
				right = index - 1;
				index = left + (right - left) / 2;
			} else if (key < bitonicArray[index] && !isIncreases(index)){ // right
				left = index + 1;
				index = left + (right - left) / 2;
			}
		} while(left != right);
		
		return -index;
	}
	
	/**
	 * Compares the value of two numbers.
	 * @param index number of cell
	 * @return TRUE if the sequence grows & FALSE if the sequence decreases.
	 */
	private boolean isIncreases(int index) {
		return bitonicArray[index] < bitonicArray[index + 1];
	}
	
}