package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {

    @Test
    void test1() {
        assertEquals(1, 2, "Test zawsze będzie fałszywy");
    }

    @Test
    void test2() {
        throw new NullPointerException("Nieoczekiwany wyjątek");
    }

    @Test
    void test3() {
        try {
            assertEquals(1, 2, "Ta asercja zawsze zawiedzie");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("Typ przechwyconego obiektu: " + throwable.getClass().getName());
        }
    }
}
