package umbcs680.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import umbcs680.singleton.SingletonPrimeGenerator;
class SingletonPrimeGeneratorTest {

    @Test
    public void testForNonNullGetInstance() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(2, 20);
        assertNotNull(gen);
    }

    @Test
    public void testForIdenticalInstanceGetInstance() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(2, 20);
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(2, 20);
        assertSame(gen, gen1);
    }

    @Test
    public void primesFrom2To20() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(2, 20);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }

    @Test
    public void testGeneratePrimesInvalidInput()
    {try {
        SingletonPrimeGenerator gen = new SingletonPrimeGenerator(-11, 50); // "from" is negative
        gen.generatePrimes();
        fail("From value is negative");
    } catch (RuntimeException e) {
        assertEquals("Wrong input values: from=-11 to=50", e.getMessage());
    }
    }
}
