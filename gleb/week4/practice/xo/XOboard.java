/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package gleb.week4.practice.xo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class XOboard {
    private final int count;
    private final int[][] board;
   // private final List<XOboard> currentBoard;

    public XOboard() {
        this.board = new int[3][3];
        this.count = 0;
    }

    public XOboard(XOboard xoBoard) {
        board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(xoBoard.board[i], 0, board[i], 0, 3);
        }
        this.count = xoBoard.count + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XOboard xOboard = (XOboard) o;
        return Arrays.deepEquals(board, xOboard.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    public void setFigure(int figure, int boardX, int boardY) {

        board[boardX][boardY] = figure;
    }

    public Set<XOboard> boardGeneration() {
        Set<XOboard> result = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    XOboard child = new XOboard(this);
                    if (count % 2 == 0) {
                        child.setFigure(1, i, j);
                    }
                    else {
                        child.setFigure(-1, i, j);
                    }
                    if (winnFound() || count == 8) {
                        result.add(child);
                    } else {
                        result.addAll(child.boardGeneration());
                    }
                }
            }
        }
        return result;
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
    private boolean winnFound() {
        return board[0][0] != 0 && board[0][0] == board[0][1] && board[0][1] == board[0][2] ||
               board[1][0] != 0 && board[1][0] == board[1][1] && board[1][1] == board[1][2] ||
               board[2][0] != 0 && board[2][0] == board[2][1] && board[2][1] == board[2][2] ||
               board[0][0] != 0 && board[0][0] == board[1][0] && board[1][0] == board[2][0] ||
               board[0][1] != 0 && board[0][1] == board[1][1] && board[1][1] == board[2][1] ||
               board[0][2] != 0 && board[0][2] == board[1][2] && board[1][2] == board[2][2] ||
               board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
               board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0];
    }

    public static void main(String[] args) {
        XOboard test = new XOboard();        ;
        Set<XOboard> tmp = test.boardGeneration();
        for (XOboard t : tmp) {
            t.printBoard();
        }
        System.out.println("Number of boards: " + tmp.size());
    }
}
