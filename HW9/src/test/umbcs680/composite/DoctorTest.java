package umbcs680.composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import umbcs680.composite.Department;
import umbcs680.composite.Doctor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DoctorTest {

    @Test
    void testDoctorDisplayInfo() {
        Doctor doctor = new Doctor("John Doe", "Cardiologist");
        String expected = "Doctor: John Doe, Specialization: Cardiologist";
        String actual = "";

        // Capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        doctor.displayInfo();

        System.setOut(originalOut);
        actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }

    @Test
    void testDoctorNameAndSpecialization() {
        Doctor doctor = new Doctor("Anna James", "Cardiologist");
        assertEquals("Anna James", doctor.name);
        assertEquals("Cardiologist", doctor.specialization);
    }
}