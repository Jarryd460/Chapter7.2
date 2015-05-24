package za.ac.cput.hospitalsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hospitalsystem.domain.Bill;
import za.ac.cput.hospitalsystem.repository.BillRepository;
import za.ac.cput.hospitalsystem.services.BillService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class BillServiceImpl implements BillService{

    @Autowired
    BillRepository repository;

    @Override
    public List<Bill> getBills() {
        List<Bill> allBills = new ArrayList<Bill>();

        Iterable<Bill> bills = repository.findAll();
        for (Bill bill : bills) {
            allBills.add(bill);
        }
        return allBills;
    }

}
