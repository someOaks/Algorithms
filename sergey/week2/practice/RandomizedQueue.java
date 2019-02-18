import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;

    private Item front, tail;



    public RandomizedQueue() { // construct an empty randomized queue

    }
    public boolean isEmpty() { // is the randomized queue empty?
        return size == 0;
    }
    public int size() { // return the number of items on the randomized queue
        return size;
    }
    public void enqueue(Item item) { // add the item

    }
    public Item dequeue() { // remove and return a random item

    }
    public Item sample() { // return a random item (but do not remove it)

    }
    public Iterator<Item> iterator() { // return an independent iterator over items in random order
        return null;
    }
    public static void main(String[] args) { // unit testing (optional)

    }
}