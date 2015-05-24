package za.ac.cput.hospitalsystem.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hospitalsystem.App;
import za.ac.cput.hospitalsystem.config.factory.BillFactory;
import za.ac.cput.hospitalsystem.domain.Bill;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/05/18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBill  extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    BillRepository repository;

    @Test
    public void testCreate() throws Exception {
        Bill bill = BillFactory.createBill(2000);
        repository.save(bill);
        id = bill.getId();
        Assert.assertNotNull(bill.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Bill bill = repository.findOne(id);
        Assert.assertEquals(2000, bill.getAmount());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Bill bill = repository.findOne(id);
        Bill newBill = new Bill.Builder(bill.getAmount()).copy(bill).id(bill.getId()).bill(1000).build();
        repository.save(newBill);

        Bill updatedBill = repository.findOne(id);

        Assert.assertEquals(1000, updatedBill.getAmount());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Bill bill = repository.findOne(id);
        repository.delete(bill);
        Bill newBill = repository.findOne(id);
        Assert.assertNull(newBill);
    }

}
