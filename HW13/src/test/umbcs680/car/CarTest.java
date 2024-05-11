package umbcs680.car;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import umbcs680.car.Car;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void testSortByPriceAscending() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "TTS", 50000, 2023, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice));

        assertEquals(18000, cars.get(0).getPrice());
        assertEquals(20000, cars.get(1).getPrice());
        assertEquals(25000, cars.get(2).getPrice());
    }

    @Test
    public void testSortByYearDescending() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "TTS", 50000, 2023, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        Collections.sort(cars, Comparator.comparingInt(Car::getYear).reversed());

        assertEquals(2023, cars.get(0).getYear());
        assertEquals(2020, cars.get(1).getYear());
        assertEquals(2019, cars.get(2).getYear());
    }

    @Test
    public void testSortByMileageAscending() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "TTS", 50000, 2023, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        Collections.sort(cars, Comparator.comparingInt(Car::getMileage));

        assertEquals(30000, cars.get(0).getMileage());
        assertEquals(40000, cars.get(1).getMileage());
        assertEquals(50000, cars.get(2).getMileage());
    }

    @Test
    public void testSortByParetoComparisonAscending() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "TTS", 50000, 2023, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        for (Car car : cars) {
            car.setDominationCount(cars);
        }

        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount));

        assertEquals(0, cars.get(0).getDominationCount());
        assertEquals(0, cars.get(1).getDominationCount());
        assertEquals(1, cars.get(2).getDominationCount());
    }
}

