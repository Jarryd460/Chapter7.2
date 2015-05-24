package za.ac.cput.hospitalsystem.config.factory;

import za.ac.cput.hospitalsystem.domain.Address;

/**
 * Created by student on 2015/05/13.
 */
public class AddressFactory {

    public static Address createAddress(String address, String city, String zipCode) {

        Address address1 = new Address.Builder(address).city(city).zipCode(zipCode).build();
        return address1;

    }

}
