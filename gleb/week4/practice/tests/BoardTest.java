import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testHammingWhenInptArrayIsEmpty() {
        int[][] array = new int[4][4];
        Board testBoard = new Board(array);
        System.out.println("hammingDefault:");
        System.out.println(Arrays.deepToString(array));
        assertEquals(0, testBoard.hamming());
    }

    @Test
    void hammingCorrect() {
        int[][] array = new int[4][4];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = count;
                count++;
            }
        }
        System.out.println("hammingCorrect:");
        System.out.println(Arrays.deepToString(array));
        Board testBoard = new Board(array);
        assertEquals(0, testBoard.hamming());
    }

    @Test
    void hammingTwoMistakes() {
        int[][] array = new int[8][8];
        int count = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                array[i][j] = count;
                count++;
            }
        }
        array[0][5] = 51;
        array[5][2] = 6;
        System.out.println("hammingTwoMistakes:");
        System.out.println(Arrays.deepToString(array));
        Board testBoard = new Board(array);
        assertEquals(2, testBoard.hamming());
    }

    @Test
    void hammingFiveMistakes() {
        int[][] array = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        System.out.println("hammingFiveMistakes:");
        System.out.println(Arrays.deepToString(array));
        Board testBoard = new Board(array);
        assertEquals(5, testBoard.hamming());
    }

    @Test
    void hammingLastElement() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        System.out.println("hammingLastElement:");
        System.out.println(Arrays.deepToString(array));
        Board testBoard = new Board(array);
        assertEquals(0, testBoard.hamming());
    }

    @Test
    void manhattanTenDistance() {
        int[][] array = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        System.out.println("manhattanTenDistance:");
        System.out.println(Arrays.deepToString(array));
        Board testBoard = new Board(array);
        assertEquals(10, testBoard.manhattan());
    }
}