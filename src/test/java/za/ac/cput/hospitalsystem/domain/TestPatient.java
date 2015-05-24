package za.ac.cput.hospitalsystem.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.hospitalsystem.config.factory.PatientFactory;

/**
 * Created by student on 2015/05/13.
 */
public class TestPatient {

    @Test
    public void testCreate() {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street2");
        Assert.assertEquals("Jarryd", patient.getFirstName());
        Assert.assertEquals("Deane", patient.getLastName());
        Assert.assertEquals("Street2", patient.getAddress());
    }

    @Test
    public void testUpdate() {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street2");
        Patient patientCopy = new Patient.Builder(patient.getFirstName()).copy(patient).age(24).contactNumber("0987654321").build();
        Assert.assertEquals("Jarryd", patientCopy.getFirstName());
        Assert.assertEquals(24, patientCopy.getAge());
        Assert.assertEquals("0987654321", patientCopy.getContactNumber());
    }

}
