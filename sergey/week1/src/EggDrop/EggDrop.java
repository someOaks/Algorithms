package EggDrop;

import java.util.Random;

public class EggDrop {
    private static  int BROKEN_FLOOR;
    private static final int MAXIMUM_FLOORS = 2500;


    /**
     * We test the egg for resistance to falling from the current floor.
     * @param currentFloor - The floor from which we throw the egg.
     * @return Result of the throw: broken or not broken.
     */
    private static boolean isBrokenEgg(final int currentFloor) {
        return !(currentFloor < BROKEN_FLOOR);
    }

    /***
     * Generate death floor number for an egg.
     */
    private static void generateBrokenFloor(){
        Random r = new Random();
        BROKEN_FLOOR = r.nextInt(MAXIMUM_FLOORS) + 1;

    }

    public static void main(String[] args) {

        generateBrokenFloor();
        System.out.println(BROKEN_FLOOR);
    }

}
