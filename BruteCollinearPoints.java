/* *****************************************************************************
 *  Description: examines 4 points at a time and checks whether they all lie
 *  on the same line segment, returning all such line segments.
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> linesList;
    /**
     * Finds all line segments containing 4 points.
     * @param points point
     * @throws IllegalArgumentException if <tt>points</tt> is <tt>null</tt>
     * or contains a repeated point, or if any point in the array is <tt>null</tt>
     */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        for (Point p : points) {
            if (p == null) throw new IllegalArgumentException("Point is null");
        }

        // checking if points array contains a repeated point
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Contains a repeated point");
                }
            }
        }
        // List<LineSegment> = new ArrayList<>();
        linesList = new ArrayList<LineSegment>();
        Point[] onLine = new Point[4];
        for (int p = 0; p < points.length - 3; p++)
            for (int q = p + 1; q < points.length - 2; q++)
                for (int r = q + 1; r < points.length - 1; r++) {
                    if (!isCollinear(points, p, q, r)) {
                       continue;
                    }
                        for (int s = r + 1; s < points.length; s++)
                            if (!isCollinear(points, p, r, s)) {
                            onLine[0] = points[p];
                            onLine[1] = points[q];
                            onLine[2] = points[r];
                            onLine[3] = points[s];
                            Arrays.sort(onLine);
                            linesList.add(new LineSegment(onLine[0], onLine[3]));
                    }
                }
    }

    // Calculate whether two points are collinear
    private boolean isCollinear(Point[] points, int p, int q, int r) {
        double s1 = points[p].slopeTo(points[q]);
        double s2 = points[p].slopeTo(points[r]);
        return Double.compare(s1, s2) == 0;
    }
    /**
     * The number of line segments.
      * @return the number of line segments
     */
    public int numberOfSegments() {
        return linesList.size();
    }

    /**
     * Include each line segment containing 4 points exactly once.
     * @return the line segments.
     */
    public LineSegment[] segments() {
        return linesList.toArray(new LineSegment[0]);
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
