import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {
    private int size;
    private Node root;
    private static class Node {
        private Point2D p;      // the point
        private boolean xLevel; // the level of subtree
        private Node lb;        // the left/bottom subtree
        private Node rt;        // the right/top subtree

        Node(Point2D p, boolean xLevel) {
            this.p = p;
            this.xLevel = xLevel;
            this.lb = null;
            this.rt = null;
        }
    }

    /**
     * Construct an empty set of points.
     */
    public KdTree() {
        this.size = 0;
        this.root = null;
    }

    /**
     * Checks the set is empty.
     * @return @code true} if setis empty; {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Counts the number of points in the set.
     * @return number of points in the set.
     */
    public int size() {
        return size;
    }

    /**
     * Add the point to the set (if it is not already in the set).
     * @param p the point.
     */
    public void insert(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        root = insert(root, p, true);
    }

    private Node insert(Node n, Point2D p, boolean xLevel) {
        if (n == null) {
            size++;
            return new Node(p, xLevel);
        }
        if (n.p.equals(p)) {
            return n;
        }
        if (n.xLevel && p.x() < n.p.x() || !n.xLevel && p.y() < n.p.y()) {
            n.lb = insert(n.lb, p, !n.xLevel);
        } else {
            n.rt = insert(n.rt, p, !n.xLevel);
        }
        return n;
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
        return contains(root, p, true);
    }

    private boolean contains(Node n, Point2D p, boolean xLevel) {
        if (n == null) return false;
        if (n.p.equals(p)) return true;
        int cmp;
        if (xLevel) {
            cmp = Point2D.X_ORDER.compare(n.p, p);
        }
        else {
            cmp = Point2D.Y_ORDER.compare(n.p, p);
        }
        if (cmp > 0) return contains(n.lb, p, !xLevel);
        else return contains(n.rt, p, !xLevel);
    }

    /**
     * Draw all points to standard draw.
     */
    public void draw() {

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

    }

    /**
     * Unit testing of the methods (optional).
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

    }
}

