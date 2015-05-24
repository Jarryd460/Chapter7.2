package za.ac.cput.hospitalsystem.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.hospitalsystem.config.factory.ContactFactory;

/**
 * Created by student on 2015/05/13.
 */
public class TestContact {

    @Test
    public void testCreate() {
        Contact contact = ContactFactory.createContact("1234567890", "J@gmail.com", "0987654321");
        Assert.assertEquals("1234567890", contact.getTelephoneNumber());
        Assert.assertEquals("J@gmail.com", contact.getEmail());
        Assert.assertEquals("0987654321", contact.getFaxNumber());
    }

    @Test
    public void testUpdate() {
        Contact contact = ContactFactory.createContact("1234567890", "J@gmail.com", "0987654321");
        Contact contactCopy = new Contact.Builder(contact.getTelephoneNumber()).copy(contact).email("R@gmail.com").faxNumber("5432198760").build();
        Assert.assertEquals("1234567890", contactCopy.getTelephoneNumber());
        Assert.assertEquals("R@gmail.com", contactCopy.getEmail());
        Assert.assertEquals("5432198760", contactCopy.getFaxNumber());
    }

}
