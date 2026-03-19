package com.demo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        assertEquals(5, c.add(2, 3));
    }

    @Test
    public void testSubtract() {
        Calculator c = new Calculator();
        assertEquals(2, c.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        Calculator c = new Calculator();
        assertEquals(15, c.multiply(3, 5));
    }

    @Test
    public void testDivide() {
        Calculator c = new Calculator();
        assertEquals(2, c.divide(6, 3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator c = new Calculator();
        c.divide(5, 0); // should throw exception
    }
}