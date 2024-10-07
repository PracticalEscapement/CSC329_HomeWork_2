package org.example;

/**
 * PriorityQueueHeap class implements the PriorityQueue interface using a heap data structure.
 */
public class PriorityQueueHeap implements PriorityQueue{

    private House root;
    private House[] heap;
    private int length;

    /**
     * Constructor to initialize the PriorityQueueHeap.
     */
    public PriorityQueueHeap() {
        this.heap = new House[2000];
        this.length = 0;
        this.root = this.heap[0];
    }

    /**
     * Copy constructor to create a deep copy of another PriorityQueueHeap.
     *
     * @param other the PriorityQueueHeap to copy.
     */
    public PriorityQueueHeap(PriorityQueueHeap other) {
        this.heap = new House[2000];
        for (int i = 0; i < other.length; i++) {
            this.heap[i] = other.heap[i].deepCopy();
        }
        this.root = this.heap[0];
        this.length = other.length;
    }

    /**
     * Creates a deep copy of the current PriorityQueueHeap.
     *
     * @return a new PriorityQueueHeap that is a deep copy of the current heap.
     */
    public PriorityQueueHeap deepCopy() {
        PriorityQueueHeap copy = new PriorityQueueHeap();
        for (int i = 0; i < this.length; i++) {
            copy.heap[i] = this.heap[i].deepCopy();
            copy.length++;
        }
        return copy;
    }

    /**
     * Gets the parent index of a given index in the heap.
     *
     * @param index the index of the current element.
     * @return the index of the parent element.
     */
    private int getParent(int index) {
        return (index-1)/2;
    }

    /**
     * Gets the left child index of a given index in the heap.
     *
     * @param index the index of the current element.
     * @return the index of the left child element.
     */
    private int getLeftChild(int index) {
        return (2*index)+1;
    }


    /**
     * Gets the right child index of a given index in the heap.
     *
     * @param index the index of the current element.
     * @return the index of the right child element.
     */
    private int getRightChild(int index) {
        return (2*index)+2;
    }

    /**
     * Adds a house to the heap.
     * Ensures the heap property is maintained
     * @param a the house to add.
     */
    @Override
    public void addHouse(House a) {
        if (this.length == 0) {
            this.heap[0] = a;
            this.root = a;
            this.length++;
            return;
        }
        this.heap[this.length] = a;
        int current = this.length;
        while (a.getValue() > this.heap[getParent(current)].getValue()) {
            swap(current, getParent(current));
            current = getParent(current);
        }
        this.root = this.heap[0];
        this.length++;
    }

    /**
     * Swaps two elements in the heap.
     * Used for the heapify procedure
     * @param current the index of the current element.
     * @param parent  the index of the parent element.
     */
    private void swap(int current, int parent) {
        House temp = this.heap[current];
        this.heap[current] = this.heap[parent];
        this.heap[parent] = temp;
    }

    /**
     * Retrieves and removes the most expensive house from the heap.
     *
     * @return the most expensive house.
     */

    // Despite finding various different implementations that worked, I couldn't seem to fix my own way of doing it.
    // I definitely need to go over some logical error I'm not understanding with you.
    // My guess is that it's something to do with not evaluating the left and right children properly.
    @Override
    public House getMostExpensive() {
        House max = root;
        int current = 0;
        heap[0] = heap[length-1];
        length--;
        while (getGreaterOfChildren(current) != -1 && heap[current].getValue() < heap[getGreaterOfChildren(current)].getValue()) {
            swap(current, getGreaterOfChildren(current));
            current = getGreaterOfChildren(current);
        }
        root = heap[0];
        return max;
    }

    /**
     * Gets the index of the greater child of a given index in the heap.
     *
     * @param index the index of the current element.
     * @return the index of the greater child element, or -1 if no children exist.
     */
    private int getGreaterOfChildren(int index) {
        int greater = -1;
        if (getLeftChild(index) < length-1) {
            if (getRightChild(index) < length-1) {
                greater = heap[getLeftChild(index)].getValue() > heap[getRightChild(index)].getValue() ?
                        getLeftChild(index) : getRightChild(index);
            }
        }
        return greater;
    }

    /**
     * Clears the heap.
     */
    @Override
    public void clear() {
        this.length = 0;
    }


    /**
     * Gets the number of elements within the heap.
     *
     * @return returns number of elements in the heap.
     */
    @Override
    public int getLength() {
        return this.length;
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }
}
