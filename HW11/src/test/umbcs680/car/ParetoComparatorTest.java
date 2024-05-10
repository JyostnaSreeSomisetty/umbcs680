package umbcs680.car;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import umbcs680.car.Car;
import umbcs680.car.ParetoComparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParetoComparatorTest {
    @Test
    public void paretoComparatorTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 50000, 2018, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        for (Car car : cars) {
            car.setDominationCount(new ArrayList<>(cars));
        }

        Collections.sort(cars, new ParetoComparator());

        assertEquals(0, cars.get(0).getDominationCount());
        assertEquals(0, cars.get(1).getDominationCount());
        assertEquals(2, cars.get(2).getDominationCount());
    }
}
