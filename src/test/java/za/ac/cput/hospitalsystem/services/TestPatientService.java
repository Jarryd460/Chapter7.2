package za.ac.cput.hospitalsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.PatientFactory;
import za.ac.cput.hospitalsystem.domain.Patient;
import za.ac.cput.hospitalsystem.domain.Sex;
import za.ac.cput.hospitalsystem.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestPatientService extends AbstractTestNGSpringContextTests {

    @Autowired
    private PatientService service;
    @Autowired
    private PatientRepository repository;
    private List<Patient> patients;

    @BeforeMethod
    public void setUp() throws Exception {
        patients = new ArrayList<Patient>();
    }

    @Test
    public void create() throws Exception {
        Patient patient1 = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street1");
        Patient patient2 = PatientFactory.createPatient("Frank", "Jones", Sex.Male, 40, "0987654321", "Street2");

        repository.save(patient1);
        Assert.assertNotNull(patient1.getId());

        repository.save(patient2);
        Assert.assertNotNull(patient2.getId());
    }

    @Test
    public void testGetHospitals() throws Exception {
        patients = service.getPatients();
        Assert.assertEquals(2, patients.size());
        repository.deleteAll();
    }

}
