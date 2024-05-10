package umbcs680.composite;

import java.util.ArrayList;
import java.util.List;

abstract class HospitalComponent {
    protected String name;

    public HospitalComponent(String name) {
        this.name = name;
    }

    public abstract void add(HospitalComponent component);
    public abstract void remove(HospitalComponent component);
    public abstract void displayInfo();
}