package za.ac.cput.hospitalsystem.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.hospitalsystem.config.factory.AppointmentFactory;
import za.ac.cput.hospitalsystem.config.factory.BillFactory;
import za.ac.cput.hospitalsystem.config.factory.DoctorFactory;
import za.ac.cput.hospitalsystem.config.factory.PatientFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/13.
 */
public class TestDoctor {

    @Test
    public void testCreate() {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street2");
        Bill bill = BillFactory.createBill(10000);
        List<Bill> billList = new ArrayList<Bill>();
        billList.add(bill);
        Appointment appointment = AppointmentFactory.createAppointment(patient, 10000, billList);
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList.add(appointment);
        Doctor doctor = DoctorFactory.createDoctor("Doctor", "Little", "Radiologist", appointmentList);
        Assert.assertEquals("Doctor", doctor.getFirstName());
        Assert.assertEquals("Radiologist", doctor.getSpecialization());
        Assert.assertEquals("Jarryd", doctor.getAppointments().get(0).getPatient().getFirstName());
    }

    @Test
    public void testUpdate() {
        Patient patient = PatientFactory.createPatient("Jarryd", "Deane", Sex.Male, 23, "1234567890", "Street2");
        Bill bill = BillFactory.createBill(10000);
        List<Bill> billList = new ArrayList<Bill>();
        billList.add(bill);
        Appointment appointment = AppointmentFactory.createAppointment(patient, 10000, billList);
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList.add(appointment);
        Doctor doctor = DoctorFactory.createDoctor("Doctor", "Little", "Radiologist", appointmentList);
        Doctor doctorCopy = new Doctor.Builder(doctor.getFirstName()).copy(doctor).specialization("Surgeon").build();
        Assert.assertEquals("Doctor", doctorCopy.getFirstName());
        Assert.assertEquals("Surgeon", doctorCopy.getSpecialization());
        Assert.assertEquals("Jarryd", doctorCopy.getAppointments().get(0).getPatient().getFirstName());
    }


}
