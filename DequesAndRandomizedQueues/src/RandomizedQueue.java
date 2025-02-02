import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[INITIAL_CAPACITY];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }
        if (size == items.length) {
            resizeContainer(items.length * 2);
        }
        items[size++] = item;
    }

    private void resizeContainer(int newCapacity) {
        Item[] newItems = (Item[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("RandomizedQueue is empty");
        }
        if (size() == 1) {
            var res = items[0];
            size--;
            return res;
        }
        var randomIndex = StdRandom.uniformInt(size);
        var res = items[randomIndex];
        items[randomIndex] = null;
        items[randomIndex] = items[size - 1];
        size--;
        if (size == items.length / 4) {
            resizeContainer(items.length / 2);
        }
        return res;
    }


    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("RandomizedQueue is empty");
        }
        var index = StdRandom.uniformInt(size);
        return items[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int copySize;
        private final Item[] copyItems;

        public RandomizedQueueIterator() {
            copySize = size;
            copyItems = (Item[]) new Object[size];
            System.arraycopy(items, 0, copyItems, 0, copySize);
        }

        @Override
        public boolean hasNext() {
            return copySize > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("RandomizedQueue has no more elements");
            }
            var index = StdRandom.uniformInt(copySize);
            var item = copyItems[index];
            copyItems[index] = null;
            copyItems[index] = copyItems[copySize - 1];
            copySize--;
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        int n = 5;
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        for (int i = 0; i < n; i++) {
            randomizedQueue.enqueue(i);
        }
        System.out.println(randomizedQueue.sample());
        for (int a : randomizedQueue) {
            for (int b : randomizedQueue) {
                System.out.print(a + "-" + b + " ");
            }
            System.out.println();
        }
        while (!randomizedQueue.isEmpty()) {
            System.out.println(randomizedQueue.dequeue() + " ");
        }
    }

}