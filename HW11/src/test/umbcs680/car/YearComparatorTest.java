package umbcs680.car;

import org.junit.jupiter.api.Test;
import umbcs680.car.Car;
import umbcs680.car.YearComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YearComparatorTest {

    @Test
    public void testYearComparator() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 50000, 2018, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        Collections.sort(cars, new YearComparator());

        assertEquals(2020, cars.get(0).getYear());
        assertEquals(2019, cars.get(1).getYear());
        assertEquals(2018, cars.get(2).getYear());
    }
}

