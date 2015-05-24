package za.ac.cput.hospitalsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.hospitalsystem.domain.Doctor;
import za.ac.cput.hospitalsystem.model.DoctorResource;
import za.ac.cput.hospitalsystem.services.DoctorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping(value = "/doctor/**")
public class DoctorPage {

    @Autowired
    private DoctorService service;

    @RequestMapping(value="/doctors", method= RequestMethod.GET)

    public List<DoctorResource> getDoctors() {
        List<DoctorResource> hateos = new ArrayList<DoctorResource>();
        List<Doctor> doctors = service.getDoctors();
        for (Doctor doctor : doctors) {
            DoctorResource res = new DoctorResource
                    .Builder(doctor.getFirstName())
                    .lastName(doctor.getLastName())
                    .specialization(doctor.getSpecialization())
                    .appointments(doctor.getAppointments())
                    .build();
            Link doctorsLink = new
                    Link("http://localhost:8080/doctor/"+res.getResId().toString())
                    .withRel("doctors");
            res.add(doctorsLink);
            hateos.add(res);
        }
        return hateos;
    }

}
