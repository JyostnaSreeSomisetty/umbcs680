package umbcs680.prime;

import umbcs680.prime.PrimeGenerator;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    public void primesFrom2To12() {
        PrimeGenerator gen = new PrimeGenerator(2, 12);
        gen.generatePrimes();
        try {
            Long[] expectedPrimeNumbers = {2L, 3L, 5L, 7L, 11L};
            assertArrayEquals(expectedPrimeNumbers, gen.getPrimes().toArray());
        } catch (AssertionError e) {
            fail("Failed");
        }
    }

    @Test
    public void primesFrom20To70() {
        PrimeGenerator gen = new PrimeGenerator(21, 60);
        gen.generatePrimes();
        try {
            Long[] expectedPrimeNumbers = {23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L};
            assertArrayEquals(expectedPrimeNumbers, gen.getPrimes().toArray());
        } catch (AssertionError e) {
            fail("Failed");
        }
    }

    @Test
    public void testGeneratePrimesInvalidInput() {
        try {
            PrimeGenerator gen = new PrimeGenerator(100, 10); // "from" greater than "to"
            gen.generatePrimes();
            fail("From value is greater than to");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=100 to=10", e.getMessage());
        }

        try {
            PrimeGenerator gen = new PrimeGenerator(-11, 50); // "from" is negative
            gen.generatePrimes();
            fail("From value is negative");
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=-11 to=50", e.getMessage());
        }
    }
}
