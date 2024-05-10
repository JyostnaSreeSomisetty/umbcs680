package umbcs680.car;

import org.junit.jupiter.api.Test;

import umbcs680.car.Car;

import static org.junit.jupiter.api.Assertions.*;
public class CarTest {

    private String[] carToStringArray(Car car) {
        return new String[] {car.getMake(),
                car.getModel(),
                String.valueOf(car.getMileage()),
                String.valueOf(car.getYear()),
                String.valueOf(car.getPrice())};
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = new String[]{"Audi", "TTS", "23", "2023", "61000.0"};
        Car actual = new Car("Audi", "TTS", 23, 2023, 61000);
        assertArrayEquals(expected, carToStringArray(actual));
    }

    @Test
    public void testTwoDifferentCarInstances(){
        Car actual = new Car("Audi", "TTS", 23, 2023, 61000);
        Car expected = new Car("Audi", "TTS", 23, 2023, 61000);
        assertNotSame(expected, (actual));
    }

}