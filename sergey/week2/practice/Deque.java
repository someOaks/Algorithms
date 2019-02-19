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
        items = (Item[]) new Object[8];

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
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    /**
     * Increases the queue size by two.
     */
    private void increaseDeque() {
        final Item[] biggestArray = (Item[]) new Object[((size + 1) << 1)];
        final int destinationPosition = (size + 1) >> 1;
        final int numberOfCopiedItems = (items.length - 1) - head;

        System.arraycopy(items, head +1,
                         biggestArray, destinationPosition,
                         numberOfCopiedItems);
        System.arraycopy(items, 0,
                         biggestArray, destinationPosition + numberOfCopiedItems,
                         tail);

        items = biggestArray;
        tail = destinationPosition + numberOfCopiedItems + tail;
        head = destinationPosition - 1;
    }

    /**
     * Вecrease the queue size by two.
     */
    private void decreaseDeque() {
        final Item[] smallerArray = (Item[]) new Object[(items.length >> 1)];
        final int destinationPosition = (smallerArray.length - (items.length / 3) + 1) >> 1;
        final int numberOfCopiedItems;

        if (head < tail) {
            numberOfCopiedItems = (tail - head) - 1;
            System.arraycopy(items, head +1,
                             smallerArray, destinationPosition,
                             numberOfCopiedItems);

            tail = destinationPosition + numberOfCopiedItems;
        } else {
            numberOfCopiedItems = (items.length - 1) - head;
            System.arraycopy(items, head +1,
                             smallerArray, destinationPosition,
                             numberOfCopiedItems);
            System.arraycopy(items, 0,
                             smallerArray, destinationPosition + numberOfCopiedItems,
                             tail);

            tail = destinationPosition + numberOfCopiedItems + tail;
        }

        items = smallerArray;

        head = destinationPosition - 1;

    }

    private class DequeIterator implements Iterator<Item> {

        private int currentIndex = (head + 1) < items.length ?
                                   (head + 1) :
                                   (head + 1) % items.length;

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

            currentIndex = (currentIndex + 1) < items.length ?
                           (currentIndex + 1) :
                           (currentIndex + 1) % items.length;


            return Deque.this.items[lastIndex];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {   // unit testing (optional)
    }
}