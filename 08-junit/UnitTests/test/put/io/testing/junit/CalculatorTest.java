package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "Dodawanie 2 + 3 powinno zwrócić 5");
        assertEquals(0, calculator.add(3, -3), "Dodawanie 3 + (-3) powinno zwrócić 0");
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "Mnożenie 2 * 3 powinno zwrócić 6");
        assertEquals(0, calculator.multiply(5, 0), "Mnożenie 5 * 0 powinno zwrócić 0");
    }

    @Test
    void testAddPositiveNumbers() {
        assertEquals(7, calculator.addPositiveNumbers(3, 4), "Dodawanie 3 + 4 powinno zwrócić 7");

        // Test rzucający wyjątek: x < 0, y < 0
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.addPositiveNumbers(-3, 4),
                "Metoda powinna rzucić wyjątek IllegalArgumentException, gdy x < 0 lub y > 0"
        );

        assertEquals("The arguments must be positive", exception.getMessage());
    }
}
