package za.ac.cput.hospitalsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.hospitalsystem.domain.Hospital;
import za.ac.cput.hospitalsystem.model.HospitalResource;
import za.ac.cput.hospitalsystem.services.HospitalService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping(value = "/hospital/**")
public class HospitalPage {

    @Autowired
    private HospitalService service;

    @RequestMapping(value="/hospitals", method= RequestMethod.GET)

    public List<HospitalResource> getHospitals() {
        List<HospitalResource> hateos = new ArrayList<HospitalResource>();
        List<Hospital> hospitals = service.getHospitals();
        for (Hospital hospital : hospitals) {
            HospitalResource res = new HospitalResource
                    .Builder(hospital.getName())
                    .address(hospital.getAddress())
                    .contact(hospital.getContact())
                    .wards(hospital.getWards())
                    .doctors(hospital.getDoctors())
                    .build();
            Link hospitalsLink = new
                    Link("http://localhost:8080/hospital/"+res.getResId().toString())
                    .withRel("hospitals");
            res.add(hospitalsLink);
            hateos.add(res);
        }
        return hateos;
    }

}
