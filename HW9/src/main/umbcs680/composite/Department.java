package umbcs680.composite;

import java.util.ArrayList;
import java.util.List;
import umbcs680.composite.HospitalComponent;

class Department extends HospitalComponent {
    public List<HospitalComponent> components = new ArrayList<>();

  public Department(String name) {
        super(name);
    }

    @Override
    public void add(HospitalComponent component) {
        components.add(component);
    }

    @Override
    public void remove(HospitalComponent component) {
        components.remove(component);
    }

    @Override
    public void displayInfo() {
        System.out.println("Department: " + name);
        for (HospitalComponent component : components) {
            component.displayInfo();
        }
    }
}
