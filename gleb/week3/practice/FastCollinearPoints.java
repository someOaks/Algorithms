import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
    private List<LineSegment> linesList;

    /**
     * Finds all line segments containing 4 or more points.
     *
     * @param points point
     * @throws IllegalArgumentException if <tt>points</tt> is <tt>null</tt> or contains a repeated
     *                                  point, or if any point in the array is <tt>null</tt>
     */
    public FastCollinearPoints(Point[] points) {
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
        linesList = new ArrayList<>();
        Point[] copyPoints = Arrays.copyOfRange(points, 0, points.length);
        for (Point origin : points) {
            // Sort array by points natural order
            Arrays.sort(copyPoints);
            Arrays.sort(copyPoints, origin.slopeOrder());
            linesList.addAll(searchLineSegments(copyPoints,
                                                1,
                                                Duplicates.DUPLICATE_NOT_FOUND,
                                                0,
                                                new ArrayList<LineSegment>()));

            /* Duplicates dup = Duplicates.DUPLICATE_NOT_FOUND;
             for (int start = 0, index = 0; index < copyPoints.length; index++) {
                if (dup == Duplicates.DUPLICATE_NOT_FOUND) {
                    if (index + 1 < copyPoints.length && Double.compare(origin.slopeTo(copyPoints[index]),
                                       origin.slopeTo(copyPoints[index + 1])) == 0) {
                        dup = Duplicates.DUPLICATE_FOUND;
                        start = index;
                    }
                }
                if (dup == Duplicates.DUPLICATE_FOUND) {
                    if (index + 1 < copyPoints.length) {
                        if (Double.compare(origin.slopeTo(copyPoints[index]),
                                           origin.slopeTo(copyPoints[index + 1])) != 0) {
                            dup = Duplicates.DUPLICATE_NOT_FOUND;
                            if (index - start >= 2 && origin.compareTo(copyPoints[start]) < 0) {
                                linesList.add(new LineSegment(origin, copyPoints[index]));
                            }
                        }
                    }
                    else if (index - start >= 2 && origin.compareTo(copyPoints[start]) < 0) {
                        linesList.add(new LineSegment(origin, copyPoints[index]));
                    }
                }
            }*/
        }
    }

    private static List<LineSegment> searchLineSegments(Point[] points, int index, Duplicates status, int start, List<LineSegment> result) {
        Point origin = points[0];
        if (index == points.length) {
            if (index - start - 1 >= 2 && status == Duplicates.DUPLICATE_FOUND &&
                    origin.compareTo(points[start]) < 0) {
                result.add(new LineSegment(origin, points[index - 1]));
            }
            return result;
        }
        if (status == Duplicates.DUPLICATE_NOT_FOUND) {
            if (origin.slopeTo(points[index]) == origin.slopeTo(points[index - 1])) {
                return searchLineSegments(points, index + 1, Duplicates.DUPLICATE_FOUND, index - 1, result);
            }

        }
        if (status == Duplicates.DUPLICATE_FOUND) {
                if (origin.slopeTo(points[index]) !=
                                   origin.slopeTo(points[index - 1])) {
                    if (index - start - 1 >= 2 && origin.compareTo(points[start]) < 0) {
                        result.add(new LineSegment(origin, points[index - 1]));
                    }
                    return searchLineSegments(points, index + 1, Duplicates.DUPLICATE_NOT_FOUND, 0, result);
                }

        }
        return searchLineSegments(points, index + 1, status, start, result);
    }

    private enum Duplicates {
        DUPLICATE_NOT_FOUND,
        DUPLICATE_FOUND
    }

    /**
     * The number of line segments.
     * @return the number of line segments
     */
    public int numberOfSegments() {
        return linesList.size();
    }

    /**
     * Include each line segment containing 4 or more points.
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
        Arrays.sort(points);
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
