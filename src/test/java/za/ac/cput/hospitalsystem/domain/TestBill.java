package za.ac.cput.hospitalsystem.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.hospitalsystem.config.factory.BillFactory;

/**
 * Created by student on 2015/05/13.
 */
public class TestBill {

    @Test
    public void testCreate() {
        Bill bill = BillFactory.createBill(200);
        Assert.assertEquals(200, bill.getAmount());
    }

    @Test
    public void testUpdate() {
        Bill bill = BillFactory.createBill(200);
        Bill billCopy = new Bill.Builder(bill.getAmount()).copy(bill).bill(400).build();
        Assert.assertEquals(400, billCopy.getAmount());
    }

}
