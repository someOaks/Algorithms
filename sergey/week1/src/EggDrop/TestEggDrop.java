package EggDrop;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestEggDrop {

    @Test
    public void testIsBrokenEggFalse() {
        EggDrop eggDropper = new EggDrop();
        assertFalse(eggDropper.isBrokenEgg(eggDropper.getBROKEN_FLOOR() - 1));
    }

    @Test
    public void testIsBrokenEggTrue() {
        EggDrop eggDropper = new EggDrop();
        assertTrue(eggDropper.isBrokenEgg(eggDropper.getBROKEN_FLOOR()));
        assertTrue(eggDropper.isBrokenEgg(eggDropper.getBROKEN_FLOOR() + 1));
    }

    @Test
    public void testFindDeathFloorForEgg2False(){
        System.out.println("Test out of range");
        EggDrop eggDropper = new EggDrop(100, 101);
        assertEquals(-1, eggDropper.findDeathFloorForEgg2());
    }

    @Test
    public void testFindDeathFloorForEgg2TueMiddle(){
        EggDrop eggDropper = new EggDrop(100, 7);

//        System.out.println("BROKEN_FLOOR = " + eggDropper.getBROKEN_FLOOR());
//        System.out.println("result of " + eggDropper.getBROKEN_FLOOR() +" is " + eggDropper.findDeathFloorForEgg2());
        assertEquals(7, eggDropper.findDeathFloorForEgg2());

        eggDropper = new EggDrop(100, 35);
//        System.out.println("BROKEN_FLOOR = " + eggDropper.getBROKEN_FLOOR());
//        System.out.println("result of " + eggDropper.getBROKEN_FLOOR() +" is " + eggDropper.findDeathFloorForEgg2());
        assertEquals(35, eggDropper.findDeathFloorForEgg2());


        eggDropper = new EggDrop(100, 65);
//        System.out.println("BROKEN_FLOOR = " + eggDropper.getBROKEN_FLOOR());
//        System.out.println("result of " + eggDropper.getBROKEN_FLOOR() +" is " + eggDropper.findDeathFloorForEgg2());
        assertEquals(65, eggDropper.findDeathFloorForEgg2());
    }

    @Test
    public void testFindDeathFloorForEgg2TueMinimum(){
        EggDrop eggDropper;

        eggDropper = new EggDrop(100, 1);
//        System.out.println("BROKEN_FLOOR = " + eggDropper.getBROKEN_FLOOR());
//        System.out.println("result of " + eggDropper.getBROKEN_FLOOR() +" is " + eggDropper.findDeathFloorForEgg2());
        assertEquals(1, eggDropper.findDeathFloorForEgg2());

        eggDropper = new EggDrop(100, 2);
//        System.out.println("BROKEN_FLOOR = " + eggDropper.getBROKEN_FLOOR());
//        System.out.println("result of " + eggDropper.getBROKEN_FLOOR() +" is " + eggDropper.findDeathFloorForEgg2());
        assertEquals(2, eggDropper.findDeathFloorForEgg2());
    }

    @Test
    public void testFindDeathFloorForEgg2TueMaximum(){
        EggDrop eggDropper;

        eggDropper = new EggDrop(100, 100);
//        System.out.println("BROKEN_FLOOR = " + eggDropper.getBROKEN_FLOOR());
//        System.out.println("result of " + eggDropper.getBROKEN_FLOOR() +" is " + eggDropper.findDeathFloorForEgg2());
        assert (100 == eggDropper.findDeathFloorForEgg2());

        eggDropper = new EggDrop(100, 99);
//        System.out.println("BROKEN_FLOOR = " + eggDropper.getBROKEN_FLOOR());
//        System.out.println("result of " + eggDropper.getBROKEN_FLOOR() +" is " + eggDropper.findDeathFloorForEgg2());
        assert (99 == eggDropper.findDeathFloorForEgg2());
    }

    @Test
    public void mainTestFindDeathFloorForEgg2() {
        EggDrop eggDropper = new EggDrop(Math.abs(new Random().nextInt()));

        System.out.println("Now \'" + eggDropper.getMAXIMUM_FLOORS() + "\' floors!!");

        int findIndex = eggDropper.findDeathFloorForEgg2();
        System.out.println("Broken floor was found: " + findIndex);

        assertEquals(eggDropper.getBROKEN_FLOOR(), findIndex);
    }
}
