import java.util.Arrays;
import java.util.Random;

public class Main {
    
    private static int ARRAY_SIZE = 20;

    public static void main(String[] args) {
	
        Pebble[] arrayPebble = new Pebble[ARRAY_SIZE];
        Pebble[] tempArrayPebble = Pebble.values();
        int tempArrayPebbleSize = tempArrayPebble.length;
        
        Random R = new Random(System.currentTimeMillis());
    
        for (int i = 0; i < ARRAY_SIZE; i++) {
             arrayPebble[i] = Pebble.values()[R.nextInt(tempArrayPebbleSize)];
        }
    
        System.out.println("Before sort: \n" + Arrays.toString(arrayPebble));
        
        Arrays.sort(arrayPebble);
    
        System.out.println("Before after system sort: \n" + Arrays.toString(arrayPebble));
        
        Pebble.blue.compareTo(Pebble.blue);
    }
}
