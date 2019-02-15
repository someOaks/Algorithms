import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ARRAY deque
 *
 * @param <Item> - some item stored in a two-way queue
 */

public class Deque<Item> implements Iterable<Item> {

    private int size = 0;
    private Item[] items;

    private int head, tail;

    public Deque() {           // construct an empty deque
        items = (Item[])new Object[8];

        head =  (items.length-1) >> 1;
        tail = head + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * Adds an item to the front of the queue.
     * @param item - what you need to add to the queue.
     */
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (head == tail) {
            increaseDeque();
        }

        items[head] = item;
        size++;

        head = (head - 1 < 0) ? ((head - 1) + items.length) : (head - 1);
    }

    /**
     * Adds an item to the tail of the queue.
     * @param item - what you need to add to the queue.
     */
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (head == tail) {
            increaseDeque();
        }

        items[tail] = item;
        size++;

        tail = (tail + 1) < items.length ? (tail + 1) : (tail + 1) % items.length;
    }

    /**
     * Removes and returns an item from the front of the queue.
     * @return - the first element of the queue.
     */
    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();

        head = (head + 1) < items.length ? (head + 1) : (head +1) % items.length;

        Item result = items[head];
        items[head] = null;
        size--;

        if (size < items.length / 3) {
            decreaseDeque();
        }

        return result;
    }

    /**
     * Removes and returns an item from the tail of the queue.
     * @return - the last item in the queue.
     */
    public Item removeLast() {
        if (size == 0) throw new NoSuchElementException();

        tail = (tail - 1 < 0) ? ((tail - 1) + items.length) : (tail - 1);
        Item result = items[tail];
        items[tail] = null;
        size--;

        if (size < items.length / 3) {
            decreaseDeque();
        }


        return result;
    }
    public Iterator<Item> iterator() {         // return an iterator over items in order from front to end
        return new DequeIterator();
    }

    /**
     * Increases the queue size by two.
     */
    private void increaseDeque() {
        final Item[] biggestArray = (Item[])new Object[((size + 1) << 1)];
        final int destinationPosition = (size + 1) >> 1;
        final int numberOfCopiedItems = (items.length - 1) - head;

        System.arraycopy(items, head +1, biggestArray, destinationPosition, numberOfCopiedItems);
        System.arraycopy(items, 0, biggestArray, destinationPosition + numberOfCopiedItems, tail);

        items = biggestArray;
        tail = destinationPosition + numberOfCopiedItems + tail;
        head = destinationPosition - 1;
    }

    /**
     * Вecrease the queue size by two.
     */
    private void decreaseDeque() {
        final Item[] smallerArray = (Item[])new Object[(items.length >> 1)];
        final int destinationPosition = (smallerArray.length - (items.length / 3) + 1) >> 1;
        final int numberOfCopiedItems;

        if (head < tail) {
            numberOfCopiedItems = (tail - head) - 1;
            System.arraycopy(items, head +1, smallerArray, destinationPosition, numberOfCopiedItems);

            tail = destinationPosition + numberOfCopiedItems;
        } else {
            numberOfCopiedItems = (items.length - 1) - head;
            System.arraycopy(items, head +1, smallerArray, destinationPosition, numberOfCopiedItems);
            System.arraycopy(items, 0, smallerArray, destinationPosition + numberOfCopiedItems,
                             tail);

            tail = destinationPosition + numberOfCopiedItems + tail;
        }

        items = smallerArray;

        head = destinationPosition - 1;

    }

    /**
     * Need fo tests.
     * @return array length.
     */
    private int getLength() {
        return items.length;
    }

    private class DequeIterator implements Iterator<Item> {

        private int currentIndex = (head + 1) < items.length ? (head + 1) : (head + 1) % items.length;

        /**
         * Returns {@code true} if the iteration has more elements. (In other words, returns {@code
         * true} if {@link #next} would return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex != Deque.this.tail;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int lastIndex = currentIndex;

            currentIndex = (currentIndex + 1) < items.length ? (currentIndex + 1) : (currentIndex + 1) % items.length;


            return Deque.this.items[lastIndex];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * just for tests.
     * @param args - some input params.
     */
    public static void main(String[] args) {   // unit testing (optional)
        testAddFirst();
        testAddLast();
        testLastANDFirst();

        testRemoveFirst();

        testRemoveLast();
        testAddAfterFullRemove();
        testDecrease();

        testForeich();
    }

    private static void testForeich() {
        System.out.println("### testForeich");
        Deque<String> d = new Deque<>();
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        System.out.println(Arrays.deepToString(d.items));

        d.addLast(String.valueOf(4));
        d.addFirst(String.valueOf(3));
        d.addLast(String.valueOf(5));
        d.addFirst(String.valueOf(2));
        d.addFirst(String.valueOf(1));
        d.addFirst(String.valueOf(0));
        d.addFirst(String.valueOf(-1));
        d.addLast(String.valueOf(6));
        d.addLast(String.valueOf(7));
        d.addLast(String.valueOf(8));
        d.addLast(String.valueOf(9));
        d.addLast(String.valueOf(10));
        d.addLast(String.valueOf(11));
        d.addLast(String.valueOf(12));
        d.addLast(String.valueOf(13));
        d.addLast(String.valueOf(14));

        for (String item : d) {
            System.out.println(item);
        }

        System.out.println(Arrays.deepToString(d.items));
    }

    private static void testAddAfterFullRemove() {
        System.out.println("### testAddAfterFullRemove");
        Deque<String> d = new Deque<>();
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        d.addLast(String.valueOf(4));
        d.addFirst(String.valueOf(3));
        System.out.println(Arrays.deepToString(d.items));
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        System.out.println("delete FIRST: " + d.removeFirst());
        System.out.println("delete FIRST: " + d.removeFirst());
        System.out.println(Arrays.deepToString(d.items));
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);



        System.out.println("Is empty? : " + d.isEmpty());

        d.addFirst(String.valueOf(1));
        System.out.println(Arrays.deepToString(d.items));
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        d.addFirst(String.valueOf(0));
        System.out.println(Arrays.deepToString(d.items));
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        d.addLast(String.valueOf(2));
        System.out.println(Arrays.deepToString(d.items));
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
    }

    private static void testDecrease() {
        System.out.println("### testDecrease");
        Deque<String> d = new Deque<>();
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        System.out.println(Arrays.deepToString(d.items));
        for (int i = 4; i < 12; i++) {
            d.addLast(String.valueOf(i));
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }

        for (int i = 3; i > -4; i--) {
            d.addFirst(String.valueOf(i));
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }

        System.out.println(d.getLength());

        // remove just last:
        for (int i = 0; i < 14; i++) {
            System.out.println("delete LAST: " + d.removeLast());
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }

        System.out.println(d.getLength());
    }

    private static void testRemoveLast() {
        System.out.println("### RemoveLast");
        Deque<String> d = new Deque<>();
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        System.out.println(Arrays.deepToString(d.items));
        for (int i = 4; i < 10; i++) {
            d.addLast(String.valueOf(i));
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }

        for (int i = 4; i < 10; i++) {
            System.out.println("delete LAST: " + d.removeLast());
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }
    }

    private static void testRemoveFirst() {
        System.out.println("### RemoveFirst");
        Deque<String> d = new Deque<>();
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        System.out.println(Arrays.deepToString(d.items));
        for (int i = 3; i > -10; i--) {
            d.addFirst(String.valueOf(i));
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }

        for (int i = 3; i > -10; i--) {
            System.out.println("delete FIRST: " + d.removeFirst());
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }
    }

    private static void testAddFirst() {
        System.out.println("### addFIRST");
        Deque<String> d = new Deque<>();
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        System.out.println(Arrays.deepToString(d.items));

        for (int i = 3; i > -14; i--) {
            d.addFirst(String.valueOf(i));
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }
    }

    private static void testAddLast() {
        System.out.println("### addLAST");
        Deque<String> d = new Deque<>();
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        System.out.println(Arrays.deepToString(d.items));

        for (int i = 4; i < 14; i++) {
            d.addLast(String.valueOf(i));
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }
    }

    private static void testLastANDFirst() {
        System.out.println("### addLAST AND FIRST");
        Deque<String> d = new Deque<>();
        System.out.printf("head: %d, tail: %d \n", d.head, d.tail);

        System.out.println(Arrays.deepToString(d.items));
        for (int i = 3; i > 0; i--) {
            d.addFirst(String.valueOf(i));
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }

        for (int i = 4; i < 14; i++) {
            d.addLast(String.valueOf(i));
            System.out.println(Arrays.deepToString(d.items));
            System.out.printf("head: %d, tail: %d \n", d.head, d.tail);
        }
    }
}