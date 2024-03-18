package umbcs680.Car;

public class Car {
    // Define private fields for car properties
    public String make;
    public String model;
    public int mileage;
    public int year;
    public float price;


    // Getter methods for each car property
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

    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
    public static void main(String[] args) {
    }
}
