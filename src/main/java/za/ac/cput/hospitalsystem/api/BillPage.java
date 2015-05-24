package za.ac.cput.hospitalsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.hospitalsystem.domain.Bill;
import za.ac.cput.hospitalsystem.model.BillResource;
import za.ac.cput.hospitalsystem.services.BillService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
@RestController
@RequestMapping(value = "/bill/**")
public class BillPage {

    @Autowired
    private BillService service;

    @RequestMapping(value="/bills", method= RequestMethod.GET)

    public List<BillResource> getBills() {
        List<BillResource> hateos = new ArrayList<BillResource>();
        List<Bill> bills = service.getBills();
        for (Bill bill : bills) {
            BillResource res = new BillResource
                    .Builder(bill.getAmount())
                    .build();
            Link billsLink = new
                    Link("http://localhost:8080/bill/"+res.getResId().toString())
                    .withRel("bills");
            res.add(billsLink);
            hateos.add(res);
        }
        return hateos;
    }

}
