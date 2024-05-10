package umbcs680.composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import umbcs680.composite.Department;
import umbcs680.composite.Doctor;
import umbcs680.composite.HospitalApp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HospitalAppTest {

    @Test
    public void testDisplayInfo() {
        HospitalApp.main(null);
        assertTrue(true); // If no exception is thrown, test passes
    }

    @Test
    void testDepartmentName() {
        Department cardiology = new Department("cardiology");
        assertNotEquals("Neurology", cardiology.name);
    }

    @Test
    void testDoctorNameAndSpecialization() {
        Doctor doctor = new Doctor("Jane Smith", "Orthopedic Surgeon");
        assertEquals("Jane Smith", doctor.name);
        assertNotEquals("Cardiologist", doctor.specialization);
    }
}