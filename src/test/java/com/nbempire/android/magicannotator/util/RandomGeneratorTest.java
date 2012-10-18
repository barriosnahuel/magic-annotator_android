/*
 * Copyright (c) 2012 Nahuel Barrios <barrios.nahuel@gmail.com>.
 * No se reconocerá ningún tipo de garantía.
 */

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
 * @since 1
 */
public class RandomGeneratorTest {

    /**
     * Test method for {@link com.nbempire.android.magicannotator.util.RandomGenerator#next()} .
     */
    @Test
    public final void testGenerateNext_withCorrectListOfNumbers_returnsOk() {
        List<Integer> numbers = this.dummyListOfNumbers();
        RandomGenerator<Integer> numbersInstance = new RandomGenerator<Integer>(numbers);

        List<Integer> returnedValues = new ArrayList<Integer>(numbers.size());
        while (numbersInstance.hasNext()) {
            Integer aNumber = numbersInstance.next();
            Assert.assertTrue("El valor recuperado (" + aNumber + ") ya exist�a en los retornados.",
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
        RandomGenerator<String> stringsInstance = new RandomGenerator<String>(numbers);

        List<String> returnedValues = new ArrayList<String>(numbers.size());
        while (stringsInstance.hasNext()) {
            String aString = stringsInstance.next();
            Assert.assertTrue("El valor recuperado (" + aString + ") ya exist�a en los retornados.",
                                     !returnedValues.contains(aString));
            returnedValues.add(aString);
        }
    }

    /**
     * @return {@link List} de {@link Integer} con valores Dummy para usar para testing.
     *
     * @author Nahuel Barrios.
     * @since 22/03/2012.
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
     * @return {@link List} de {@link Integer} con valores Dummy para usar para testing.
     *
     * @author Nahuel Barrios.
     * @since 22/03/2012.
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
