package za.ac.cput.hospitalsystem.config.factory;

import za.ac.cput.hospitalsystem.domain.Appointment;
import za.ac.cput.hospitalsystem.domain.Bill;
import za.ac.cput.hospitalsystem.domain.Patient;

import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
public class AppointmentFactory {

    public static Appointment createAppointment(Patient patient, int amount, List<Bill> bill) {

        Appointment appointment = new Appointment.Builder(patient).amount(amount).bill(bill).build();
        return appointment;

    }

}
