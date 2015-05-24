package za.ac.cput.hospitalsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.hospitalsystem.domain.Ward;
import za.ac.cput.hospitalsystem.model.WardResource;
import za.ac.cput.hospitalsystem.services.WardService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping(value = "/ward/**")
public class WardPage {

    @Autowired
    private WardService service;

    @RequestMapping(value="/wards", method= RequestMethod.GET)

    public List<WardResource> getWards() {
        List<WardResource> hateos = new ArrayList<WardResource>();
        List<Ward> wards = service.getWards();
        for (Ward ward : wards) {
            WardResource res = new WardResource
                    .Builder(ward.getCapacity())
                    .patients(ward.getPatients())
                    .build();
            Link wardsLink = new
                    Link("http://localhost:8080/ward/"+res.getResId().toString())
                    .withRel("wards");
            res.add(wardsLink);
            hateos.add(res);
        }
        return hateos;
    }

}
