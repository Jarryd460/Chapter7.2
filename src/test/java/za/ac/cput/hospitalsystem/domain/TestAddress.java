package za.ac.cput.hospitalsystem.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.hospitalsystem.config.factory.AddressFactory;

/**
 * Created by student on 2015/05/13.
 */
public class TestAddress {

    @Test
    public void testCreate() {
        Address address = AddressFactory.createAddress("Street1", "Joburg", "1234");
        Assert.assertEquals("Street1", address.getAddress());
        Assert.assertEquals("Joburg", address.getCity());
        Assert.assertEquals("1234", address.getZipCode());
    }

    @Test
    public void testUpdate() {
        Address address = AddressFactory.createAddress("Street1", "Joburg", "1234");
        Address addressCopy = new Address.Builder(address.getAddress()).copy(address).city("Cape Town").zipCode("4321").build();
        Assert.assertEquals("Street1", addressCopy.getAddress());
        Assert.assertEquals("Cape Town", addressCopy.getCity());
        Assert.assertEquals("4321", addressCopy.getZipCode());

    }

}
