package umbcs680.composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import umbcs680.composite.Department;
import umbcs680.composite.Doctor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DepartmentTest {

    @Test
    void testDepartmentDisplayInfo() {
        Department department = new Department("Cardiology");
        Doctor doctor1 = new Doctor("John Doe", "Cardiologist");
        Doctor doctor2 = new Doctor("Jane Smith", "Cardiologist");
        department.add(doctor1);
        department.add(doctor2);

        String expected = "Department: Cardiology\n" +
                "Doctor: John Doe, Specialization: Cardiologist\n" +
                "Doctor: Jane Smith, Specialization: Cardiologist";
        String actual = "";

        // Capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        department.displayInfo();

        System.setOut(originalOut);
        actual = outputStream.toString().trim();

        assertEquals(expected, actual);
    }

    @Test
    void testDepartmentAddAndRemove() {
        Department department = new Department("Orthopedics");
        Doctor doctor = new Doctor("Anna James", "Orthopedic Surgeon");
        department.add(doctor);
        assertTrue(department.components.contains(doctor));

        department.remove(doctor);
        assertFalse(department.components.contains(doctor));
    }

    @Test
    void testDepartmentName() {
        Department department = new Department("Neurology");
        assertEquals("Neurology", department.name);
    }

}