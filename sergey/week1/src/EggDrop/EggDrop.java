package EggDrop;

import java.util.Random;

class EggDrop {
    // private final?
    static int MAXIMUM_FLOORS = 100;

    // private final?
    static  int BROKEN_FLOOR;

    /**
     * Finds the floor from which the eggs begin to die. Up to this floor the eggs remain whole and alive.
     * @return first death floor index.
     */
    // why is it static?
    static int findDeathFloorForEgg2() {

        int middle = MAXIMUM_FLOORS / 2;
        int right = MAXIMUM_FLOORS;
        int left = 1;
        int iteration = 0;

        // optimization
        // How come this is an optimizaion? unless you do think that 1 will be very common number this is same as to write:
        // if (isBrokenEgg(64)) return 64;
        if (isBrokenEgg(1)) return 1;
        // Same, unless you know something about how often such case might be it is not an optimization.
        if (!isBrokenEgg(MAXIMUM_FLOORS)) return -1;

        do {
            // Overall it is not clear to me why you are checking left/right and other dots when you just need to check middle.
            
            // In the future, for debugging start using logging: https://www.tutorialspoint.com/log4j/log4j_logging_levels.htm
            System.out.println("Iteration: " + iteration); // just for test
            // compexity O(2)
            if (!isBrokenEgg(right - 1) && isBrokenEgg(right)) return right;
            // compexity O(2)
            if (!isBrokenEgg(right - 2) && isBrokenEgg(right - 1)) return right - 1;

            // compexity O(2)
            if (!isBrokenEgg(left) && isBrokenEgg(left + 1)) return left + 1;

            // compexity O(2)
            if (!isBrokenEgg(middle) && isBrokenEgg(middle + 1)) return middle + 1;
            // compexity O(2)
            if (!isBrokenEgg(middle - 1) && isBrokenEgg(middle)) return middle;

            // compexity O(1)
            if (isBrokenEgg(middle)) {
                right = middle;
                middle = middle >> 1;

            } else {
                left = middle;
                middle = left + ((right - left) >> 1);
            }
            // why you need this?
            iteration++;

        } while(true);// since you are using pwer of 2 here (by shifting bits) complexity of the loop is log(N), so
        // overall complexity of the loop O(log(N) * const) therefore: O(log(N))
        // this program will not work untill you return something here.
    }
    /**
     * We test the egg for resistance to falling from the current floor.
     * @param currentFloor - The floor from which we throw the egg.
     * @return Result of the throw: broken or not broken.
     */
    // Comolexity O(1)
    static boolean isBrokenEgg(final int currentFloor) {
        return !(currentFloor < BROKEN_FLOOR);
    }

    // only 2 stars
    /***
     * Generate death floor number for an egg.
     */
    // why is it static?
    static void generateBrokenFloor(){
        Random r = new Random();
        // this is wrong, global static variable that is muted
        BROKEN_FLOOR = r.nextInt(MAXIMUM_FLOORS + 1) + 1;

    }
}
