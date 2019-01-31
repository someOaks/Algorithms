import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    void testHammingWhenInptArrayIsEmpty() {
        int[][] array = new int[4][4];
        Board testBoard = new Board(array);
        System.out.println("testHammingWhenInptArrayIsEmpty:");
        System.out.println(Arrays.deepToString(array) + "\n");
        assertEquals(0, testBoard.hamming());
    }

    @Test
    void testHammingWhenInptArrayIsCorrect() {
        int[][] array = new int[4][4];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = count;
                count++;
            }
        }
        System.out.println("testHammingWhenInptArrayIsCorrect:");
        System.out.println(Arrays.deepToString(array) + "\n");
        Board testBoard = new Board(array);
        assertEquals(0, testBoard.hamming());
    }

    @Test
    void testHammingWhenInptArrayWithTwoMistakes() {
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
        System.out.println("testHammingWhenInptArrayWithTwoMistakes:");
        System.out.println(Arrays.deepToString(array) + "\n");
        Board testBoard = new Board(array);
        assertEquals(2, testBoard.hamming());
    }

    @Test
    void testHammingWhenInptArrayWithFiveMistakes() {
        int[][] array = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        System.out.println("testHammingWhenInptArrayWithFiveMistakes:");
        System.out.println(Arrays.deepToString(array) + "\n");
        Board testBoard = new Board(array);
        assertEquals(5, testBoard.hamming());
    }

    @Test
    void testHammingWhenLastElementIsZero() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        System.out.println("testHammingWhenLastElementIsZero:");
        System.out.println(Arrays.deepToString(array) + "\n");
        Board testBoard = new Board(array);
        assertEquals(0, testBoard.hamming());
    }

    @Test
    void testManhattanWhenDistanceIsTen() {
        int[][] array = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        System.out.println("manhattanTenDistance:");
        System.out.println(Arrays.deepToString(array) + "\n");
        Board testBoard = new Board(array);
        assertEquals(10, testBoard.manhattan());
    }

    @Test
    void testManhattanWhenDistanceIsZero() {
        int[][] array = new int[4][4];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = count;
                count++;
            }
        }
        System.out.println("testManhattanWhenDistanceIsZero:");
        System.out.println(Arrays.deepToString(array) + "\n");
        Board testBoard = new Board(array);
        assertEquals(0, testBoard.manhattan());
    }

    @Test
    void testToStringFormatPrintingInConsole() {
        int[][] array = new int[4][4];
        Board testBoard = new Board(array);
        System.out.println("testToStringPrintInConsole:");
        System.out.println(testBoard);
        String result = "4\n"
                        + " 0  0  0  0 \n 0  0  0  0 \n 0  0  0  0 \n 0  0  0  0 \n";
        assertEquals(result, testBoard.toString());
    }

    @Test
    void testEqualsWhenTwoArraysAreEqual() {
        int[][] array1 = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        int[][] array2 = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        Board testBoard1 = new Board(array1);
        Board testBoard2 = new Board(array2);
        System.out.println("testEqualsWhenTwoArraysAreEqual:");
        System.out.println(testBoard1);
        System.out.println(testBoard2);
        assertEquals(testBoard1, testBoard2);
    }

    @Test
    void testNeighborsWhtenTwoChilds() {
        int[][] array = {{1, 2, 3}, {4, 0, 6}, {7, 8, 5}};
        int[][] array1 = {{1, 0, 3}, {4, 2, 6}, {7, 8, 5}};
        List<Board> tmp = new ArrayList<>();
        Board testBoard = new Board(array);
        Board testBoard1 = new Board(array1);
        System.out.println("testNeighborsWhtenTwoChilds:");
        for (Board b : testBoard.neighbors()) {
            System.out.println(b.toString());
            tmp.add(b);
        }
        assertEquals(testBoard1, tmp.get(3));
    }
}