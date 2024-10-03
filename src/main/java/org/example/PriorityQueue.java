package org.example;

/**
 * PriorityQueue interface
 */
public interface PriorityQueue {
    void addHouse(House a);
    House getMostExpensive();
    void clear();
    int getLength();
    boolean isEmpty();


}
