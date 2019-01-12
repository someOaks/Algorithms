package EggDrop;

import java.util.Random;

class EggDrop {
	private static final int CONSTANT_FLOORS = 100;
	
	private final int MAXIMUM_FLOORS;
	private final int BROKEN_FLOOR;
	
	EggDrop() {
		this(CONSTANT_FLOORS);
	}
	
	EggDrop(final int maximumFloors) {
		this(maximumFloors, (new Random().nextInt(maximumFloors + 1) + 1));
	}
	
	EggDrop(final int maximumFloors, final int brokenFloor) {
		this.MAXIMUM_FLOORS = maximumFloors;
		this.BROKEN_FLOOR = brokenFloor;
	}
	
	/**
	 * Finds the floor from which the eggs begin to die. Up to this floor the eggs remain whole and alive.
	 * @return first death floor index.
	 */
	int findDeathFloorForEgg2() { // log(N)
		
		int middle = MAXIMUM_FLOORS / 2;
		int right = MAXIMUM_FLOORS;
		int left = 1;
		
		// boundary values
		if (isBrokenEgg(1)) return 1;
		if (!isBrokenEgg(MAXIMUM_FLOORS)) return -1;
		
		do {
			// Overall it is not clear to me why you are checking left/right and other dots when you just need to check middle.
			// А я не знаю как по другому. Тут только так я понимаю.
			
			
			// complexity O(2)
			if (!isBrokenEgg(right - 1) && isBrokenEgg(right)) return right;
			// complexity O(2)
			if (!isBrokenEgg(right - 2) && isBrokenEgg(right - 1)) return right - 1;
			
			// complexity O(2)
			if (!isBrokenEgg(left) && isBrokenEgg(left + 1)) return left + 1;
			// complexity O(2)
			if (!isBrokenEgg(middle) && isBrokenEgg(middle + 1)) return middle + 1;
			// complexity O(2)
			if (!isBrokenEgg(middle - 1) && isBrokenEgg(middle)) return middle;
			
			// complexity O(1)
			if (isBrokenEgg(middle)) {
				right = middle;
				middle = middle >> 1; // middle / 2
				
			} else {
				left = middle;
				middle = left + ((right - left) >> 1);
			}
			
		} while(true);// since you are using power of 2 here (by shifting bits) complexity of the loop is log(N), so
		// overall complexity of the loop O(log(N) * const) therefore: O(log(N))
	}
	/**
	 * We test the egg for resistance to falling from the current floor.
	 * @param currentFloor - The floor from which we throw the egg.
	 * @return Result of the throw: broken or not broken.
	 */
	// Complexity O(1)
	boolean isBrokenEgg(final int currentFloor) {
		return !(currentFloor < BROKEN_FLOOR);
	}
	
	int getMAXIMUM_FLOORS() {
		return MAXIMUM_FLOORS;
	}
	
	int getBROKEN_FLOOR() {
		return BROKEN_FLOOR;
	}
}
