package za.ac.cput.hospitalsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalsystem.domain.Patient;
import za.ac.cput.hospitalsystem.repository.PatientRepository;
import za.ac.cput.hospitalsystem.services.PatientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository repository;

    @Override
    public List<Patient> getPatients() {
        List<Patient> allPatients = new ArrayList<Patient>();

        Iterable<Patient> patients = repository.findAll();
        for (Patient patient : patients) {
            allPatients.add(patient);
        }
        return allPatients;
    }

}
