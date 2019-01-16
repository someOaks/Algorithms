// find the maximum of the array values
public class MaximumArrayValue {
    public static int returnMax(int[] a){
        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {

        int a[] = new int[]{1, 2, 3, 4};
        System.out.println(returnMax(a));
    }
}
