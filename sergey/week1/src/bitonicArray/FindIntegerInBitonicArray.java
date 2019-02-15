package bitonicArray;

/**
 * The class is designed to search in a concrete array of various integers.
 * Each class instance is only one array to search. But in the same array, you can search for different integers.
 */

class FindIntegerInBitonicArray {
	
	private final int[] bitonicArray;
	
	FindIntegerInBitonicArray(int[] bitonicArray) {
		this.bitonicArray = bitonicArray;
	}
	
	/**
	 * Searches index of element in the searchInBitonicArray array.
	 * @return The index of the item.
	 */
	int findKeyIndex( int key) {
		
		int left = 0;
		int right = bitonicArray.length - 1;
		return findKeyIndexRecursive(left, right, key);
	}
	
	/**
	 * Searches index of element in the array.
	 * @return The index of the item.
	 */
	//2
	//{-7, -6, -4, -2, 1, 2, 4, 6, 7, 9, 5, 3, 0, -1, -3, -5, -8, -12, -13, -15}
	private int findKeyIndexRecursive(int left, int right, int key) {
		
		int middle = left + (right - left) / 2;
		
		if (left < right) {
			if (key == bitonicArray[middle]) return middle;
			if (key == bitonicArray[left]) return left;
			if (key == bitonicArray[right]) return right;
			
			if (key > bitonicArray[middle]) { // запустить и справа и слева
				if (bitonicArray[middle] < bitonicArray[middle + 1]) {// run right search
					return findKeyIndexRecursive(middle + 1, right, key);
				} else { // run left search
					return  findKeyIndexRecursive(left, middle - 1, key);
				}
			} else { // key < bitonicArray[index]
				int tempIndex = findKeyIndexRecursive(middle + 1, right, key); // right
				if (tempIndex >= 0) {
					return tempIndex;
				} else { // right
					return findKeyIndexRecursive(left, middle - 1, key);
				}
			}
		}
		
		return -1;
	}
}