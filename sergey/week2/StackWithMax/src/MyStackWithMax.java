import java.util.Arrays;

/**
 * This class is essentially a stack for integer elements.
 * This class always knows which is the maximum element in the stack.
 */

class MyStackWithMax {
	
	private int[] stackArray;
	private int[] maxElement;
	
	private int size = 0;
	private Integer lastMaxElement;
	
	/**
	 * Creates an empty stack of the given size.
	 * @param initialCapacity - size of stack.
	 */
	MyStackWithMax(int initialCapacity) {
		stackArray = new int[initialCapacity];
		maxElement = new int[initialCapacity];
	}
	
	/**
	 * Creates just an empty stack.
	 */
	MyStackWithMax() {
		this(10);
	}
	
	/**
	 * Adds an item to the stack.
	 * @param element - The item to add.
	 */
	void push(Integer element) {
		if (isEmpty()) {
			maxElement[0] = lastMaxElement = element;
			stackArray[0] = element;
			size++;
			return;
		}
		
		if (size >= stackArray.length) {
			stackArray = Arrays.copyOf(stackArray, size * 2);
			maxElement = Arrays.copyOf(maxElement, size * 2);
		}
		
		stackArray[size] = element;
		maxElement[size] = lastMaxElement = element > lastMaxElement ? element : lastMaxElement;
		
		size++;
	}
	
	/**
	 * Removes an item from the stack and then returns it.
	 * @return - The top element of the stack.
	 */
	Integer pop() {
		--size;
		
		if (size  < stackArray.length /4 && size > 0) {
			stackArray = Arrays.copyOf(stackArray, size * 2);
			maxElement = Arrays.copyOf(maxElement, size * 2);
		}
		return stackArray[size];
	}
	
	/**
	 * Checks the stack emptiness.
	 * @return {@code false} if it is not empty.
	 */
	boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Checks size of the stack.
	 * @return stack size.
	 */
	int size() {
		return size;
	}
	
	/**
	 * This service method is required for tests.
	 * @return the size of the main array with elements.
	 */
	int getStackArrayLength() {
		return stackArray.length;
	}
	
	/**
	 * Shows the maximum item on the stack at the moment.
	 * @return maximum element.
	 */
	Integer getMaxElement() {
	 	return maxElement[size -1];
	}
}