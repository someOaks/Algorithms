import java.util.Collection;
import java.util.Stack;

public class MyTwoStackQueue<T> {
	
	private int size = 0;
	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();
	
	/**
	 * Returns the number of elements in this collection.  If this collection
	 * contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
	 * <tt>Integer.MAX_VALUE</tt>.
	 *
	 * @return the number of elements in this collection
	 */
	int size() {
		return size;
	}
	
	/**
	 * Returns true if this collection contains no elements.
	 *
	 * @return true if this collection contains no elements
	 */
	boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions, returning
	 * {@code true} upon success.
	 *
	 * @param o the element to add
	 * @return {@code true} (as specified by {@link Collection#add})
	 */
	boolean add(T o) {
		size++;
		return stack1.add(o);
	}
	
	
	/**
	 * Retrieves and removes the head of this queue,
	 * or returns {@code null} if this queue is empty.
	 *
	 * @return the head of this queue, or {@code null} if this queue is empty
	 */
	Object poll() {
		if (size == 0) return null;
		
		if (stack2.empty()) {
			transferElements();
		}
		
		size--;
		
		return stack2.pop();
	}
	
	/**
	 * Retrieves, but does not remove, the head of this queue,
	 * or returns {@code null} if this queue is empty.
	 *
	 * @return the head of this queue, or {@code null} if this queue is empty
	 */
	Object peek() {
		if (size == 0) return null;
		
		if (stack2.empty()) {
			transferElements();
		}
		
		return stack2.peek();
	}
	
	/**
	 * Flip items from one stack to the second.
	 */
	private void transferElements() {
		while (!stack1.empty()) {
			stack2.push(stack1.pop());
		}
	}
}
