package EggDrop;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestEggDrop {

    @Test
    public void testIsBrokenEggFalse() {
        EggDrop.generateBrokenFloor();
        assertFalse(EggDrop.isBrokenEgg(EggDrop.BROKEN_FLOOR - 1));
    }

    @Test
    public void testIsBrokenEggTrue() {
        EggDrop.generateBrokenFloor();
        assertTrue(EggDrop.isBrokenEgg(EggDrop.BROKEN_FLOOR));
        assertTrue(EggDrop.isBrokenEgg(EggDrop.BROKEN_FLOOR + 1));
    }

    @Test
    public void testFindDeathFloorForEgg2False(){
        System.out.println("Test out of range");
        EggDrop.MAXIMUM_FLOORS = 100;
        EggDrop.BROKEN_FLOOR = 101;
        assertEquals(-1, EggDrop.findDeathFloorForEgg2());
    }

    @Test
    public void testFindDeathFloorForEgg2TueMiddle(){

        EggDrop.BROKEN_FLOOR = 7;
        System.out.println("BROKEN_FLOOR = " + EggDrop.BROKEN_FLOOR);
        System.out.println("result of " +EggDrop.BROKEN_FLOOR +" is " + EggDrop.findDeathFloorForEgg2());
        assertEquals(7, EggDrop.findDeathFloorForEgg2());

        EggDrop.BROKEN_FLOOR = 35;
        System.out.println("BROKEN_FLOOR = " + EggDrop.BROKEN_FLOOR);
        System.out.println("result of " +EggDrop.BROKEN_FLOOR +" is " + EggDrop.findDeathFloorForEgg2());
        assert (35 == EggDrop.findDeathFloorForEgg2());


        EggDrop.BROKEN_FLOOR = 65;
        System.out.println("BROKEN_FLOOR = " + EggDrop.BROKEN_FLOOR);
        System.out.println("result of " +EggDrop.BROKEN_FLOOR +" is " + EggDrop.findDeathFloorForEgg2());
        assert (65 == EggDrop.findDeathFloorForEgg2());
    }

    @Test
    public void testFindDeathFloorForEgg2TueMinimum(){
        EggDrop.BROKEN_FLOOR = 1;
        System.out.println("BROKEN_FLOOR = " + EggDrop.BROKEN_FLOOR);
        System.out.println("result of " +EggDrop.BROKEN_FLOOR +" is " + EggDrop.findDeathFloorForEgg2());
        assertEquals(1, EggDrop.findDeathFloorForEgg2());

        EggDrop.BROKEN_FLOOR = 2;
        System.out.println("BROKEN_FLOOR = " + EggDrop.BROKEN_FLOOR);
        System.out.println("result of " +EggDrop.BROKEN_FLOOR +" is " + EggDrop.findDeathFloorForEgg2());
        assertEquals(2, EggDrop.findDeathFloorForEgg2());
    }

    @Test
    public void testFindDeathFloorForEgg2TueMaximum(){

        EggDrop.BROKEN_FLOOR = 100;
        System.out.println("BROKEN_FLOOR = " + EggDrop.BROKEN_FLOOR);
        System.out.println("result of " +EggDrop.BROKEN_FLOOR +" is " + EggDrop.findDeathFloorForEgg2());
        assert (100 == EggDrop.findDeathFloorForEgg2());

        EggDrop.BROKEN_FLOOR = 99;
        System.out.println("BROKEN_FLOOR = " + EggDrop.BROKEN_FLOOR);
        System.out.println("result of " +EggDrop.BROKEN_FLOOR +" is " + EggDrop.findDeathFloorForEgg2());
        assert (99 == EggDrop.findDeathFloorForEgg2());
    }

    @Test
    public void mainTestFindDeathFloorForEgg2() {
        EggDrop.MAXIMUM_FLOORS = Math.abs(new Random().nextInt());
        System.out.println("Now \'" + EggDrop.MAXIMUM_FLOORS + "\' floors!!");

        EggDrop.generateBrokenFloor();
        int findIndex = EggDrop.findDeathFloorForEgg2();
        System.out.println("Broken floor was found: " + findIndex);

        assertEquals(EggDrop.BROKEN_FLOOR, findIndex);
    }
}
