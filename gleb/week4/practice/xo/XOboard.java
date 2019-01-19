/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package gleb.week4.practice.xo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XOboard {
    private final int [][] board;
    private int count = 0;
    private List<XOboard> currentBoard = new ArrayList<>();
    public XOboard(int[][] board) {
        this.board = board;
    }
    public void setFigure(int figure, int boardX, int boardY) {
        board[boardX][boardY] = figure;
    }
    public List<XOboard> boardGeneration() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    if (count % 2 == 0) {
                        this.setFigure(1, i, j);
                        XOboard child = new XOboard(board);
                        currentBoard.add(child);
                        count++;
                        child.boardGeneration();
                        return currentBoard;
                    } else {
                        this.setFigure(-1, i, j);
                        XOboard child = new XOboard(board);
                        currentBoard.add(child);
                        count++;
                        child.boardGeneration();
                        return currentBoard;
                    }
                }
            }
        }
        return currentBoard;
    }
    public int getFigure(int boardX, int boardY) {
        return board[boardX][boardY];
    }
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        XOboard test = new XOboard(new int[3][3]);

        for (XOboard a : test.boardGeneration()) {
            a.printBoard();
        }
        System.out.println("Number of boards: " + test.currentBoard.size());
    }
}
