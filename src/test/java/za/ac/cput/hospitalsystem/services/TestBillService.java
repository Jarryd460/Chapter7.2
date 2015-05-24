package za.ac.cput.hospitalsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.BillFactory;
import za.ac.cput.hospitalsystem.domain.Bill;
import za.ac.cput.hospitalsystem.repository.BillRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestBillService extends AbstractTestNGSpringContextTests {

    @Autowired
    private BillService service;
    @Autowired
    private BillRepository repository;
    private List<Bill> bills;

    @BeforeMethod
    public void setUp() throws Exception {
        bills = new ArrayList<Bill>();
    }

    @Test
    public void create() throws Exception {
        Bill bill1 = BillFactory.createBill(2000);
        Bill bill2 = BillFactory.createBill(1000);

        repository.save(bill1);
        Assert.assertNotNull(bill1.getId());

        repository.save(bill2);
        Assert.assertNotNull(bill2.getId());
    }

    @Test
    public void testGetHospitals() throws Exception {
        bills = service.getBills();
        Assert.assertEquals(2, bills.size());
        repository.deleteAll();
    }

}
