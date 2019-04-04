import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {
    private int size;
    private Node root;
    private static class Node {
        private Point2D p;      // the point
        private RectHV rect;    // the axis-aligned rectangle corresponding to this node
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
            if (Point2D.X_ORDER.compare(p, n.p) < 0) {
                n.lb = insert(n.lb, p, new RectHV(n.rect.xmin(), n.rect.ymin(), n.p.x(), n.rect.ymax()), false);
            } else {
                n.rt = insert(n.rt, p, new RectHV(n.p.x(), n.rect.ymin(), n.rect.xmax(), n.rect.ymax()), false);
            }
        } else {
            if (Point2D.Y_ORDER.compare(p, n.p) < 0) {
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
        Queue<Point2D> q = new Queue<>();
        range(root, rect, q);
        return q;
    }

    private void range(Node n, RectHV rect, Queue<Point2D> q) {
        if (n != null) {
            if (!n.rect.intersects(rect)) {
                return;
            }
            if (rect.contains(n.p)) {
                q.enqueue(n.p);
            }
            range(n.lb, rect, q);
            range(n.rt, rect, q);
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
        return nearest(root, p, root.p, true);
    }

    private Point2D nearest(Node n, Point2D p, Point2D win, boolean xLevel) {
        if (n == null)
            return win;
        if (xLevel) {
            if (p.x() < n.p.x()) {
                win = nearest(n.rt, p, win, false);
                if (n.lb != null && win.distanceSquaredTo(p) > n.lb.rect.distanceSquaredTo(p)) {
                    win = nearest(n.lb, p, win, false);
                }
            } else {
                win = nearest(n.lb, p, win, false);
                if (n.rt != null && win.distanceSquaredTo(p) > n.rt.rect.distanceSquaredTo(p)) {
                    win = nearest(n.rt, p, win, false);
                }
            }
        } else {
            if (p.y() < n.p.y()) {
                win = nearest(n.lb, p, win, true);
                if (n.lb != null && win.distanceSquaredTo(p) > n.lb.rect.distanceSquaredTo(p)) {
                    win = nearest(n.lb, p, win,  true);
                }
            } else {
                win = nearest(n.lb, p, win, true);
                if (n.rt != null && win.distanceSquaredTo(p) > n.rt.rect.distanceSquaredTo(p)) {
                    win = nearest(n.rt, p, win, true);
                }
            }
        }
        return win;
    }


    /**
     * Unit testing of the methods (optional).
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

    }
}

