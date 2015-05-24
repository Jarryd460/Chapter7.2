package za.ac.cput.hospitalsystem.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.hospitalsystem.config.factory.AppointmentFactory;
import za.ac.cput.hospitalsystem.config.factory.BillFactory;
import za.ac.cput.hospitalsystem.config.factory.PatientFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
public class TestAppointment {

    @Test
    public void testCreate() {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street1");
        Bill bill = BillFactory.createBill(100000);
        List<Bill> billList = new ArrayList<Bill>();
        billList.add(bill);
        Appointment appointment = AppointmentFactory.createAppointment(patient, 100000, billList);
        Assert.assertEquals("Jarryd", appointment.getPatient().getFirstName());
        Assert.assertEquals(Sex.Male, appointment.getPatient().getSex());
        Assert.assertEquals(100000, appointment.getBill().get(0).getAmount());
    }

    @Test
    public void testUpdate() {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street1");
        Bill bill = BillFactory.createBill(100000);
        List<Bill> billList = new ArrayList<Bill>();
        billList.add(bill);
        Appointment appointment = AppointmentFactory.createAppointment(patient, 100000, billList);
        Bill bill1 = BillFactory.createBill(20000);
        List<Bill> billList1 = new ArrayList<Bill>();
        billList1.add(bill1);
        Appointment appointmentCopy = new Appointment.Builder(appointment.getPatient()).copy(appointment).bill(billList1).build();
        Assert.assertEquals("Jarryd", appointmentCopy.getPatient().getFirstName());
        Assert.assertEquals(Sex.Male, appointmentCopy.getPatient().getSex());
        Assert.assertEquals(20000, appointmentCopy.getBill().get(0).getAmount());
    }
}
