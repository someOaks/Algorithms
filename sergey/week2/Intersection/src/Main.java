import edu.princeton.cs.algs4.Point2D;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		// write your code here
		Point2D A = new Point2D(1, 1);
		Point2D B = new Point2D(1, 1);
		System.out.println("A: " + A.hashCode() + "\nB: " + B.hashCode());
		System.out.println(A.equals(B));
		
		Point2D[] array1 = {new Point2D(1, 1), new Point2D(0, 1), new Point2D(5, 1), new Point2D(4, 1), new Point2D(0, 0), new Point2D(1, 0)};
		Point2D[] array2 = {new Point2D(1, 1), new Point2D(0, 1), new Point2D(5, 1), new Point2D(4, 1), new Point2D(0, 0), new Point2D(1, 0)};
		System.out.println("array1: \n" +Arrays.deepToString(array1));
		System.out.println("array2: \n" +Arrays.deepToString(array2));
		
		IntersectionCounter count = new IntersectionCounter(array1, array2);
		
		System.out.println("Number of intersections: " + count.findTheNumberOfIntersections());
		
		
		Point2D[] array3 = {new Point2D(1, 3), new Point2D(8, 1), new Point2D(5, 1), new Point2D(4, 1), new Point2D(0, 0), new Point2D(25, 0)};
		
		count = new IntersectionCounter(array1, array3);
		
		System.out.println("array1: \n" +Arrays.deepToString(array1));
		System.out.println("array2: \n" +Arrays.deepToString(array3));
		System.out.println("Number of intersections: " + count.findTheNumberOfIntersections());
	}
}