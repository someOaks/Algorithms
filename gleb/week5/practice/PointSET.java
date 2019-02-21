import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PointSET {
    private Set<Point2D> points;

    /**
     * Construct an empty set of points.
     */
    public PointSET() {
        points = new TreeSet<>();
    }

    /**
     * Checks the set is empty.
     * @return @code true} if setis empty; {@code false} otherwise.
     */
    public boolean isEmpty() {
        return points.isEmpty();
    }

    /**
     * Counts the number of points in the set.
     * @return number of points in the set.
     */
    public int size() {
        return points.size();
    }

    /**
     * Add the point to the set (if it is not already in the set).
     * @param p the point.
     */
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        if (!contains(p)) {
            points.add(p);
        }
    }

    /**
     * Checks if the set contain point p.
     * @param p the point.
     * @return {@code true} if set contain point p; {@code false} otherwise.
     */
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        return points.contains(p);
    }

    /**
     * Draw all points to standard draw.
     */
    public void draw() {
        for (Point2D p : points) {
            p.draw();
        }
    }

    /**
     * All points that are inside the rectangle (or on the boundary).
     * @param rect the rectangle.
     * @return all points inside the rectangle.
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        List<Point2D> inRect = new ArrayList<>();
        for (Point2D p : points) {
            if (rect.contains(p)) {
                inRect.add(p);
            }
        }
        return inRect;
    }

    /**
     * A nearest neighbor in the set to point p; null if the set is empty.
     * @param p the point.
     * @return a nearest neighbor.
     */
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        if (points.size() == 0) {
            return null;
        }
        else {
            TreeSet<Point2D> copyPints = new TreeSet<>(p.distanceToOrder());
            copyPints.addAll(points);
            return copyPints.first();
        }
    }

    /**
     * Unit testing of the methods (optional).
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

    }
}

