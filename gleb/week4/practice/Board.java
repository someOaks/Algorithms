/**
 *  The {@code Board} class represents a search node of the game.
 */
public class Board {
    /**
     * Construct a board from an n-by-n array of blocks,
     * where blocks[i][j] = block in row i, column j
     *
     * @param  blocks array containing the n2 integers between 0 and n2 − 1,
     * where 0 represents the blank square.
     */
    private final int N;
    private final int[][] block;
    public Board(int[][] blocks) {
        N = blocks.length;
        block = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                block[i][j] = blocks[i][j];
            }
        }
    }

/*  public int dimension()                 // board dimension n
    public int hamming()                   // number of blocks out of place
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    public boolean isGoal()                // is this board the goal board?
    public Board twin()                    // a board that is obtained by exchanging any pair of blocks
    public boolean equals(Object y)        // does this board equal y?
    public Iterable<Board> neighbors()     // all neighboring boards
    public String toString()               // string representation of this board (in the output format specified below)

    public static void main(String[] args) // unit tests (not graded)*/

}
