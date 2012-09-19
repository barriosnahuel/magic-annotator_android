/**
 * RandomGeneratorTest.java Created by: Nahuel Barrios: 22/03/2012, 09:39:57.
 */
package com.nbempire.android.magicannotator.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * This class is for test {@link RandomGeneratorTest} class using JUnit.
 * 
 * @author Nahuel Barrios.
 * @version 1.0.
 * @since 22/03/2012, 09:39:57.
 */
public class RandomGeneratorTest {

    private RandomGenerator<Integer> numbersInstance;

    private RandomGenerator<String> stringsInstance;

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.util.RandomGenerator#generate(int, int)} .
     */
    @Test
    public final void testGenerate_withMinimumLessThanMaximum_returnCorrectNumber() {
        int minimum = 1;
        int maximum = 4;
        int numberOfAsserts = 10;

        for (int i = 0; i < numberOfAsserts; i++) {
            int randomNumber = RandomGenerator.generate(minimum, maximum);
            Assert.assertTrue(randomNumber >= minimum && randomNumber <= maximum);
        }
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.util.RandomGenerator#generate(int, int)} .
     */
    @Test
    public final void testGenerate_withMinimumEqualsThanMaximum_returnSameNumber() {
        int minimum = 5;
        int maximum = 5;

        Assert.assertEquals(minimum, RandomGenerator.generate(minimum, maximum));
    }

    /**
     * Test method for
     * {@link com.nbempire.android.magicannotator.util.RandomGenerator#generate(int, int)} .
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testGenerate_withMinimumGreaterThanMaximum_throwsIllegalArgumentException() {
        int minimum = 4;
        int maximum = 1;
        RandomGenerator.generate(minimum, maximum);
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.util.RandomGenerator#next()} .
     */
    @Test
    public final void testGenerateNext_withCorrectListOfNumbers_returnsOk() {
        List<Integer> numbers = this.dummyListOfNumbers();
        numbersInstance = new RandomGenerator<Integer>(numbers);

        List<Integer> returnedValues = new ArrayList<Integer>(numbers.size());
        while (numbersInstance.hasNext()) {
            Integer aNumber = numbersInstance.next();
            Assert.assertTrue("El valor recuperado (" + aNumber + ") ya existía en los retornados.",
                              !returnedValues.contains(aNumber));
            returnedValues.add(aNumber);
        }
    }

    /**
     * Test method for {@link com.nbempire.android.magicannotator.util.RandomGenerator#next()} .
     */
    @Test
    public final void testGenerateNext_withCorrectListOfStrings_returnsOk() {
        List<String> numbers = this.dummyListOfStrings();
        stringsInstance = new RandomGenerator<String>(numbers);

        List<String> returnedValues = new ArrayList<String>(numbers.size());
        while (stringsInstance.hasNext()) {
            String aString = stringsInstance.next();
            Assert.assertTrue("El valor recuperado (" + aString + ") ya existía en los retornados.",
                              !returnedValues.contains(aString));
            returnedValues.add(aString);
        }
    }

    /**
     * @author Nahuel Barrios.
     * @since 22/03/2012.
     * @return {@link List} de {@link Integer} con valores Dummy para usar para testing.
     */
    private List<Integer> dummyListOfNumbers() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(45);
        numbers.add(130);
        numbers.add(77);
        numbers.add(36);
        numbers.add(74);
        numbers.add(156);
        return numbers;
    }

    /**
     * @author Nahuel Barrios.
     * @since 22/03/2012.
     * @return {@link List} de {@link Integer} con valores Dummy para usar para testing.
     */
    private List<String> dummyListOfStrings() {
        List<String> strings = new ArrayList<String>();
        strings.add("hola");
        strings.add("chau");
        strings.add("blablabla");
        strings.add("un string");
        strings.add("otro String");
        strings.add("Este no lo puse nunca");
        strings.add("String de prueba");
        strings.add("Son todos distintos");
        return strings;
    }

}
