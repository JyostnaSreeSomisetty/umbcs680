package umbcs680.car;

import umbcs680.car.Car;
import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getDominationCount(), car2.getDominationCount());
    }
}
