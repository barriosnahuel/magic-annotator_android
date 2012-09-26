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
 * TODO : JavaDoc : for RandomGenerator.
 *
 * @author Nahuel Barrios.
 * @since 1
 */
public class RandomGenerator<T> implements Iterator<T> {

    private List<T> numbers = new ArrayList<T>();

    private int position;

    /**
     * A constructor method for the {@link RandomGenerator} type.
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
     * TODO : JavaDoc : for RandomGenerator.generate()
     *
     * @param minimum
     * @param maximum
     *
     * @return
     *
     * @throws IllegalArgumentException
     * @since 1
     */
    public static int generate(int minimum, int maximum) throws IllegalArgumentException {
        if (minimum > maximum) {
            throw new IllegalArgumentException("El valor mínimo debe ser < que el valor máximo.");
        } else if (minimum == maximum) {
            return minimum;
        }
        return minimum + (int) (Math.random() * maximum);
    }

    public boolean hasNext() {
        return !numbers.isEmpty();
    }

    public T next() {
        position = this.generateNextValueForIteration();
        T result = numbers.get(position);
        this.remove();
        return result;
    }

    public void remove() {
        numbers.remove(position);
    }

    /**
     * TODO : JavaDoc : for RandomGenerator.generateNextValue()
     *
     * @return
     *
     * @since 1
     */
    private int generateNextValueForIteration() {
        return generate(0, numbers.size() - 1);
    }

}
