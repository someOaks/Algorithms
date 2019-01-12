package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private boolean[][] board;
    private WeightedQuickUnionUF cells; // for percolates()
//    private WeightedQuickUnionUF back; // for isFull()
    private int numberOpenCells = 0;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n)  {
        if (n <= 0)
            throw new IllegalArgumentException();

        this.board = new boolean[n][n];
        this.cells = new WeightedQuickUnionUF(n * n + 2);
        this.n = n;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col){
        if (row <= 0 || col > this.n || row > this.n || col <= 0) throw new IllegalArgumentException();

        //if site is not open
        if (!this.board[col - 1][row - 1]) {
            //than open it
            this.board[col - 1][row - 1] = true;
            numberOpenCells ++;

            int colUp = col;
            int rowUp = row - 1;

            int index = convertToIndex(row, col);
            int indexUp = convertToIndex(rowUp, colUp);

            if (rowUp != 0 && isOpen(rowUp, colUp)) {
                this.cells.union(index, indexUp);
            } else
            if (rowUp == 0) {
                this.cells.union(index,0);
            }

            int colDown = col;
            int rowDown = row + 1;

            int indexDown = convertToIndex(rowDown, colDown);

            if (rowDown != this.n + 1 && isOpen(rowDown, colDown)) {
                this.cells.union(index, indexDown);
            } else
            if (rowDown == this.n + 1) {
                this.cells.union(index, this.n * this.n + 1);
            }

            int colRight = col + 1;
            int rowRight = row;

            int indexRight = convertToIndex(rowRight, colRight);

            if (colRight != this.n + 1 && isOpen(rowRight, colRight)) {
                this.cells.union(index, indexRight);
            }

            int colLeft = col - 1;
            int rowLeft = row;

            int indexLeft = convertToIndex(rowLeft, colLeft);

            if (colLeft != 0 && isOpen(rowLeft, colLeft)) {
                this.cells.union(index, indexLeft);
            }

        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col){
        if (row <= 0 || col > this.n || row > this.n || col <= 0) throw new IllegalArgumentException();

        return this.board[col - 1][row - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || col > this.n || row > this.n || col <= 0) throw new IllegalArgumentException();

        return cells.connected(0, convertToIndex(row,col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numberOpenCells;
    }

    // does the system percolate?
    public boolean percolates() {

        return cells.connected(0, this.n * this.n + 1);
    }

    public static void main(String[] args) {
        Percolation masaynya = new Percolation(2);

        masaynya.open(1, 1);
        masaynya.open(2, 2);
        masaynya.open(1, 2);

        for (int row = 1; row <= 2; row++) {
            System.out.print("\n|--- | ---|\n");
            for (int col = 1; col <= 2; col++) {

                String status = "F";
                if (masaynya.isOpen(row, col)){
                    status = "T";
                }
                System.out.print("   " + status);
            }
        }
    }

    private int convertToIndex(int row, int col){
        return (col - 1) * this.n + row;
    }
}
