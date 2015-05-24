package za.ac.cput.hospitalsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalsystem.domain.Appointment;
import za.ac.cput.hospitalsystem.repository.AppointmentRepository;
import za.ac.cput.hospitalsystem.services.AppointmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository repository;

    @Override
    public List<Appointment> getAppointments() {
        List<Appointment> allAppointments = new ArrayList<Appointment>();

        Iterable<Appointment> appointments = repository.findAll();
        for (Appointment appointment : appointments) {
            allAppointments.add(appointment);
        }
        return allAppointments;
    }


}
