package za.ac.cput.hospitalsystem.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalsystem.App;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.config.factory.DoctorFactory;
import za.ac.cput.hospitalsystem.domain.Doctor;

/**
 * Created by student on 2015/05/18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudDoctor  extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    DoctorRepository repository;

    @Test
    public void testCreate() throws Exception {
        Doctor doctor = DoctorFactory.createDoctor("Jarryd", "Deane", "Surgeon", null);
        repository.save(doctor);
        id = doctor.getId();
        Assert.assertNotNull(doctor.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Doctor doctor = repository.findOne(id);
        Assert.assertEquals("Jarryd", doctor.getFirstName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Doctor doctor = repository.findOne(id);
        Doctor newDoctor = new Doctor.Builder(doctor.getFirstName()).copy(doctor).id(doctor.getId()).specialization("Radiologist").build();
        repository.save(newDoctor);

        Doctor updatedDoctor = repository.findOne(id);

        Assert.assertEquals("Radiologist", updatedDoctor.getSpecialization());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Doctor doctor = repository.findOne(id);
        repository.delete(doctor);
        Doctor newDoctor = repository.findOne(id);
        Assert.assertNull(newDoctor);
    }

}
