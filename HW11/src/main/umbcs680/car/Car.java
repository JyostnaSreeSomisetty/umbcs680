package umbcs680.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import umbcs680.car.ParetoComparator;

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

    }
}



