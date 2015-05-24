package za.ac.cput.hospitalsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.WardFactory;
import za.ac.cput.hospitalsystem.domain.Ward;
import za.ac.cput.hospitalsystem.repository.WardRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestWardService  extends AbstractTestNGSpringContextTests {

    @Autowired
    private WardService service;
    @Autowired
    private WardRepository repository;
    private List<Ward> wards;

    @BeforeMethod
    public void setUp() throws Exception {
        wards = new ArrayList<Ward>();
    }

    @Test
    public void create() throws Exception {
        Ward ward1 = WardFactory.createWard(20, null);
        Ward ward2 = WardFactory.createWard(20, null);

        repository.save(ward1);
        Assert.assertNotNull(ward1.getId());

        repository.save(ward2);
        Assert.assertNotNull(ward2.getId());
    }

    @Test
    public void testGetHospitals() throws Exception {
        wards = service.getWards();
        Assert.assertEquals(2, wards.size());
        repository.deleteAll();
    }

}
