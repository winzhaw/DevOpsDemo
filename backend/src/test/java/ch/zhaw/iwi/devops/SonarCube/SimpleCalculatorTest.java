package ch.zhaw.iwi.devops.SonarCube;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ch.zhaw.iwi.devops.SonarCubeTesting.SimpleCalculator;

public class SimpleCalculatorTest {

    @Test
    public void testAdd() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    public void testMultiply() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(6, calculator.multiply(2, 3));
    }

    // Neue Tests für die divide-Methode
    @Test
    public void testDivide() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    public void testDivideByZero() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });
    }
}
