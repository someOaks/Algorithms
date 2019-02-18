import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;

    private Node lastAddedItem;

    private class Node {
        private final Item item;
        private final Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


    public RandomizedQueue() { // construct an empty randomized queue
        this.lastAddedItem = null;
    }

    public boolean isEmpty() { // is the randomized queue empty?
        return size == 0;
    }

    public int size() { // return the number of items on the randomized queue
        return size;
    }

    /**
     * Adds an item to the RandomizedQueue.
     * @param item - what needs to be added to the RandomizedQueue.
     */
    public void enqueue(Item item) { // add the item
        if (item == null) throw new IllegalArgumentException();

        Node tempItem = lastAddedItem;

        lastAddedItem = new Node(item, tempItem);
        size++;
    }

    /**
     * Randomly selects an item from the queue, removes it from the queue, and returns.
     * @return removed random item from RandomizedQueue.
     */
    public Item dequeue() { // remove and return a random item
        return null;
    }
    public Item sample() { // return a random item (but do not remove it)
        return null;
    }
    public Iterator<Item> iterator() { // return an independent iterator over items in random order
        return null;
    }
    public static void main(String[] args) { // unit testing (optional)

    }


}