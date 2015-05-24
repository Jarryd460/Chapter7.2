package za.ac.cput.hospitalsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.hospitalsystem.domain.Patient;
import za.ac.cput.hospitalsystem.model.PatientResource;
import za.ac.cput.hospitalsystem.services.PatientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping(value = "/patient/**")
public class PatientPage {

    @Autowired
    private PatientService service;

    @RequestMapping(value="/patients", method= RequestMethod.GET)

    public List<PatientResource> getPatients() {
        List<PatientResource> hateos = new ArrayList<PatientResource>();
        List<Patient> patients = service.getPatients();
        for (Patient patient : patients) {
            PatientResource res = new PatientResource
                    .Builder(patient.getFirstName())
                    .lastName(patient.getLastName())
                    .sex(patient.getSex())
                    .age(patient.getAge())
                    .contactNumber(patient.getContactNumber())
                    .address(patient.getAddress())
                    .build();
            Link patientsLink = new
                    Link("http://localhost:8080/patient/"+res.getResId().toString())
                    .withRel("patients");
            res.add(patientsLink);
            hateos.add(res);
        }
        return hateos;
    }

}
