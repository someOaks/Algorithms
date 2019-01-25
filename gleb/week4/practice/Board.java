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
  /*


    public boolean equals(Object y)        // does this board equal y?
    public Iterable<Board> neighbors()     // all neighboring boards
    public String toString()               //  (in the output format specified below)
  */


    /**
     * String representation of this board.
     * @return string representation.
     */
   /* public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }*/
    /**
     * Unit tests the Board data type.
     */
    public static void main(String[] args) {
    }
}
