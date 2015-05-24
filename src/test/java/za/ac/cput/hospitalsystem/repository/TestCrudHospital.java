package za.ac.cput.hospitalsystem.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.*;
import za.ac.cput.hospitalsystem.domain.*;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/05/14.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudHospital extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    HospitalRepository repository;

    @Test
    public void testCreate() throws Exception {
        Address address = AddressFactory.createAddress("Street1", "Cape Town", "3254");
        Contact contact = ContactFactory.createContact("1234567890", "J@gmail.com", "0987654321");
        Hospital hospital = HospitalFactory.createHospital("hospital1", address, contact, null, null);
        repository.save(hospital);
        id = hospital.getId();
        Assert.assertNotNull(hospital.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Hospital hospital = repository.findOne(id);
        Assert.assertEquals("hospital1", hospital.getName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Hospital hospital = repository.findOne(id);
        Address address = AddressFactory.createAddress("Street2", "Durban", "1234");
        Hospital newHospital = new Hospital.Builder(hospital.getName()).copy(hospital).id(hospital.getId()).address(address).build();
        repository.save(newHospital);

        Hospital updatedHospital = repository.findOne(id);

        Assert.assertEquals("Street2", updatedHospital.getAddress().getAddress());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Hospital hospital = repository.findOne(id);
        repository.delete(hospital);
        Hospital newHospital = repository.findOne(id);
        Assert.assertNull(newHospital);
    }

}
