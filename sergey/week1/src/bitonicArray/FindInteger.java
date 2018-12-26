package bitonicArray;

import java.util.Arrays;

public  class FindInteger {
//
//
//    //{1, 3, 5, 6, 4, 2, 0 , -3 -6 -10}
//    static int find(Integer[] m, Integer number) {
//
//        for (Integer i : m) {
//           // Бинарный поиск: это все время делить на два и искать в нужных половинках или в обеих.
//        }
//    }
//
//    static int referenceMethod(int[] m, int key) {
//        Arrays.sort(m); // n log n
//        return Arrays.binarySearch(m, key); // log n
//
//    }


    /**
     * Searches for the maximum element in the array.
     * @param m - The array in which to search.
     * @return The index of the item.
     */
    static int findMax(int[] m) {
        return findMax(m, 0, m.length);
    }
    /**
     * Searches for the maximum element in the array.
     * @param m - The array in which to search.
     * @return The index of the item.
     */
     static int findMax(int[] m, int fromIndex, int toIndex) {
        int low = fromIndex;
        int high = toIndex - 1;
        int mid = (low + high) >>> 1;

        if (m[low] > m[low + 1]) return low;
        if (m[high] > m[high - 1]) return high;

        int MAX = 0;

        while (low < high) {
            System.out.println("Iteration # " + MAX);
            MAX++;

            if (m[low] < m[mid] && m[mid] > m[high]) {
                low = mid - 1;
                high = mid + 1;
            }

            if (m[mid] < m[low]) {
                high = mid - 1;
                mid = low + 1;
            }

            if (m[mid] < m[high]) {
                low = mid + 1;
                mid = high - 1;
            }



            if (low == high) return low;
        }

        return -(low +1);
    }
}
