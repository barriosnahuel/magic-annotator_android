/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

/**
 * RandomGenerator.java Created by: Nahuel Barrios: 22/03/2012, 09:37:57.
 */
package com.nbempire.android.magicannotator.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Utility type to generate random values.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class RandomGenerator<T> implements Iterator<T> {

    private List<T> numbers = new ArrayList<T>();

    private int position;

    /**
     * A constructor method for the type.
     *
     * @param values
     *         {@link List} of values to get.
     *
     * @since 1
     */
    public RandomGenerator(List<T> values) {
        super();
        this.numbers = values;
    }

    /**
     * Generates a random int value between the specified limits {@code minimum} and {@code maximum}.
     *
     * @param minimum
     *         The minimum value that can be returned.
     * @param maximum
     *         The maximum value that can be returned.
     *
     * @return Random value between the specified limits {@code minimum} and {@code maximum}.
     *
     * @throws IllegalArgumentException
     * @since 1
     */
    private static double generate(int minimum, int maximum) throws IllegalArgumentException {
        double returnValue;
        if (minimum > maximum) {
            throw new IllegalArgumentException("Minimum value has to be less than the maximum one.");
        } else if (minimum == maximum) {
            returnValue = minimum;
        } else {
            returnValue = minimum + (Math.random() * maximum);
        }
        return returnValue;
    }

    public boolean hasNext() {
        return !numbers.isEmpty();
    }

    public T next() {
        position = generateNextValueForIteration();
        T result = numbers.get(position);
        this.remove();
        return result;
    }

    public void remove() {
        numbers.remove(position);
    }

    /**
     * Generates the next random value into a iteration. Sets the minimum value to zero and the maximum to the size of the current List in
     * the iteration.
     *
     * @return Random value between zero and the size of the {@code numbers} type attribute.
     *
     * @since 1
     */
    private int generateNextValueForIteration() {
        //noinspection NumericCastThatLosesPrecision
        return (int) generate(0, numbers.size() - 1);
    }

}
