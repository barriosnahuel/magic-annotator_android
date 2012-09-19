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
 * @version 1.0.
 * @since 22/03/2012, 09:37:57.
 */
public class RandomGenerator<T> implements Iterator<T> {

    private List<T> numbers = new ArrayList<T>();

    private int position;

    /**
     * A constructor method for the {@link RandomGenerator} type.
     * 
     * @author Nahuel Barrios.
     * @since 22/03/2012.
     * @param values
     *            {@link List} of values to get.
     */
    public RandomGenerator(List<T> values) {
        super();
        this.numbers = values;
    }

    /**
     * TODO : JavaDoc : for RandomGenerator.generate()
     * 
     * @author Nahuel Barrios.
     * @since 22/03/2012.
     * @param minimum
     * @param maximum
     * @return
     * @throws IllegalArgumentException
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
     * @author Nahuel Barrios.
     * @since 22/03/2012.
     * @return
     */
    private int generateNextValueForIteration() {
        return generate(0, numbers.size() - 1);
    }

}
