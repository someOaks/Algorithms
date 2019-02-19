import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;

    private Node lastAddedNode, firstNode;

    private class Node {
        private final Item item;
        private  Node next, previous;

        public Node(Item item,  Node previous) {
            this.item = item;
            this.previous = previous;
        }
    }


    public RandomizedQueue() { // construct an empty randomized queue
        this.lastAddedNode = null;
    }

    public boolean isEmpty() { // is the randomized queue empty?
        return size == 0;
    }

    /**
     * @return number of items in the RandomizedQueue.
     */
    public int size() { // return the number of items on the randomized queue
        return size;
    }

    /**
     * Adds an item to the RandomizedQueue.
     * @param item - what needs to be added to the RandomizedQueue.
     */
    public void enqueue(Item item) { // add the item
        if (item == null) throw new IllegalArgumentException();

        if (isEmpty()) {
            lastAddedNode = new Node(item,  null);
            firstNode = lastAddedNode;
        } else {
            Node tempNode = lastAddedNode;
            lastAddedNode = new Node(item, tempNode);
            tempNode.next = lastAddedNode;
        }
        size++;
    }

    /**
     * Randomly selects an item from the queue, removes it from the queue, and returns.
     * @return removed random item from RandomizedQueue.
     */
    public Item dequeue() { // remove and return a random item
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue is empty!");

        Node randomNode = getRandomNode();

        if (size == 1) {
            firstNode = null;
            lastAddedNode = null;
        }

        if (randomNode.previous != null) {
            randomNode.previous.next = randomNode.next;
        }

        if (randomNode.next != null) {
            randomNode.next.previous = randomNode.previous;
        }

        size--;
        return randomNode.item;
    }

    /**
     * Searches for and returns a random item in the queue.
     * @return - item in uniformly random order.
     */
    public Item sample() { // return a random item (but do not remove it)
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue is empty!");

        return getRandomNode().item;
    }

    /**
     * Using a pseudo-random number generator, a node is selected from among
     * those present in the RandomizedQueue.
     * @return - node in uniformly random order.
     */
    private Node getRandomNode() {
        int randoomInt = StdRandom.uniform(size) + 1;
        // System.out.println("RANOMint: " + randoomInt); // Need for test.
        Node result = firstNode;

        if (randoomInt < (size/2)) {
            for (int i = 1; i < randoomInt; i++) {
                result  = result.next;
            }
        }

        if (randoomInt > (size/2)) {
            result = lastAddedNode;
            for (int i = size; i > randoomInt; i--) {
                result = result.previous;
            }
        }

        return result;
    }

    /**
     * Returns a fully independent iterator, passing it all the current elements
     * of the RandomizedQueue.
     * @return - RandomIterator.
     */
    public Iterator<Item> iterator() { // return an independent iterator over items in random order
        Item[] itemArray = (Item[])new Object[size];
        Node currentNode = firstNode;

        for (int i = 0; i < itemArray.length; i++) {
            itemArray[i] = currentNode.item;
            currentNode = currentNode.next;
        }
        return new RandomIterator<Item>(itemArray);
    }

    /**
     * Independent iterator from the surrounding class. After receiving this
     * iterator, the surrounding class can be destroyed.
     */
    private static class RandomIterator<Item> implements Iterator<Item> {

        private int currentIndex = 0;

        private Item[] randomOrderItems;

        private RandomIterator(Item[] itemArray) {
            StdRandom.shuffle(itemArray);
            randomOrderItems = itemArray;
        }

        /**
         * Returns {@code true} if the iteration has more elements. (In other words, returns {@code
         * true} if {@link #next} would return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex < randomOrderItems.length;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("No more elements fo iteration.");
            return randomOrderItems[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Ленинград - дорожная");
        }
    }

    public static void main(String[] args) { // unit testing (optional)

    }
}