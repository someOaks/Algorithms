import edu.princeton.cs.algs4.Point2D;

import java.util.Arrays;


/**
 * This type allows you to count the number of intersections of two arrays of points,
 * without changing the potentially intersecting arrays.
 */
public class IntersectionCounter {
	private final Point2D[] A;
	private final Point2D[] B;
	private int intersectionCounter = 0;
	private boolean ArraySwitch = false;
	
	public IntersectionCounter(Point2D[] a, Point2D[] b) {
		A = a.clone();
		B = b.clone();
		if (A.length <= B.length) ArraySwitch = true;
	}
	
	public int findTheNumberOfIntersections() {
		
		if (ArraySwitch) {
			counter(A, B);
		} else {
			counter(B, A);
		}
		
		return intersectionCounter;
	}
	
	private void counter(Point2D[] firstArray, Point2D[] secondArray) {
		Arrays.sort(firstArray);
		
		for (Point2D point : secondArray) {
			if (Arrays.binarySearch(firstArray, point) >= 0) intersectionCounter++;
		}
	}
}