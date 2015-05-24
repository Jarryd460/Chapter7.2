package za.ac.cput.hospitalsystem.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalsystem.App;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.config.factory.PatientFactory;
import za.ac.cput.hospitalsystem.domain.Patient;
import za.ac.cput.hospitalsystem.domain.Sex;

/**
 * Created by student on 2015/05/18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudPatient  extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    PatientRepository repository;

    @Test
    public void testCreate() throws Exception {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street1");
        repository.save(patient);
        id = patient.getId();
        Assert.assertNotNull(patient.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Patient patient = repository.findOne(id);
        Assert.assertEquals("Jarryd", patient.getFirstName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Patient patient = repository.findOne(id);
        Patient newPatient = new Patient.Builder(patient.getFirstName()).copy(patient).id(patient.getId()).contactNumber("0987654321").build();
        repository.save(newPatient);

        Patient updatedPatient = repository.findOne(id);

        Assert.assertEquals("0987654321", updatedPatient.getContactNumber());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Patient patient = repository.findOne(id);
        repository.delete(patient);
        Patient newPatient = repository.findOne(id);
        Assert.assertNull(newPatient);
    }

}
