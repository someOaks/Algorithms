import java.util.Arrays;

public class Permutation {
    public static boolean isPerm(int[] a, int[] b){

        int lenA = a.length;
        int lenB = b.length;

        if (lenA != lenB) return false;

        int[] a1 = a.clone();
        int[] b1 = b.clone();

        Arrays.sort(a1);
        Arrays.sort(b1);

        for (int i = 0; i < lenA; i++) {
            if (a1[i] != b1[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPerm(new int[]{1, 3, 2}, new int[]{1, 2, 3}));
        System.out.println(isPerm(new int[]{1, 3, 2, 1}, new int[]{1, 2, 3}));
        System.out.println(isPerm(new int[]{1, 3, 1}, new int[]{1, 2, 3}));
        System.out.println(isPerm(new int[]{1}, new int[]{1, 2, 3}));

    }
}
