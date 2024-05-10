package umbcs680.car;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import umbcs680.car.Car;
import umbcs680.car.MileageComparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MileageComparatorTest {

    @Test
    public void testSortByMileage() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 50000, 2018, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        Collections.sort(cars, new MileageComparator());

        assertEquals(30000, cars.get(0).getMileage());
        assertEquals(40000, cars.get(1).getMileage());
        assertEquals(50000, cars.get(2).getMileage());
    }
}
