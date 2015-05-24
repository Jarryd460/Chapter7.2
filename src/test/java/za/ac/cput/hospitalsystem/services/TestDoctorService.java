package za.ac.cput.hospitalsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.DoctorFactory;
import za.ac.cput.hospitalsystem.domain.Doctor;
import za.ac.cput.hospitalsystem.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestDoctorService extends AbstractTestNGSpringContextTests {

    @Autowired
    private DoctorService service;
    @Autowired
    private DoctorRepository repository;
    private List<Doctor> doctors;

    @BeforeMethod
    public void setUp() throws Exception {
        doctors = new ArrayList<Doctor>();
    }

    @Test
    public void create() throws Exception {
        Doctor doctor1 = DoctorFactory.createDoctor("Jarryd", "Deane", "Surgeon", null);
        Doctor doctor2 = DoctorFactory.createDoctor("Bill", "Roanld", "Radiologist", null);

        repository.save(doctor1);
        Assert.assertNotNull(doctor1.getId());

        repository.save(doctor2);
        Assert.assertNotNull(doctor2.getId());
    }

    @Test
    public void testGetHospitals() throws Exception {
        doctors = service.getDoctors();
        Assert.assertEquals(2, doctors.size());
        repository.deleteAll();
    }

}
