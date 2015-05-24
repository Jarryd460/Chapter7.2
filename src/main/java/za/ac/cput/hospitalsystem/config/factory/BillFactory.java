package za.ac.cput.hospitalsystem.config.factory;

import za.ac.cput.hospitalsystem.domain.Bill;

/**
 * Created by student on 2015/05/13.
 */
public class BillFactory {

    public static Bill createBill(int amount) {

        Bill bill = new Bill.Builder(amount).build();
        return bill;

    }

}
