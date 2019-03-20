import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private int size;
    private Node root;
    private static class Node {
        private Point2D p;      // the point
        private RectHV rect;    // the axis-aligned rectangle corresponding to this node
        private boolean xLevel; // the level of subtree
        private Node lb;        // the left/bottom subtree
        private Node rt;        // the right/top subtree

        Node(Point2D p, RectHV rect) {
            this.p = p;
            this.rect = rect;
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
        root = insert(root, p, new RectHV(0, 0, 1, 1), true);
    }

    private Node insert(Node n, Point2D p, RectHV rect, boolean xLevel) {
        if (n == null) {
            size++;
            return new Node(p, rect);
        }
        if (n.p.equals(p)) {
            return n;
        }
        if (xLevel) {
            if (Point2D.X_ORDER.compare(n.p, p) < 0) {
                n.lb = insert(n.lb, p, new RectHV(n.rect.xmin(), n.rect.ymin(), n.p.x(), n.rect.ymax()), false);
            } else {
                n.rt = insert(n.rt, p, new RectHV(n.p.x(), n.rect.ymin(), n.rect.xmax(), n.rect.ymax()), false);
            }
        } else {
            if (Point2D.Y_ORDER.compare(n.p, p) < 0) {
                n.lb = insert(n.lb, p, new RectHV(n.rect.xmin(), n.rect.ymin(), n.rect.xmax(), n.p.y()), true);
            } else {
                n.rt = insert(n.rt, p, new RectHV(n.rect.xmin(), n.p.y(), n.rect.xmax(), n.rect.ymax()), true);
            }
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
        if (cmp > 0) {
            return contains(n.lb, p, !xLevel);
        } else {
            return contains(n.rt, p, !xLevel);
        }
    }

    /**
     * Draw all points to standard draw.
     */
    public void draw() {
        draw(root, true);
    }

    private void draw(Node n, boolean xLevel) {
        if (xLevel) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(n.p.x(), n.rect.ymin(), n.p.x(), n.rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(n.rect.xmin(), n.p.y(), n.rect.xmax(), n.p.y());
        }
        if (n.lb != null) {
            draw(n.lb, !xLevel);
        }
        if (n.rt != null) {
            draw(n.rt, !xLevel);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        n.p.draw();
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

