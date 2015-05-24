package za.ac.cput.hospitalsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalsystem.domain.Hospital;
import za.ac.cput.hospitalsystem.repository.HospitalRepository;
import za.ac.cput.hospitalsystem.services.HospitalService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class HospitalServiceImpl implements HospitalService{

    @Autowired
    HospitalRepository repository;

    @Override
    public List<Hospital> getHospitals() {
        List<Hospital> allHospitals = new ArrayList<Hospital>();

        Iterable<Hospital> hospitals = repository.findAll();
        for (Hospital hospital : hospitals) {
            allHospitals.add(hospital);
        }
        return allHospitals;
    }
}
