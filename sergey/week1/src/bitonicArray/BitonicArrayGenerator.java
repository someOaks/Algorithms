package bitonicArray;


import edu.princeton.cs.algs4.Out;

import java.util.*;

/**
 * Creates a file with a test array.
 */
public class BitonicArrayGenerator {
    static final String FILE_NAME = "testBitinicArray" + ".txt";
    static final int ARRAY_SIZE = 2500;
    private static Random r = new Random();

    /**
     * These numbers are not repeated within the same file.
     * Generates pseudo-random numbers and writes them into a file.
     * @param args - в сраку
     */
    public static void main(String[] args) {

        Out out = new Out(FILE_NAME); // пишет в файл

        ArrayList list = new ArrayList(ARRAY_SIZE);
        ArrayList<Integer> tempList = new ArrayList<>(ARRAY_SIZE / 2);

        Object[] tempIntArray;
        int randomInt;

        // Забиваем первую половину листа рандомными числами
        for (int i = 0; i < ARRAY_SIZE / 2; i++ ) {
            //System.out.println(randomInt);
            do {
                randomInt = generateRandomInt();
            } while (list.contains(randomInt));
            list.add(randomInt);
        }

        // сортируем рандомные числа
        tempIntArray = list.toArray();
        Arrays.sort(tempIntArray);
        list.clear(); // и добавляем эти рандомные числа в лист
        Collections.addAll(list, tempIntArray);

        // генерируем вторую половину рандомных чисел
        for (int i = 0; i < ARRAY_SIZE / 2; i++ ) {
            do {
                randomInt = generateRandomInt();
            } while (list.contains(randomInt) || tempList.contains(randomInt));
            tempList.add(randomInt);
        }

        // сортируем по возрастанию
        tempIntArray = tempList.toArray();
        Arrays.sort(tempIntArray);
        // и записываем в лист в порядке убывания
        for (int i = tempIntArray.length - 1; i >= 0; i--) {
            list.add(tempIntArray[i]);
        }

        // пишем в файл.
        for (Object aList : list) {
            out.println(" " + aList);
        }
        out.close();
    }

    /**
     * The limits in which pseudo-random numbers are generated are given by the variable ARRAY_SIZE.
     * From -ARRAY_SIZE to + ARRAY_SIZE, including zero.
     * @return Integer in given limits.
     */
    private static int generateRandomInt() {
        return r.nextInt((ARRAY_SIZE + ARRAY_SIZE) - 1) - (ARRAY_SIZE  - 1);
    }
}
