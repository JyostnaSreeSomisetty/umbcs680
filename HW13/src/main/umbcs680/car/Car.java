package umbcs680.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    public String make;
    public String model;
    public int mileage;
    public int year;
    public float price;
    private int dominationCount;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public void setDominationCount(ArrayList<Car> cars) {
        int count = 0;
        for (Car car : cars) {
            if (isDominated(car)) {
                count++;
            }
        }
        this.dominationCount = count;
    }

    private boolean isDominated(Car other) {
        if (this.price <= other.price && this.mileage <= other.mileage && this.year >= other.year) {
            if (this.price < other.price || this.mileage < other.mileage || this.year > other.year) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", "TTS", 50000, 2023, 20000));
        cars.add(new Car("Honda", "Civic", 30000, 2020, 18000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 25000));

        // Sort by price (ascending)
        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice));
        System.out.println("Sorted by Price (Ascending):");
        cars.forEach(car -> System.out.println(car.getMake() + " " + car.getModel() + ", Price: $" + car.getPrice()));

        // Sort by year (descending)
        Collections.sort(cars, Comparator.comparingInt(Car::getYear).reversed());
        System.out.println("\nSorted by Year (Descending):");
        cars.forEach(car -> System.out.println(car.getMake() + " " + car.getModel() + ", Year: " + car.getYear()));

        // Sort by mileage (ascending)
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage));
        System.out.println("\nSorted by Mileage (Ascending):");
        cars.forEach(car -> System.out.println(car.getMake() + " " + car.getModel() + ", Mileage: " + car.getMileage()));

        // Sort by Pareto comparison (ascending)
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount));
        System.out.println("\nSorted by Pareto Comparison (Ascending):");
        cars.forEach(car -> System.out.println(car.getMake() + " " + car.getModel() + ", Domination Count: " + car.getDominationCount()));
    }
}
