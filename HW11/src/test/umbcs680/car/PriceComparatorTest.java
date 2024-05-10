package umbcs680.car;

import org.junit.jupiter.api.Test;
import umbcs680.car.Car;
import umbcs680.car.PriceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceComparatorTest {

    @Test
    public void testPriceComparator() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 50000, 2018, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        Collections.sort(cars, new PriceComparator());

        assertEquals(18000, cars.get(0).getPrice());
        assertEquals(20000, cars.get(1).getPrice());
        assertEquals(25000, cars.get(2).getPrice());
    }

}