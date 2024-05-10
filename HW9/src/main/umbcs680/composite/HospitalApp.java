package umbcs680.composite;

import umbcs680.composite.Department;
import umbcs680.composite.Doctor;

public class HospitalApp {
    public static void main(String[] args) {
        Department cardiology = new Department("Cardiology");
        Department orthopedics = new Department("Orthopedics");

        Doctor doctor1 = new Doctor("John Doe", "Cardiologist");
        Doctor doctor2 = new Doctor("Jane Smith", "Orthopedic Surgeon");
        Doctor doctor3 = new Doctor("Anna James", "Cardiologist");

        cardiology.add(doctor1);
        cardiology.add(doctor3);
        orthopedics.add(doctor2);

        Department hospital = new Department("General Hospital");
        hospital.add(cardiology);
        hospital.add(orthopedics);

        hospital.displayInfo();
    }
}