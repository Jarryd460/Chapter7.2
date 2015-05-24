package za.ac.cput.hospitalsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.hospitalsystem.domain.Address;
import za.ac.cput.hospitalsystem.domain.Contact;
import za.ac.cput.hospitalsystem.domain.Hospital;
import za.ac.cput.hospitalsystem.services.HospitalService;

import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {

    @Autowired
    private HospitalService service;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String index()
    {
        return "This is a Home Page";
    }

    @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public Hospital getHospital()
    {
        Address address = new Address.Builder("Street1").city("Cape Town").zipCode("1234").build();
        Contact contact = new Contact.Builder("1234567890").email("email@gmail.com").faxNumber("0987654321").build();
        Hospital hospital = new Hospital.Builder("hospital1").address(address).contact(contact).wards(null).doctors(null).build();

        return hospital;
    }

    @RequestMapping(value = "/hospitals", method = RequestMethod.GET)
    public List<Hospital> getHospitals()
    {
        return service.getHospitals();
    }

}


