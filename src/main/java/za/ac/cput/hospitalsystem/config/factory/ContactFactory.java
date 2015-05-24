package za.ac.cput.hospitalsystem.config.factory;

import za.ac.cput.hospitalsystem.domain.Contact;

/**
 * Created by student on 2015/05/13.
 */
public class ContactFactory {

    public static Contact createContact(String telephoneNumber, String email, String faxNumber) {

        Contact contact = new Contact.Builder(telephoneNumber).email(email).faxNumber(faxNumber).build();
        return contact;

    }

}
