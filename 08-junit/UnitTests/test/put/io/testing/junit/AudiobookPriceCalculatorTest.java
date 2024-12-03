package put.io.testing.junit;

import org.junit.jupiter.api.Test;
import put.io.testing.audiobooks.Audiobook;
import put.io.testing.audiobooks.AudiobookPriceCalculator;
import put.io.testing.audiobooks.Customer;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    private AudiobookPriceCalculator calculator = new AudiobookPriceCalculator();

    @Test
    void testCalculateSubscriber() {
        Customer subscriber = new Customer("John Doe", Customer.LoyaltyLevel.STANDARD, true);
        Audiobook audiobook = new Audiobook("Test Audiobook", 50.0);

        assertEquals(0.0, calculator.calculate(subscriber, audiobook),
                "Subskrybenci powinni otrzymać audiobooki za darmo");
    }

    @Test
    void testCalculateSilverLoyaltyLevel() {
        Customer silverCustomer = new Customer("Jane Doe", Customer.LoyaltyLevel.SILVER, false);
        Audiobook audiobook = new Audiobook("Test Audiobook", 50.0);

        assertEquals(45.0, calculator.calculate(silverCustomer, audiobook),
                "Klienci SILVER powinni otrzymać 10% zniżki");
    }

    @Test
    void testCalculateGoldLoyaltyLevel() {
        Customer goldCustomer = new Customer("Alice Doe", Customer.LoyaltyLevel.GOLD, false);
        Audiobook audiobook = new Audiobook("Test Audiobook", 50.0);

        assertEquals(40.0, calculator.calculate(goldCustomer, audiobook),
                "Klienci GOLD powinni otrzymać 20% zniżki");
    }

    @Test
    void testCalculateRegularCustomer() {
        Customer regularCustomer = new Customer("Bob Doe", Customer.LoyaltyLevel.STANDARD, false);
        Audiobook audiobook = new Audiobook("Test Audiobook", 50.0);

        assertEquals(50.0, calculator.calculate(regularCustomer, audiobook),
                "Zwykli klienci powinni płacić pełną cenę");
    }
}
