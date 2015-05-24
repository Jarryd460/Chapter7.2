package za.ac.cput.hospitalsystem.config.factory;

import za.ac.cput.hospitalsystem.domain.*;

import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
public class HospitalFactory {

    public static Hospital createHospital(String name, Address address, Contact contact, List<Ward> wardList, List<Doctor> doctorList) {

        Hospital hospital = new Hospital.Builder(name).address(address).contact(contact).wards(wardList).doctors(doctorList).build();
        return hospital;

    }

}
