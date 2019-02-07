import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;

/**
 *  The {@code Board} class represents a search node of the game.
 */
public class Board {
    private final int N;
    private final int[][] block;

    /**
     * Construct a board from an n-by-n array of blocks,
     * where blocks[i][j] = block in row i, column j
     *
     * @param  blocks array containing the n2 integers between 0 and n2 − 1,
     *         where 0 represents the blank square.
     */
    public Board(int[][] blocks) {
        N = blocks.length;
        block = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                block[i][j] = blocks[i][j];
            }
        }
    }

    /**
     * Board dimension N.
     *
     * @return board dimension.
     */
    public int dimension() {
        return N;
    }

    /**
     * Number of blocks out of place.
     * @return number of blocks.
     */
    public int hamming() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (block[i][j] != i * N + j + 1 && block[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Sum of Manhattan distances between blocks and goal.
     * @return sum of distances.
     */
    public int manhattan() {
        int x, y, count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (block[i][j] != i * N + j + 1 && block[i][j] != 0) {
                    x = N - ((N * N - block[i][j])/N);
                    y = N - (x * N - block[i][j]);
                    count = count + Math.abs(i - (x - 1)) + Math.abs(j - (y - 1));
                }
            }
        }
        return count;
    }

    /**
     * Checks whether this board is the goal board.
     * @return goal board status.
     */
    public boolean isGoal() {
        return hamming() == 0;
    }

    /**
     * Swaps any pair of blocks
     * @return a board that is obtained by exchanging any pair of blocks.
     */
    public Board twin() {
        Board twin = new Board(block);
        if (twin.block[0][0] != 0 && twin.block[0][1] != 0) {
            int tmp = twin.block[0][0];
            twin.block[0][0] = twin.block[0][1];
            twin.block[0][1] = tmp;
        } else {
            int tmp = twin.block[1][0];
            twin.block[1][0] = twin.block[1][1];
            twin.block[1][1] = tmp;
        }
        return twin;
    }

    /**
     * Checks whether this board is equal to the board y
     * @param y the other board
     * @return {@code true} if this board is equal to {@code y}; {@code false} otherwise
     */
    @Override
    public boolean equals(Object y) {
        if (y == this) {
            return true;
        }
        if (y == null) {
            return false;
        }
        if (y.getClass() != this.getClass()) {
            return false;
        }
        Board that = (Board)y;
        return Arrays.deepEquals(block, that.block);
    }

    /**
     * Create all neighboring boards.
     * @return all neighboring boards.
     */
    public Iterable<Board> neighbors() {
        Stack<Board> stackOfBoards = new Stack<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(block[i][j] == 0) {
                    if (i - 1 >= 0) {
                        Board child1 = new Board(block);
                        exch(child1.block, i, j,i-1, j);
                        stackOfBoards.push(child1);
                    }
                    if (i + 1 < N) {
                        Board child2 = new Board(block);
                        exch(child2.block, i, j, i + 1, j);
                        stackOfBoards.push(child2);
                    }
                    if (j - 1 >= 0) {
                        Board child3 = new Board(block);
                        exch(child3.block, i, j, i, j - 1);
                        stackOfBoards.push(child3);
                    }
                    if (j + 1 < N) {
                        Board child4 = new Board(block);
                        exch(child4.block, i, j, i, j + 1);
                        stackOfBoards.push(child4);
                    }
                }
            }
        }
        return stackOfBoards;
    }

    /**
     * String representation of this board.
     * @return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    s.append(String.format("%2d ", block[i][j]));
                }
            s.append("\n");
            }
        return s.toString();
        }

    // exchange a[a][b] and a[c][d]
    private void exch(int[][] s, int a, int b, int c, int d) {
        int swap = s[a][b];
        s[a][b] = s[c][d];
        s[c][d] = swap;
    }

   /**
     * Unit tests the Board data type.
     */
   public static void main(String[] args) {
   }
}
