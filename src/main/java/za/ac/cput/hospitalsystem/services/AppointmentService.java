package za.ac.cput.hospitalsystem.services;

import za.ac.cput.hospitalsystem.domain.Appointment;

import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
public interface AppointmentService {

    List<Appointment> getAppointments();

}
