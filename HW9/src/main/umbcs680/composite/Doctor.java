package umbcs680.composite;

import umbcs680.composite.HospitalComponent;

class Doctor extends HospitalComponent {
    public String specialization;

    public Doctor(String name, String specialization) {
        super(name);
        this.specialization = specialization;
    }

    @Override
    public void add(HospitalComponent component) {

    }

    @Override
    public void remove(HospitalComponent component) {

    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor: " + name + ", Specialization: " + specialization);
    }
}