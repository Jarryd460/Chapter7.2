package za.ac.cput.hospitalsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.AddressFactory;
import za.ac.cput.hospitalsystem.config.factory.ContactFactory;
import za.ac.cput.hospitalsystem.config.factory.HospitalFactory;
import za.ac.cput.hospitalsystem.domain.Address;
import za.ac.cput.hospitalsystem.domain.Contact;
import za.ac.cput.hospitalsystem.domain.Hospital;
import za.ac.cput.hospitalsystem.repository.HospitalRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestHospitalService extends AbstractTestNGSpringContextTests {

    @Autowired
    private HospitalService service;
    @Autowired
    private HospitalRepository repository;
    private List<Hospital> hospitals;

    @BeforeMethod
    public void setUp() throws Exception {
        hospitals = new ArrayList<Hospital>();
    }

    @Test
    public void create() throws Exception {
        Address address1 = AddressFactory.createAddress("Street1", "Cape Town", "3254");
        Contact contact1 = ContactFactory.createContact("1234567890", "J@gmail.com", "0987654321");
        Hospital hospital1 = HospitalFactory.createHospital("hospital1", address1, contact1, null, null);

        Address address2 = AddressFactory.createAddress("Street1", "Cape Town", "3254");
        Contact contact2 = ContactFactory.createContact("1234567890", "J@gmail.com", "0987654321");
        Hospital hospital2 = HospitalFactory.createHospital("hospital1", address2, contact2, null, null);

        repository.save(hospital1);
        Assert.assertNotNull(hospital1.getId());

        repository.save(hospital2);
        Assert.assertNotNull(hospital2.getId());
    }

    @Test
    public void testGetHospitals() throws Exception {
        hospitals = service.getHospitals();
        Assert.assertEquals(2, hospitals.size());
        repository.deleteAll();
    }

}
