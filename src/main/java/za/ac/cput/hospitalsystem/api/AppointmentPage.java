package za.ac.cput.hospitalsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.hospitalsystem.domain.Appointment;
import za.ac.cput.hospitalsystem.model.AppointmentResource;
import za.ac.cput.hospitalsystem.services.AppointmentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping(value = "/appointment/**")
public class AppointmentPage {

    @Autowired
    private AppointmentService service;

    @RequestMapping(value="/appointments", method= RequestMethod.GET)
    public List<AppointmentResource> getAppointments() {
        List<AppointmentResource> hateos = new ArrayList<AppointmentResource>();
        List<Appointment> appointments = service.getAppointments();
        for (Appointment appointment : appointments) {
            AppointmentResource res = new AppointmentResource
                    .Builder(appointment.getPatient())
                    .amount(appointment.getAmount())
                    .bill(appointment.getBill())
                    .build();
            Link appointmentsLink = new
                    Link("http://localhost:8080/appointment/"+res.getResId().toString())
                    .withRel("appointments");
            res.add(appointmentsLink);
            hateos.add(res);
        }
        return hateos;
    }

}
