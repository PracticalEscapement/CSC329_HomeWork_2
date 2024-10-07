package org.example;

/**
 * Interface for a priority queue of houses.
 */
public interface PriorityQueue {

    /**
     * Adds a house to the priority queue.
     *
     * @param a the house to add.
     */
    void addHouse(House a);

    /**
     * Retrieves and removes the most expensive house from the priority queue.
     *
     * @return the most expensive house.
     * @throws Exception if the priority queue is empty.
     */
    House getMostExpensive() throws Exception;

    /**
     * Clears the priority queue.
     */
    void clear();

    /**
     * Gets the number of elements in the priority queue.
     *
     * @return the number of elements in the priority queue.
     */
    int getLength();

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the priority queue is empty, false otherwise.
     */
    boolean isEmpty();


}
