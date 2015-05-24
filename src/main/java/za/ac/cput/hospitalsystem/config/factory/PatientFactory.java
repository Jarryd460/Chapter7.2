package za.ac.cput.hospitalsystem.config.factory;

import za.ac.cput.hospitalsystem.domain.Patient;
import za.ac.cput.hospitalsystem.domain.Sex;

/**
 * Created by student on 2015/05/13.
 */
public class PatientFactory {

    public static Patient createPatient(String firstName, String lastName, Sex sex, int age, String contactNumber, String address) {

        Patient patient = new Patient.Builder(firstName).lastName(lastName).sex(sex).age(age).contactNumber(contactNumber).address(address).build();
        return patient;

    }

}
