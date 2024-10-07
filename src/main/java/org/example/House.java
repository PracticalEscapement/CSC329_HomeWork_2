package org.example;

import java.util.Objects;

/**
 * Represents a house with an owner and a value.
 */
public class House {
    private String owner;
    private int value;

    /**
     * Default constructor that initializes the house with default values.
     */
    // Default constructor
    public House() {
        this.owner = "default";
        this.value = 0;
    }

    /**
     * Constructor that initializes the house with the specified owner and value.
     *
     * @param owner the owner of the house.
     * @param value the value of the house.
     */
    public House(String owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    /**
     * Copy constructor that creates a new house with the same properties as the specified house.
     *
     * @param house the house to copy.
     */
    // copy constructor
    public House(House house) {
        this.owner = house.getOwner();
        this.value = house.getValue();
    }

    /**
     * Creates a deep copy of the current house.
     *
     * @return a new house that is a deep copy of the current house.
     */
    // House Deep Copy
    public House deepCopy() {
        return new House(this.getOwner(), this.getValue());
    }

    /**
     * Gets the owner of the house.
     *
     * @return the owner of the house.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the house.
     *
     * @param owner the new owner of the house.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }


    /**
     * Gets the value of the house.
     *
     * @return the value of the house.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the house.
     *
     * @param value the new value of the house.
     */
    public void setValue(int value) {
        this.value = value;
    }


    /**
     * Checks if this house is equal to another object.
     *
     * @param o the object to compare with.
     * @return true if the houses are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return value == house.value && Objects.equals(owner, house.owner);
    }

}