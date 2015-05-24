package za.ac.cput.hospitalsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalsystem.domain.Doctor;
import za.ac.cput.hospitalsystem.repository.DoctorRepository;
import za.ac.cput.hospitalsystem.services.DoctorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    DoctorRepository repository;

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> allDoctors = new ArrayList<Doctor>();

        Iterable<Doctor> doctors = repository.findAll();
        for (Doctor doctor : doctors) {
            allDoctors.add(doctor);
        }
        return allDoctors;
    }

}
