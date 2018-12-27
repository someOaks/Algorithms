package EggDrop;

import java.util.Random;

class EggDrop {
    static int MAXIMUM_FLOORS = 100;

    static  int BROKEN_FLOOR;

    /**
     * Finds the floor from which the eggs begin to die. Up to this floor the eggs remain whole and alive.
     * @return first death floor index.
     */
    static int findDeathFloorForEgg2() {

        int middle = MAXIMUM_FLOORS / 2;
        int right = MAXIMUM_FLOORS;
        int left = 1;
        int iteration = 0;

        // optimization
        if (isBrokenEgg(1)) return 1;
        if (!isBrokenEgg(MAXIMUM_FLOORS)) return -1;

        do {
            System.out.println("Iteration: " + iteration); // just for test
            if (!isBrokenEgg(right - 1) && isBrokenEgg(right)) return right;
            if (!isBrokenEgg(right - 2) && isBrokenEgg(right - 1)) return right - 1;

            if (!isBrokenEgg(left) && isBrokenEgg(left + 1)) return left + 1;

            if (!isBrokenEgg(middle) && isBrokenEgg(middle + 1)) return middle + 1;
            if (!isBrokenEgg(middle - 1) && isBrokenEgg(middle)) return middle;

            if (isBrokenEgg(middle)) {
                right = middle;
                middle = middle >> 1;

            } else {
                left = middle;
                middle = left + ((right - left) >> 1);
            }

            iteration++;

        } while(true);

    }
    /**
     * We test the egg for resistance to falling from the current floor.
     * @param currentFloor - The floor from which we throw the egg.
     * @return Result of the throw: broken or not broken.
     */
    static boolean isBrokenEgg(final int currentFloor) {
        return !(currentFloor < BROKEN_FLOOR);
    }

    /***
     * Generate death floor number for an egg.
     */
    static void generateBrokenFloor(){
        Random r = new Random();
        BROKEN_FLOOR = r.nextInt(MAXIMUM_FLOORS + 1) + 1;

    }
}
