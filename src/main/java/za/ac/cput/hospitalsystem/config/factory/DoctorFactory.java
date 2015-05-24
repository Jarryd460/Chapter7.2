package za.ac.cput.hospitalsystem.config.factory;

import za.ac.cput.hospitalsystem.domain.Appointment;
import za.ac.cput.hospitalsystem.domain.Doctor;

import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
public class DoctorFactory {

    public static Doctor createDoctor(String firstName, String lastName, String specialization, List<Appointment> appointmentList) {

        Doctor doctor = new Doctor.Builder(firstName).lastName(lastName).specialization(specialization).appointments(appointmentList).build();
        return doctor;

    }

}
