package za.ac.cput.hospitalsystem.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.hospitalsystem.config.factory.PatientFactory;
import za.ac.cput.hospitalsystem.config.factory.WardFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
public class TestWard {

    @Test
    public void testCreate() {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street2");
        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient);
        Ward ward = WardFactory.createWard(20, patientList);
        Assert.assertEquals(20, ward.getCapacity());
        Assert.assertEquals("Jarryd", ward.getPatients().get(0).getFirstName());
        Assert.assertEquals("1234567890", ward.getPatients().get(0).getContactNumber());
    }

    @Test
    public void testUpdate() {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street2");
        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient);
        Ward ward = WardFactory.createWard(20, patientList);
        Patient patient1 = PatientFactory.createPatient("Ronald", "Macdonald", Sex.Male, 40, "0987654321", "Street1");
        List<Patient> patientList1 = new ArrayList<Patient>();
        patientList1.add(patient1);
        Ward wardCopy = new Ward.Builder(ward.getCapacity()).copy(ward).patients(patientList1).build();
        Assert.assertEquals(20, wardCopy.getCapacity());
        Assert.assertEquals("Ronald", wardCopy.getPatients().get(0).getFirstName());
        Assert.assertEquals("0987654321", wardCopy.getPatients().get(0).getContactNumber());
    }

}
