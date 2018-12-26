package bitonicArray;


import java.util.Arrays;

public class TestFindInteger {
    private static int[] array1 = {-10, -7, -2, 0, 1, 3, 5, 8, 7, 6, 4, 2, -1, -3};
    private static int[] array2 = {12, 25, 128, 256, -10, -12000};
    private static int[] array3 = {-125, -2, 6, 12, 5, 0, -4};
    private static int[] a1a = {-10, -7, -2, 0, 1, 3, 5, 8};


    public static void main(String[] args) {

        testFindMax();
    }

    private static void testFindMax(){
        int[] m = {-40, -30, -15, -7, 0, 1, 3, 20, 19, 18, 16, 13};
        System.out.println(FindInteger.findMax(m));
    }

    public static int binarySearch(int[] a, int key) {
        return binarySearch0(a, 0, a.length, key);
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        System.out.println("Begin: low = " + low + " high = " + high);

        while (low <= high) {
            System.out.println("low + high: " +(low + high));

            if (a[low] == key) {
                return low;
            }
            if (a[high] == key) {
                return high;
            }

            int mid = (low + high) >>> 1;
            System.out.println("MID: " +mid +" = " + a[mid]);
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
