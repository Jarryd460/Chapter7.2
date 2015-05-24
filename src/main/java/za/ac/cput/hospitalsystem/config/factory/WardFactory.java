package za.ac.cput.hospitalsystem.config.factory;

import za.ac.cput.hospitalsystem.domain.Patient;
import za.ac.cput.hospitalsystem.domain.Ward;

import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
public class WardFactory {

    public static Ward createWard(int capacity, List<Patient> patientList) {

        Ward ward = new Ward.Builder(capacity).patients(patientList).build();
        return ward;

    }

}
