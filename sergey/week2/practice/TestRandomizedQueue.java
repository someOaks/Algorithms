import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestRandomizedQueue {

    @Test
    public void testEnqueue() {
        RandomizedQueue<Integer> bagInt = new RandomizedQueue<>();

        assertTrue(bagInt.isEmpty());
        assertEquals(0, bagInt.size());

        for (int i = 0; i < 20; i++) {
            bagInt.enqueue(i);
        }
        assertFalse(bagInt.isEmpty());
        assertEquals(20, bagInt.size());
    }

    @Test
    public void dequeueBig() {
        RandomizedQueue<String> bagInt = new RandomizedQueue<>();

        assertTrue(bagInt.isEmpty());
        assertEquals(0, bagInt.size());

        for (int i = 1; i < 22; i++) {
            bagInt.enqueue(String.valueOf(i));
        }
        assertFalse(bagInt.isEmpty());
        assertEquals(21, bagInt.size());

        for (int i = 1; i < 22; i++) {
            int number = Integer.parseInt(bagInt.dequeue());
            // System.out.println(number);

            assertTrue("number is out of range: " + number, 1 <= number && number <= 21);
        }
    }

    @Test
    public void dequeueLittle() {
        RandomizedQueue<String> bagInt = new RandomizedQueue<>();

        assertTrue(bagInt.isEmpty());
        assertEquals(0, bagInt.size());

        for (int i = 1; i < 3; i++) {
            bagInt.enqueue(String.valueOf(i));
        }
        assertFalse(bagInt.isEmpty());
        assertEquals(2, bagInt.size());

        for (int i = 1; i < 3; i++) {
            int number = Integer.parseInt(bagInt.dequeue());
            // System.out.println(number);

            assertTrue("number is out of range: " + number, 1 <= number && number <= 2);
        }

        assertTrue(bagInt.isEmpty());
        assertEquals(0, bagInt.size());

        bagInt.enqueue(String.valueOf(45));

        assertFalse(bagInt.isEmpty());
        assertEquals(1, bagInt.size());
        assertEquals(45, Integer.parseInt(bagInt.dequeue()));
    }

    @Test
    public void sample21() {
        RandomizedQueue<String> bagInt = new RandomizedQueue<>();

        assertTrue(bagInt.isEmpty());
        assertEquals(0, bagInt.size());

        for (int i = 1; i < 22; i++) {
            bagInt.enqueue(String.valueOf(i));
        }
        assertFalse(bagInt.isEmpty());
        assertEquals(21, bagInt.size());

        for (int i = 0; i < 100; i++) {
            int number = Integer.parseInt(bagInt.sample());
            // System.out.println(number);

            assertTrue("number is out of range: " + number, 1 <= number && number <= 21);
        }
    }

    @Test
    public void sampleMin() {
        RandomizedQueue<String> bagInt = new RandomizedQueue<>();

        assertTrue(bagInt.isEmpty());
        assertEquals(0, bagInt.size());

        bagInt.enqueue(String.valueOf(1));
        assertFalse(bagInt.isEmpty());
        assertEquals(1, bagInt.size());

        bagInt.enqueue(String.valueOf(2));

        for (int i = 0; i < 100; i++) {
            int number = Integer.parseInt(bagInt.sample());
            // System.out.println(number);

            assertTrue("number is out of range: " + number, 1 <= number && number <= 2);
        }
    }

    @Test
    public void iterator21() {
        RandomizedQueue<String> bagInt = new RandomizedQueue<>();

        assertTrue(bagInt.isEmpty());
        assertEquals(0, bagInt.size());

        for (int i = 1; i < 22; i++) {
            bagInt.enqueue(String.valueOf(i));
        }
        assertFalse(bagInt.isEmpty());
        assertEquals(21, bagInt.size());

        int number;
        for (String item: bagInt) {
            number = Integer.parseInt(item);
            assertTrue("number is out of range: " + number, 1 <= number && number <= 21);
        }
    }

    @Test
    public void iterator1() {
        RandomizedQueue<String> bagInt = new RandomizedQueue<>();

        assertTrue(bagInt.isEmpty());
        assertEquals(0, bagInt.size());

        bagInt.enqueue(String.valueOf(1));
        assertFalse(bagInt.isEmpty());
        assertEquals(1, bagInt.size());

        int number;
        for (String item: bagInt) {
            number = Integer.parseInt(item);
            assertTrue("number is out of range: " + number, 1 <= number && number <= 1);
        }
    }
}