import org.junit.Test;

import static org.junit.Assert.*;

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
    public void dequeue() {
    }

    @Test
    public void sample() {
    }

    @Test
    public void iterator() {
    }
}