import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * The {@code Solver} class solve a slider puzzle
 */
public class Solver {
    private boolean solvable;
    private SearchNode goalNode;

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private int moves;
        private int priority;
        private SearchNode previous;

        public SearchNode(Board board, int moves, SearchNode previous)  {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
            priority = board.manhattan() + moves;
        }

        @Override
        public int compareTo(SearchNode that) {
            return this.priority - that.priority;
        }
    }

    /**
     * Find a solution to the initial board (using the A* algorithm)
     * @param initial board.
     */
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        SearchNode currentNode, currentNodeTwin;
        Board currentBoard, currentBoardTwin;
        MinPQ<SearchNode> pq = new MinPQ<>();
        MinPQ<SearchNode> pqTwin = new MinPQ<>();
        pq.insert(new SearchNode(initial, 0, null));
        pqTwin.insert(new SearchNode(initial.twin(), 0, null));
        while (true) {
            currentNode = pq.delMin();
            currentNodeTwin = pqTwin.delMin();
            currentBoard = currentNode.board;
            currentBoardTwin = currentNodeTwin.board;
            if (currentBoard.isGoal()) {
                solvable = true;
                goalNode = currentNode;
                return;
            }
            if (currentBoardTwin.isGoal()) {
                solvable = false;
                return;
            }
            Iterable<Board> neighbors = currentBoard.neighbors();
            for (Board nb : neighbors) {
                if (currentNode.previous != null && currentNode.previous.board.equals(nb)) {
                    continue;
                }
                pq.insert(new SearchNode(nb, currentNode.moves + 1, currentNode));
            }
            Iterable<Board> neighborsTwin = currentBoardTwin.neighbors();
            for (Board nb : neighborsTwin) {
                if (currentNodeTwin.previous != null && currentNodeTwin.previous.board.equals(nb)) {
                    continue;
                }
                pqTwin.insert(new SearchNode(nb, currentNodeTwin.moves + 1, currentNodeTwin));
            }
        }
    }

    /**
     * Checks whether the initial board is solvable.
     * @return {@code true} if this board is solvable; {@code false} otherwise
     */
    public boolean isSolvable() {
        return solvable;
    }

    /**
     * Count the number of moves to solve initial board.
     * @return min number of moves; {@code -1} if unsolvable.
     */
    public int moves() {
        if (isSolvable()) {
            return ((Stack<Board>) solution()).size() - 1;
        }
        return -1;
    }

    /**
     * Sequence of boards in a shortest solution.
     * @return sequence of boards; {@code null} if unsolvable.
     */
    public Iterable<Board> solution() {
        if (isSolvable()) {
            Stack<Board> finalBoards = new Stack<>();
            SearchNode current = goalNode;
            while (current != null) {
                finalBoards.push(current.board);
                current = current.previous;
            }
            return finalBoards;
        }
        return null;
    }

    /**
     * Solve a slider puzzle.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}