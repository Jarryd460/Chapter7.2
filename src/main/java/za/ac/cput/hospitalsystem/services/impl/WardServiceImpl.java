package za.ac.cput.hospitalsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalsystem.domain.Ward;
import za.ac.cput.hospitalsystem.repository.WardRepository;
import za.ac.cput.hospitalsystem.services.WardService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class WardServiceImpl implements WardService{

    @Autowired
    WardRepository repository;

    @Override
    public List<Ward> getWards() {
        List<Ward> allWards = new ArrayList<Ward>();

        Iterable<Ward> wards = repository.findAll();
        for (Ward ward : wards) {
            allWards.add(ward);
        }
        return allWards;
    }
}
